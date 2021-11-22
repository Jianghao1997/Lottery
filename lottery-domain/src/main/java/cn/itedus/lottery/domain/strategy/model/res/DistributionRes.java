package cn.itedus.lottery.domain.strategy.model.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Package: cn.itedus.lottery.domain.strategy.model.res
 *
 * @Description：商品配送结果
 * @Author: 蒋豪
 * @Date: 2021.11.03 20:59
 * @Modified By:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DistributionRes {
    /**
     * 用户ID
     * */
    private String uId;

    /**
     * 编码
     */
    private Integer code;

    /**
     * 描述
     */
    private String info;

    /** 结算单ID，如：发券后有券码、发货后有单号等，用于存根查询 */
    private String statementId;

    public DistributionRes(String uId, Integer code, String info) {
        this.uId = uId;
        this.code = code;
        this.info = info;
    }
}
