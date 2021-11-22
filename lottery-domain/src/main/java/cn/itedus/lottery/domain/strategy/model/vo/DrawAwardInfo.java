package cn.itedus.lottery.domain.strategy.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Package: cn.itedus.lottery.domain.strategy.model.vo
 *
 * @Description：中奖奖品信息
 * @Author: 蒋豪
 * @Date: 2021.11.02 21:40
 * @Modified By:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DrawAwardInfo {
    /**
     * 奖品id
     */
    private String awardId;

    /**
     * 奖品类型（1:文字描述、2:兑换码、3:优惠券、4:实物奖品）
     */
    private Integer awardType;

    /**
     * 奖品名称
     */
    private String awardName;

    /**
     * 奖品内容 【描述，奖品码， sku】
     */
    private String awardContent;
}
