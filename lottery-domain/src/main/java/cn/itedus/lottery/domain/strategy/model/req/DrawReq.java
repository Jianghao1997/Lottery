package cn.itedus.lottery.domain.strategy.model.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Package: cn.itedus.lottery.domain.strategy.model.req
 *
 * @Description：
 * @Author: 蒋豪
 * @Date: 2021.11.01 22:46
 * @Modified By:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DrawReq {
    /**
     * 用户ID
     */
    private String uId;

    /**
     * 策略ID
     */
    private Long strategyId;
}
