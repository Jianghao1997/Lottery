package cn.itedus.lottery.domain.activity.service.deploy.impl;

import cn.itedus.lottery.domain.activity.model.aggregates.ActivityConfigRich;
import cn.itedus.lottery.domain.activity.model.req.ActivityConfigReq;
import cn.itedus.lottery.domain.activity.model.vo.ActivityVO;
import cn.itedus.lottery.domain.activity.model.vo.AwardVO;
import cn.itedus.lottery.domain.activity.model.vo.StrategyDetailVO;
import cn.itedus.lottery.domain.activity.model.vo.StrategyVO;
import cn.itedus.lottery.domain.activity.repository.IActivityRepository;
import cn.itedus.lottery.domain.activity.service.deploy.IActivityDeploy;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Package: cn.itedus.lottery.domain.activity.service.deploy.impl
 *
 * @Description：部署活动配置服务
 * @Author: 蒋豪
 * @Date: 2021.11.22 21:29
 * @Modified By:
 */
@Service
public class ActivityDeployImpl implements IActivityDeploy {

    private Logger logger = LoggerFactory.getLogger(ActivityDeployImpl.class);

    @Resource
    private IActivityRepository activityRepository;
    /**
     * 创建活动信息
     *
     * @param req 活动配置信息
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void createActivity(ActivityConfigReq req) {

        logger.info("创建活动配置开始，activityId：【{}】", req.getActivityId());
        ActivityConfigRich activityConfigRich = req.getActivityConfigRich();
        try {
            // 添加活动配置
            ActivityVO activity = activityConfigRich.getActivity();
            activityRepository.addActivity(activity);

            // 添加奖品配置
            List<AwardVO> awardList = activityConfigRich.getAwardList();
            activityRepository.addAward(awardList);

            // 添加策略配置
            StrategyVO strategy = activityConfigRich.getStrategy();
            activityRepository.addStrategy(strategy);

            // 添加策略明细配置
            List<StrategyDetailVO> strategyDetailList = activityConfigRich.getStrategy().getStrategyDetailList();
            activityRepository.addStrategyDetailList(strategyDetailList);
            logger.info("创建活动配置完成，activityId：【{}】", req.getActivityId());
        } catch (DuplicateKeyException e) {
            logger.error("创建活动配置失败，唯一索引冲突 activityId：{} reqJson：{}", req.getActivityId(), JSON.toJSONString(req), e);
            throw e;
        }

    }

    /**
     * 修改活动信息
     *
     * @param req 活动配置信息
     */
    @Override
    public void updateActivity(ActivityConfigReq req) {
        // TODO: 非核心功能后续补充
    }
}
