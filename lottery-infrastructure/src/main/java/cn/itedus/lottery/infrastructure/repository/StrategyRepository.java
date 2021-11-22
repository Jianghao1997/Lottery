package cn.itedus.lottery.infrastructure.repository;

import cn.itedus.lottery.domain.strategy.Repository.IStrategyRepository;
import cn.itedus.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.itedus.lottery.domain.strategy.model.vo.AwardBriefVO;
import cn.itedus.lottery.domain.strategy.model.vo.StrategyBriefVO;
import cn.itedus.lottery.domain.strategy.model.vo.StrategyDetailBriefVO;
import cn.itedus.lottery.infrastructure.dao.IAwardDao;
import cn.itedus.lottery.infrastructure.dao.IStrategyDao;
import cn.itedus.lottery.infrastructure.dao.IStrategyDetailDao;
import cn.itedus.lottery.infrastructure.po.Award;
import cn.itedus.lottery.infrastructure.po.Strategy;
import cn.itedus.lottery.infrastructure.po.StrategyDetail;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Package: cn.itedus.lottery.domain.strategy.Repository.impl
 *
 * @Description：
 * @Author: 蒋豪
 * @Date: 2021.11.01 22:49
 * @Modified By:
 */
@Component
public class StrategyRepository implements IStrategyRepository {
    @Resource
    private IStrategyDao strategyDao;
    @Resource
    private IStrategyDetailDao strategyDetailDao;
    @Resource
    private IAwardDao awardDao;

    @Override
    public StrategyRich queryStrategyRich(Long strategyId) {
        Strategy strategy = strategyDao.queryStrategy(strategyId);
        List<StrategyDetail> strategyDetailList = strategyDetailDao.queryStrategyDetailList(strategyId);

        StrategyBriefVO strategyBriefVO = new StrategyBriefVO();
        BeanUtils.copyProperties(strategy, strategyBriefVO);

        List<StrategyDetailBriefVO> strategyDetailBriefVOList = new ArrayList<>();

        for (StrategyDetail strategyDetail : strategyDetailList) {
            StrategyDetailBriefVO strategyDetailBriefVO = new StrategyDetailBriefVO();
            BeanUtils.copyProperties(strategyDetail, strategyDetailBriefVO);
            strategyDetailBriefVOList.add(strategyDetailBriefVO);
        }
        return new StrategyRich(strategyId, strategyBriefVO, strategyDetailBriefVOList);
    }

    @Override
    public AwardBriefVO queryAwardInfo(String awardId) {
        Award award = awardDao.queryAwardInfo(awardId);
        // 可以使用 BeanUtils.copyProperties(award, awardBriefVO)、或者基于ASM实现的Bean-Mapping，但在效率上最好的依旧是硬编码
        return AwardBriefVO.builder()
                .awardId(award.getAwardId())
                .awardType(award.getAwardType())
                .awardName(award.getAwardName())
                .awardContent(award.getAwardContent())
                .build();
    }

    @Override
    public List<String> queryNoStockStrategyAwardList(Long strategyId) {
        return strategyDetailDao.queryNoStockStrategyAwardList(strategyId);
    }

    /**
     * 扣减库存
     *
     * @param strategyId 策略id
     * @param awardId    奖品id
     * @return 扣减结果
     */
    @Override
    public boolean deductStock(Long strategyId, String awardId) {
        StrategyDetail strategyDetail = new StrategyDetail()
                .builder()
                .strategyId(strategyId)
                .awardId(awardId).build();
        int count = strategyDetailDao.deductStock(strategyDetail);
        return count == 1;
    }
}
