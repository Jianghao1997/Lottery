package cn.itedus.lottery.domain.activity.model.req;

import cn.itedus.lottery.domain.activity.model.aggregates.ActivityConfigRich;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Package: cn.itedus.lottery.domain.activity.model.req
 *
 * @Description：活动配置请求对象
 * @Author: 蒋豪
 * @Date: 2021.11.22 21:19
 * @Modified By:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActivityConfigReq {
    /**
     * 活动id
     */
    private Long activityId;
    /**
     * 活动配置信息
     */
    private ActivityConfigRich activityConfigRich;
}
