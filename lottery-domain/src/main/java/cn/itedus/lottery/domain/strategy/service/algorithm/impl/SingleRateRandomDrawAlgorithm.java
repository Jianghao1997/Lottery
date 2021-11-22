package cn.itedus.lottery.domain.strategy.service.algorithm.impl;

import cn.itedus.lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Package: cn.itedus.lottery.domain.strategy.service.algorithm.impl
 * Description：
 * Author: 蒋豪
 * Date:  2021.10.29 22:25
 * Modified By:
 */
@Component("singleRateRandomDrawAlgorithm")
public class SingleRateRandomDrawAlgorithm extends BaseAlgorithm {
    /**
     * SecureRandom 生成随机数，索引到对应的奖品信息返回结果
     *
     * @param strategyId 策略ID
     * @return 中奖结果
     */
    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIds) {
        String[] rateTuple = super.rateTupleMap.get(strategyId);
        assert rateTuple != null;
        int randomVal = this.generateSecureRandomIntCode(100);
        int idx = super.hashIdx(randomVal);
        String awardId = rateTuple[idx];
        if (excludeAwardIds.contains(awardId)) return "未中奖";

        // 如果中奖ID命中排除奖品列表，则返回NULL
        if (excludeAwardIds.contains(awardId)) return null;

        return awardId;
    }
}
