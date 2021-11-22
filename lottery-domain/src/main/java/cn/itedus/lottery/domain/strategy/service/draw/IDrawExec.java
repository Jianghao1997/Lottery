package cn.itedus.lottery.domain.strategy.service.draw;

import cn.itedus.lottery.domain.strategy.model.req.DrawReq;
import cn.itedus.lottery.domain.strategy.model.res.DrawResult;
import org.springframework.stereotype.Service;

/**
 * Package: cn.itedus.lottery.domain.strategy.service.algorithm.draw
 *
 * @description: 抽奖执行接口
 * @Author: 蒋豪
 * @Date: 2021.11.01 22:54
 * @Modified By:
 */
public interface IDrawExec {
    /**
     * 抽奖方法 入口
     * @param req 抽奖参数；用户ID、策略ID
     * @return 中奖结果
     */
    DrawResult doDrawExec(DrawReq req);
}
