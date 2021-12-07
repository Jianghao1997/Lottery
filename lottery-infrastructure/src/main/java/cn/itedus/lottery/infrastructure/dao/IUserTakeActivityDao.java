package cn.itedus.lottery.infrastructure.dao;

import cn.bugstack.middleware.db.router.annotation.DBRouter;
import cn.itedus.lottery.infrastructure.po.UserTakeActivity;
import org.apache.ibatis.annotations.Mapper;

/**
 * Package: cn.itedus.lottery.infrastructure.dao
 *
 * @Description：用户领取活动表DAO
 * @Author: 蒋豪
 * @Date: 2021.12.07 20:27
 * @Modified By:
 */
@Mapper
public interface IUserTakeActivityDao {
    /**
     * 插入用户领取活动信息
     *
     * @param userTakeActivity 入参
     */
    @DBRouter(key = "UId")
    void insert(UserTakeActivity userTakeActivity);
}
