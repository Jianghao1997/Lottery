package cn.itedus.lottery.domain.strategy.service.draw.impl;

import cn.itedus.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import cn.itedus.lottery.domain.strategy.service.draw.AbstractDrawBase;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Package: cn.itedus.lottery.domain.strategy.service.algorithm.draw.impl
 *
 * @Description：
 * @Author: 蒋豪
 * @Date: 2021.11.01 22:55
 * @Modified By:
 */
@Service("drawExec")
public class DrawExecImpl extends AbstractDrawBase {

    private Logger logger = LoggerFactory.getLogger(DrawExecImpl.class);

    /**
     * 获取不在抽奖范围内得列表，包括：奖品库存为空，风控策略，临时调整等，这类数据是含有业务逻辑的，所以需要具体的实现方式
     *
     * @param strategyId 策略id
     * @return 排除的奖品id集合
     */
    @Override
    protected List<String> queryExcludeAwardIds(Long strategyId) {
        List<String> awardList = strategyRepository.queryNoStockStrategyAwardList(strategyId);
        logger.info("执行抽奖策略 strategyId：{}，无库存排除奖品列表ID集合 awardList：{}", strategyId, JSON.toJSONString(awardList));
        return awardList;
    }

    /**
     * 执行抽奖算法
     *
     * @param strategyId      策略ID
     * @param drawAlgorithm   抽奖算法模型
     * @param excludeAwardIds 排除的抽奖ID集合
     * @return 中奖奖品ID
     */
    @Override
    protected String drawAlgorithm(Long strategyId, IDrawAlgorithm drawAlgorithm, List<String> excludeAwardIds) {
        // 执行抽奖
        String awardId = drawAlgorithm.randomDraw(strategyId, excludeAwardIds);

        // 判断抽奖结果
        if (null == awardId) {
            return null;
        }
        /*
         * 扣减库存，暂时采用数据库行级锁的方式进行扣减库存，后续优化为 Redis 分布式锁扣减 decr/incr
         * 注意：通常数据库直接锁行记录的方式并不能支撑较大体量的并发，但此种方式需要了解，因为在分库分表下的正常数据流量下的个人数据记录中，是可以使用行级锁的，因为他只影响到自己的记录，不会影响到其他人
         */
        boolean isSuccess = strategyRepository.deductStock(strategyId, awardId);

        // 返回结果，库存扣减成功返回奖品ID，否则返回NULL 「在实际的业务场景中，如果中奖奖品库存为空，则会发送兜底奖品，比如各类券」
        return isSuccess ? awardId : null;
    }
}
