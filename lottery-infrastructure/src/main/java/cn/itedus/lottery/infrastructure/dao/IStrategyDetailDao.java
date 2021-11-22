package cn.itedus.lottery.infrastructure.dao;

import cn.itedus.lottery.infrastructure.po.StrategyDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Package: cn.itedus.lottery.infrastructure.dao
 *
 * @description: 策略明细表DAO
 * @Author: 蒋豪
 * @Date: 2021.11.01 22:23
 * @Modified By:
 */
@Mapper
public interface IStrategyDetailDao {
    /**
     * 根据策略id查询策略明细集合
     * @param strategyId
     * @return
     */
    List<StrategyDetail> queryStrategyDetailList(Long strategyId);

    /**
     * 查询无库存策略奖品ID
     * @param strategyId 策略id
     * @return 返回结果
     */
    List<String> queryNoStockStrategyAwardList(Long strategyId);

    /**
     *
     * @param strategyDetailReq 策略ID、奖品ID
     * @return
     */
    int deductStock(StrategyDetail strategyDetailReq);

    /**
     * 插入策略配置组
     * @param list 策略配置组
     */
    void insertList(List<StrategyDetail> list);
}
