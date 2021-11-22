package cn.itedus.lottery.domain.activity.service.stateflow.impl;

import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.common.Result;
import cn.itedus.lottery.domain.activity.service.stateflow.IStateHandler;
import cn.itedus.lottery.domain.activity.service.stateflow.StateConfig;
import org.springframework.stereotype.Service;

/**
 * Package: cn.itedus.lottery.domain.activity.service.stateflow.impl
 *
 * @Description：状态处理服务
 * @Author: 蒋豪
 * @Date: 2021.11.22 20:36
 * @Modified By:
 */
@Service
public class StateHandlerImpl extends StateConfig implements IStateHandler {
    /**
     * 提审
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     * @return 审核结果
     */
    @Override
    public Result arraignment(Long activityId, Enum<Constants.ActivityState> currentStatus) {
        return stateGroup.get(currentStatus).arraignment(activityId, currentStatus);
    }

    /**
     * 审核通过
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     * @return 审核结果
     */
    @Override
    public Result checkPass(Long activityId, Enum<Constants.ActivityState> currentStatus) {
        return stateGroup.get(currentStatus).checkPass(activityId, currentStatus);
    }

    /**
     * 审核拒绝
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     * @return 审核结果
     */
    @Override
    public Result checkRefuse(Long activityId, Enum<Constants.ActivityState> currentStatus) {
        return stateGroup.get(currentStatus).checkRefuse(activityId, currentStatus);
    }

    /**
     * 撤销审核
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     * @return 审核结果
     */
    @Override
    public Result checkRevoke(Long activityId, Enum<Constants.ActivityState> currentStatus) {
        return stateGroup.get(currentStatus).checkRevoke(activityId, currentStatus);
    }

    /**
     * 关闭
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     * @return 审核结果
     */
    @Override
    public Result close(Long activityId, Enum<Constants.ActivityState> currentStatus) {
        return stateGroup.get(currentStatus).close(activityId, currentStatus);
    }

    /**
     * 开启
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     * @return 审核结果
     */
    @Override
    public Result open(Long activityId, Enum<Constants.ActivityState> currentStatus) {
        return stateGroup.get(currentStatus).open(activityId, currentStatus);
    }

    /**
     * 运行活动中
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     * @return 审核结果
     */
    @Override
    public Result doing(Long activityId, Enum<Constants.ActivityState> currentStatus) {
        return stateGroup.get(currentStatus).doing(activityId, currentStatus);
    }
}
