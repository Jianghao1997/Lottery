package cn.itedus.lottery.infrastructure.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Package: cn.itedus.lottery.infrastructure.po
 *
 * @Description：
 * @Author: 蒋豪
 * @Date: 2021.11.01 22:14
 * @Modified By:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Award {
    /**
     * 自增ID
     */
    private Long id;

    /**
     * 奖品ID
     */
    private String awardId;

    /**
     * 奖品类型（文字描述、兑换码、优惠券、实物奖品暂无）
     */
    private Integer awardType;

    /**
     * 奖品名称
     */
    private String awardName;

    /**
     * 奖品内容「文字描述、Key、码」
     */
    private String awardContent;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;
}
