package cn.itedus.lottery.infrastructure.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Package: cn.itedus.lottery.infrastructure.po
 * Description：策略明细类
 * Author: 蒋豪
 * Date:  2021.10.29 21:21
 * Modified By:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StrategyDetail {
    /**
     * 自增id
     */
    private Long id;
    /**
     * 策略id
     */
    private Long strategyId;
    /**
     * 奖品id
     */
    private String awardId;
    /**
     * 奖品数量
     */
    private Integer awardCount;

    /**
     * 奖品名称
     */
    private String awardName;

    /**
     * 奖品剩余库存
     */
    private Integer awardSurplusCount;
    /**
     * 中奖概率
     */
    private BigDecimal awardRate;
    /**
     * 中奖描述
     */
    private String awardDesc;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
}
