package cn.itedus.lottery.domain.strategy.service.factory;

import cn.itedus.lottery.domain.strategy.service.goods.IDistributionGoods;
import org.springframework.stereotype.Service;

/**
 * Package: cn.itedus.lottery.domain.strategy.service.algorithm.factory
 *
 * @Description：
 * @Author: 蒋豪
 * @Date: 2021.11.03 20:50
 * @Modified By:
 */
@Service
public class DistributionGoodsFactory extends GoodsConfig {

    public IDistributionGoods getDistributionGoodsService(Integer awardType) {
        return goodsMap.get(awardType);
    }
}
