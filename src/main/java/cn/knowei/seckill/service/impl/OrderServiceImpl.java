package cn.knowei.seckill.service.impl;
import java.math.BigDecimal;
import java.util.Date;

import cn.knowei.seckill.pojo.Order;
import cn.knowei.seckill.mapper.OrderMapper;
import cn.knowei.seckill.pojo.SeckillGoods;
import cn.knowei.seckill.pojo.SeckillOrder;
import cn.knowei.seckill.pojo.User;
import cn.knowei.seckill.service.OrderService;
import cn.knowei.seckill.service.SeckillGoodsService;
import cn.knowei.seckill.service.SeckillOrderService;
import cn.knowei.seckill.vo.GoodsVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author knowei
 * @since 2022-12-11
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

	@Autowired
	private SeckillGoodsService seckillGoodsService;

	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private SeckillOrderService seckillOrderService;

	@Override
	public Order seckill(User user, GoodsVo goodsVo) {
		SeckillGoods seckillGoods = seckillGoodsService.getOne(new LambdaQueryWrapper<SeckillGoods>()
				.eq(SeckillGoods::getGoodsId, goodsVo.getId()));

		seckillGoods.setStockCount(seckillGoods.getStockCount() - 1);
		seckillGoodsService.updateById(seckillGoods);

		Order order = new Order();
		order.setUserId(user.getId());
		order.setGoodsId(goodsVo.getId());
		order.setDeliveryAddrId(0L);
		order.setGoodsName(goodsVo.getGoodsName());
		order.setGoodsCount(1);
		order.setGoodsPrice(seckillGoods.getSeckillPrice());
		order.setOrderChannel(1);
		order.setStatus(0);
		order.setCreateDate(new Date());
		orderMapper.insert(order);

		SeckillOrder seckillOrder = new SeckillOrder();
		seckillOrder.setUserId(user.getId());
		seckillOrder.setOrderId(order.getId());
		seckillOrder.setGoodsId(goodsVo.getId());

		seckillOrderService.save(seckillOrder);


		return order;
	}
}
