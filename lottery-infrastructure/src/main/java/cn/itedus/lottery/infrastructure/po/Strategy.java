package cn.itedus.lottery.infrastructure.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Package: cn.itedus.lottery.infrastructure.po
 * Description：策略类
 * Author: 蒋豪
 * Date:  2021.10.29 21:15
 * Modified By:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Strategy {
    /**
     * 自增id
     */
    private Long id;
    /**
     * 策略id
     */
    private Long strategyId;
    /**
     * 策略描述
     */
    private String strategyDesc;
    /**
     * 策略方式 【1：单项概率 2：总体概率】
     */
    private Integer strategyMode;
    /**
     * 发放奖品方式 【1：即时 2：定时（含活动结束）3：人工】
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
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
}
