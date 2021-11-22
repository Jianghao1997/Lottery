package cn.itedus.lottery.domain.strategy.service.draw;

import cn.itedus.lottery.domain.strategy.Repository.IStrategyRepository;
import cn.itedus.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.itedus.lottery.domain.strategy.model.vo.AwardBriefVO;

import javax.annotation.Resource;

/**
 * Package: cn.itedus.lottery.domain.strategy.service.algorithm.draw
 *
 * @Description：抽奖策略数据支撑， 一些通用的数据服务
 * @Author: 蒋豪
 * @Date: 2021.11.02 21:42
 * @Modified By:
 */
public class DrawStrategySupport extends DrawConfig {

    @Resource
    protected IStrategyRepository strategyRepository;

    /**
     * 查询策略配置信息
     * @param strategyId 策略id
     * @return 策略配置信息
     */
    protected StrategyRich queryStrategyRich(Long strategyId) {
        return strategyRepository.queryStrategyRich(strategyId);
    }

    /**
     * 查询奖品详情信息
     * @param awardId 奖品id
     * @return 中奖详情
     */
    protected AwardBriefVO queryAwardInfoByAwardId(String awardId) {
        return strategyRepository.queryAwardInfo(awardId);
    }

}
