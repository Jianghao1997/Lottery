package cn.itedus.lottery.infrastructure.dao;

import cn.itedus.lottery.domain.activity.model.vo.AlterStateVO;
import cn.itedus.lottery.infrastructure.po.Activity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 */
@Mapper
public interface IActivityDao {

   /**
    * 插入数据
    * @param req
    */
   void insert(Activity req);

   /**
    * 根据活动号查询活动信息
    * @param activityId
    * @return
    */
   Activity queryActivityById(Long activityId);

   /**
    * 变更活动状态
    * @param alterStateVO  [activityId、beforeState、afterState]
    * @return 更新数量
    */
   int alterState(AlterStateVO alterStateVO);
}
