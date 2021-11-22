package cn.itedus.lottery.domain.strategy.service.algorithm.impl;

import cn.itedus.lottery.domain.strategy.model.vo.AwardRateInfo;
import cn.itedus.lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Package: cn.itedus.lottery.domain.strategy.service.algorithm.impl
 *
 * @Description： 必中奖策略抽奖，排掉已经中奖的概率，重新计算中奖范围
 * @Author: 蒋豪
 * @Date: 2021.11.01 21:55
 * @Modified By:
 */
@Component("entiretyRateRandomDrawAlgorithm")
public class EntiretyRateRandomDrawAlgorithm extends BaseAlgorithm {
    /**
     * SecureRandom 生成随机数，索引到对应的奖品信息返回结果
     *
     * @param strategyId      策略ID
     * @param excludeAwardIds
     * @return 中奖结果
     */
    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIds) {
        BigDecimal differenceDenominatotr = BigDecimal.ZERO;
        // 排除掉不在抽奖范围的奖品ID集合
        List<AwardRateInfo> differenceAwardRateList = new ArrayList<>();
        // 获取抽奖概率
        List<AwardRateInfo> awardrateIntervalValList = awardRateInfoMap.get(strategyId);
        for (AwardRateInfo awardRateInfo : awardrateIntervalValList) {
            String awardId = awardRateInfo.getAwardId();
            if (excludeAwardIds.contains(awardId)) {
                continue;
            }
            differenceAwardRateList.add(awardRateInfo);
            differenceDenominatotr = differenceDenominatotr.add(awardRateInfo.getAwardRate());
        }
        // 前置判断
        if (differenceAwardRateList.size() == 0) return null;
        if (differenceAwardRateList.size() == 1) return differenceAwardRateList.get(0).getAwardId();

        // 获取随机概率值
        int randomVal = this.generateSecureRandomIntCode(100);

        // 循环获取奖品
        String awardId = null;
        int cursorVal = 0;
        for (AwardRateInfo awardRateInfo : differenceAwardRateList) {
            int rateVal = awardRateInfo.getAwardRate().divide(differenceDenominatotr, 2, BigDecimal.ROUND_UP).multiply(new BigDecimal(100)).intValue();
            if (randomVal <= (cursorVal + rateVal)) {
                awardId = awardRateInfo.getAwardId();
                break;
            }
            cursorVal += rateVal;
        }
        // 返回中奖结果
        return awardId;
    }
}
