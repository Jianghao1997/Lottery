package cn.itedus.lottery.test;

import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.domain.strategy.model.req.DrawReq;
import cn.itedus.lottery.domain.strategy.model.req.GoodsReq;
import cn.itedus.lottery.domain.strategy.model.res.DistributionRes;
import cn.itedus.lottery.domain.strategy.model.res.DrawResult;
import cn.itedus.lottery.domain.strategy.model.vo.DrawAwardInfo;
import cn.itedus.lottery.domain.strategy.service.draw.IDrawExec;
import cn.itedus.lottery.domain.strategy.service.factory.DistributionGoodsFactory;
import cn.itedus.lottery.domain.strategy.service.goods.IDistributionGoods;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringRunnerTest {

    private Logger logger = LoggerFactory.getLogger(SpringRunnerTest.class);

    @Resource
    private IDrawExec drawExec;

    @Resource
    private DistributionGoodsFactory distributionGoodsFactory;

    @Test
    public void test_drawExec() {
        drawExec.doDrawExec(new DrawReq("小傅哥", 10001L));
        drawExec.doDrawExec(new DrawReq("小佳佳", 10001L));
        drawExec.doDrawExec(new DrawReq("小蜗牛", 10001L));
        drawExec.doDrawExec(new DrawReq("八杯水", 10001L));
    }

    @Test
    public void test_award() {
        // 执行抽奖
        DrawResult drawResult = drawExec.doDrawExec(new DrawReq("小傅哥", 10001L));

        // 判断抽奖结果
        Integer drawState = drawResult.getDrawState();
        if (Constants.DrawState.FAIL.getCode().equals(drawState)) {
            logger.info("未中奖 DrawAwardInfo is null");
            return;
        }

        // 封装发奖参数，orderId：2109313442431 为模拟ID，需要在用户参与领奖活动时生成
        DrawAwardInfo drawAwardInfo = drawResult.getDrawAwardInfo();
        GoodsReq goodsReq = new GoodsReq(drawResult.getUId(), "2109313442431", drawAwardInfo.getAwardId(), drawAwardInfo.getAwardName(), drawAwardInfo.getAwardContent());

        // 根据 awardType 从抽奖工厂中获取对应的发奖服务
        IDistributionGoods distributionGoodsService = distributionGoodsFactory.getDistributionGoodsService(drawAwardInfo.getAwardType());
        DistributionRes distributionRes = distributionGoodsService.doDistribution(goodsReq);

        logger.info("测试结果：{}", JSON.toJSONString(distributionRes));
    }
}
