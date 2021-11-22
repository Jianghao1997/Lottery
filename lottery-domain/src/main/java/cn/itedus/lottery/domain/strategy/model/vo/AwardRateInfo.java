package cn.itedus.lottery.domain.strategy.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Package: cn.itedus.lottery.domain.strategy.model.vo
 * Description：
 * Author: 蒋豪
 * Date:  2021.10.29 22:13
 * Modified By:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AwardRateInfo {

    private String awardId;

    private BigDecimal awardRate;
}
