package cn.itedus.lottery.domain.strategy.service.goods.impl;

import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.domain.strategy.model.req.GoodsReq;
import cn.itedus.lottery.domain.strategy.model.res.DistributionRes;
import cn.itedus.lottery.domain.strategy.service.goods.DistributionBase;
import cn.itedus.lottery.domain.strategy.service.goods.IDistributionGoods;
import org.springframework.stereotype.Component;

/**
 * Package: cn.itedus.lottery.domain.strategy.service.goods.impl
 *
 * @Description：优惠券商品
 * @Author: 蒋豪
 * @Date: 2021.11.03 21:05
 * @Modified By:
 */
@Component
public class CouponGoods extends DistributionBase implements IDistributionGoods {
    /**
     * 奖品配送接口，奖品类型（1:文字描述、2:兑换码、3:优惠券、4:实物奖品）
     *
     * @param req 物品信息
     * @return 配送结果
     */
    @Override
    public DistributionRes doDistribution(GoodsReq req) {

        logger.info("模拟调用优惠券发放接口 uId：{} awardContent：{}", req.getUId(), req.getAwardContent());

        // 更新用户领奖结果
        super.updateUserAwardState(req.getUId(), req.getOrderId(), req.getAwardId(), Constants.AwardState.SUCCESS.getCode(), Constants.AwardState.SUCCESS.getInfo());

        return new DistributionRes(req.getUId(), Constants.AwardState.SUCCESS.getCode(), Constants.AwardState.SUCCESS.getInfo());
    }
}
