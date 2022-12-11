package cn.knowei.seckill.vo;

import cn.knowei.seckill.pojo.Goods;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author knowei
 * @date 2022/12/11 14:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsVo extends Goods {
	private BigDecimal seckillPrice;
	private Integer stockCount;
	private Date startDate;
	private Date endDate;

}
