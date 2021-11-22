package cn.itedus.lottery.domain.strategy.model.aggregates;

import cn.itedus.lottery.domain.strategy.model.vo.StrategyBriefVO;
import cn.itedus.lottery.domain.strategy.model.vo.StrategyDetailBriefVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Package: cn.itedus.lottery.domain.strategy.model.aggregates
 *
 * @Description：
 * @Author: 蒋豪
 * @Date: 2021.11.01 22:45
 * @Modified By:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StrategyRich {
    /**
     * 策略id
     */
    private Long strategyId;
    /**
     * 策略配置
     */
    private StrategyBriefVO strategy;
    /**
     * 策略明细
     */
    private List<StrategyDetailBriefVO> strategyDetailList;
}
