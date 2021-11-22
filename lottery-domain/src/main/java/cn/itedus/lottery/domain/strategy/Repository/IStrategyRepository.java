package cn.itedus.lottery.domain.strategy.Repository;

import cn.itedus.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.itedus.lottery.domain.strategy.model.vo.AwardBriefVO;

import java.util.List;

/**
 * Package: cn.itedus.lottery.domain.strategy.Repository
 *
 * @description: 策略表仓储服务
 * @Author: 蒋豪
 * @Date: 2021.11.01 22:43
 * @Modified By:
 */
public interface IStrategyRepository {

    StrategyRich queryStrategyRich(Long strategyId);

    AwardBriefVO queryAwardInfo(String awardId);

    List<String> queryNoStockStrategyAwardList(Long strategyId);

    /**
     * 扣减库存
     * @param strategyId 策略id
     * @param awardId 奖品id
     * @return 扣减结果
     */
    boolean deductStock(Long strategyId, String awardId);
}
