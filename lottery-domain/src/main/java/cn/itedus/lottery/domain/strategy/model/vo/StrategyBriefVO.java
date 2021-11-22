package cn.itedus.lottery.domain.strategy.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Package: cn.itedus.lottery.domain.strategy.model.vo
 *
 * @Description：策略简要信息
 * @Author: 蒋豪
 * @Date: 2021.11.22 20:42
 * @Modified By:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StrategyBriefVO {
    /**
     * 策略ID
     */
    private Long strategyId;

    /**
     * 策略描述
     */
    private String strategyDesc;

    /**
     * 策略方式「1:单项概率、2:总体概率」
     */
    private Integer strategyMode;

    /**
     * 发放奖品方式「1:即时、2:定时[含活动结束]、3:人工」
     */
    private Integer grantType;

    /**
     * 发放奖品时间
     */
    private Date grantDate;

    /**
     * 扩展信息
     */
    private String extInfo;
}
