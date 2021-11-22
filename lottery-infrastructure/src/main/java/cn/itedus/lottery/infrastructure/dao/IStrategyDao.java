package cn.itedus.lottery.infrastructure.dao;

import cn.itedus.lottery.infrastructure.po.Strategy;
import cn.itedus.lottery.infrastructure.po.StrategyDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Package: cn.itedus.lottery.infrastructure.dao
 *
 * @Description：策略配置DAO
 * @Author: 蒋豪
 * @Date: 2021.11.01 22:21
 * @Modified By:
 */
@Mapper
public interface IStrategyDao {
    /**
     * 根据策略id查询策略
     * @param strategyId
     * @return
     */
    Strategy queryStrategy(Long strategyId);

    /**
     * 插入策略配置
     * @param req 策略配置
     */
    void insert(Strategy req);
}
