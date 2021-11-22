package cn.itedus.lottery.domain.activity.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Package: cn.itedus.lottery.domain.activity.model.vo
 *
 * @Description：变更活动状态对象
 * @Author: 蒋豪
 * @Date: 2021.11.22 21:12
 * @Modified By:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlterStateVO {

    /**
     * 活动id
     */
    private Long activityId;

    /**
     * 更新前状态
     */
    private Integer beforeState;

    /**
     * 更新后状态
     */
    private Integer afterState;
}
