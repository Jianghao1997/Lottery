package cn.itedus.lottery.domain.strategy.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Package: cn.itedus.lottery.domain.strategy.model.vo
 *
 * @Description：策略明细简要信息
 * @Author: 蒋豪
 * @Date: 2021.11.22 20:44
 * @Modified By:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StrategyDetailBriefVO {
    /**
     * 策略ID
     */
    private Long strategyId;

    /**
     * 奖品ID
     */
    private String awardId;

    /**
     * 奖品名称
     */
    private String awardName;

    /**
     * 奖品库存
     */
    private Integer awardCount;

    /**
     * 奖品剩余库存
     */
    private Integer awardSurplusCount;

    /**
     * 中奖概率
     */
    private BigDecimal awardRate;
}
