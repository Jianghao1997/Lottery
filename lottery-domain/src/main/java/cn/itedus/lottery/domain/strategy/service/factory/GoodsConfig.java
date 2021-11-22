package cn.itedus.lottery.domain.strategy.service.factory;

import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.domain.strategy.service.goods.IDistributionGoods;
import cn.itedus.lottery.domain.strategy.service.goods.impl.CouponGoods;
import cn.itedus.lottery.domain.strategy.service.goods.impl.DescGoods;
import cn.itedus.lottery.domain.strategy.service.goods.impl.PhysicalGoods;
import cn.itedus.lottery.domain.strategy.service.goods.impl.RedeemCodeGoods;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Package: cn.itedus.lottery.domain.strategy.service.factory
 *
 * @Description：
 * @Author: 蒋豪
 * @Date: 2021.11.03 20:51
 * @Modified By:
 */
public class GoodsConfig {

    protected static Map<Integer, IDistributionGoods> goodsMap = new ConcurrentHashMap<>();

    @Resource
    private DescGoods descGoods;

    @Resource
    private RedeemCodeGoods redeemCodeGoods;

    @Resource
    private CouponGoods couponGoods;

    @Resource
    private PhysicalGoods physicalGoods;

    @PostConstruct
    public void init() {
        goodsMap.put(Constants.AwardType.DESC.getCode(), descGoods);
        goodsMap.put(Constants.AwardType.RedeemCodeGoods.getCode(), redeemCodeGoods);
        goodsMap.put(Constants.AwardType.CouponGoods.getCode(), couponGoods);
        goodsMap.put(Constants.AwardType.PhysicalGoods.getCode(), physicalGoods);
    }
}
