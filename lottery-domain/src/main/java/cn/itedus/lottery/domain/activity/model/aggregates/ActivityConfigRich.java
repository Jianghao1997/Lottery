package cn.itedus.lottery.domain.activity.model.aggregates;

import cn.itedus.lottery.domain.activity.model.vo.ActivityVO;
import cn.itedus.lottery.domain.activity.model.vo.AwardVO;
import cn.itedus.lottery.domain.activity.model.vo.StrategyVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Package: cn.itedus.lottery.domain.activity.model.aggregates
 *
 * @Description：活动配置聚合信息
 * @Author: 蒋豪
 * @Date: 2021.11.22 21:16
 * @Modified By:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActivityConfigRich {

    /**
     * 活动配置
     */
    private ActivityVO activity;
    /**
     * 策略配置(含策略明细)
     */
    private StrategyVO strategy;
    /**
     * 奖品配置
     */
    private List<AwardVO> awardList;
}
