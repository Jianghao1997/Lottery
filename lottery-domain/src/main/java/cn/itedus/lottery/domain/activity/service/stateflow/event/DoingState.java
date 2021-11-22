package cn.itedus.lottery.domain.activity.service.stateflow.event;

import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.common.Result;
import cn.itedus.lottery.domain.activity.service.stateflow.AbstractState;
import org.springframework.stereotype.Component;

/**
 * Package: cn.itedus.lottery.domain.activity.service.stateflow.event
 *
 * @Description：
 * @Author: 蒋豪
 * @Date: 2021.11.22 20:35
 * @Modified By:
 */
@Component
public class DoingState extends AbstractState {
    /**
     * 活动提审
     *
     * @param activityId   活动ID
     * @param currentState 当前状态
     * @return 执行结果
     */
    @Override
    public Result arraignment(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "活动中不可提审");
    }

    /**
     * 审核通过
     *
     * @param activityId   活动ID
     * @param currentState 当前状态
     * @return 执行结果
     */
    @Override
    public Result checkPass(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "活动中不可审核拒绝");
    }

    /**
     * 审核拒绝
     *
     * @param activityId   活动ID
     * @param currentState 当前状态
     * @return 执行结果
     */
    @Override
    public Result checkRefuse(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "活动中不可审核拒绝");
    }

    /**
     * 撤审撤销
     *
     * @param activityId   活动ID
     * @param currentState 当前状态
     * @return 执行结果
     */
    @Override
    public Result checkRevoke(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "活动中不可撤销审核");
    }

    /**
     * 活动关闭
     *
     * @param activityId   活动ID
     * @param currentState 当前状态
     * @return 执行结果
     */
    @Override
    public Result close(Long activityId, Enum<Constants.ActivityState> currentState) {
        boolean isSuccess = activityRepository.alterStatus(activityId, currentState, Constants.ActivityState.CLOSE);
        return isSuccess ? Result.buildResult(Constants.ResponseCode.SUCCESS, "活动关闭成功") : Result.buildErrorResult("活动状态变更失败");
    }

    /**
     * 活动开启
     *
     * @param activityId   活动ID
     * @param currentState 当前状态
     * @return 执行结果
     */
    @Override
    public Result open(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "活动中不可开启");
    }

    /**
     * 活动执行
     *
     * @param activityId   活动ID
     * @param currentState 当前状态
     * @return 执行结果
     */
    @Override
    public Result doing(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "活动中不可重复执行");
    }
}
