package cn.itedus.lottery.infrastructure.dao;

import cn.itedus.lottery.infrastructure.po.Award;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Package: cn.itedus.lottery.infrastructure.dao
 *
 * @Description：奖品信息Dao
 * @Author: 蒋豪
 * @Date: 2021.11.01 22:19
 * @Modified By:
 */
@Mapper
public interface IAwardDao {
    /**
     * 根据奖品id查询奖品
     * @param awardID
     * @return
     */
    Award queryAwardInfo(String awardID);

    /**
     *
     * @param list
     */
    void insertList(List<Award> list);
}
