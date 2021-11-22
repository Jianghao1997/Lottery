package cn.itedus.lottery.domain.activity.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * Package: cn.itedus.lottery.domain.activity.model.vo
 *
 * @Description：
 * @Author: 蒋豪
 * @Date: 2021.11.22 21:24
 * @Modified By:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StrategyVO {
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

    /**
     * 策略详细配置
     */
    private List<StrategyDetailVO> strategyDetailList;
}
