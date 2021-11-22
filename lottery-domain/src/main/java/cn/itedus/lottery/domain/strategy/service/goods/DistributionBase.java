package cn.itedus.lottery.domain.strategy.service.goods;

import cn.itedus.lottery.domain.strategy.Repository.IAwardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * Package: cn.itedus.lottery.domain.strategy.service.goods
 *
 * @Description：配送货物基础共用类
 * @Author: 蒋豪
 * @Date: 2021.11.03 20:52
 * @Modified By:
 */
public class DistributionBase {

    protected Logger logger = LoggerFactory.getLogger(DistributionBase.class);

    @Resource
    private IAwardRepository awardRepository;

    protected void updateUserAwardState(String uId, String orderId, String awardId, Integer awardState, String awardStateInfo) {

        // TODO 后期添加更新分库分表中，用户个人的抽奖记录表中奖品发奖状态
        logger.info("TODO 后期添加更新分库分表中，用户个人的抽奖记录表中奖品发奖状态 uId：{}", uId);
    }
}
