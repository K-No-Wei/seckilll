package cn.knowei.seckill.controller;


import cn.knowei.seckill.pojo.Order;
import cn.knowei.seckill.pojo.SeckillOrder;
import cn.knowei.seckill.pojo.User;
import cn.knowei.seckill.service.GoodsService;
import cn.knowei.seckill.service.OrderService;
import cn.knowei.seckill.service.SeckillGoodsService;
import cn.knowei.seckill.service.SeckillOrderService;
import cn.knowei.seckill.vo.GoodsVo;
import cn.knowei.seckill.vo.RespBeanEnum;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author knowei
 * @since 2022-12-11
 */
@Controller
@RequestMapping("seckill")
public class SeckillGoodsController {

	@Autowired
	private GoodsService goodsService;

	@Autowired
	private SeckillOrderService seckillOrderService;

	@Autowired
	private OrderService orderService;

	@RequestMapping("doSeckill")
	public String doSecKill(Model model, User user,Long goodsId){
		if(user == null){
			return "login";
		}
		model.addAttribute("user", user);
		GoodsVo goodsVo = goodsService.findGoodsVoByGoodsId(goodsId);
		if(goodsVo.getStockCount() < 1){
			model.addAttribute("errmsg", RespBeanEnum.EMPTY_STOCK.getMessage());
			return "secKillFail";
		}

		//判断是否重复抢购
		SeckillOrder seckillOrder = seckillOrderService.getOne(new LambdaQueryWrapper<SeckillOrder>().eq(SeckillOrder::getUserId, user.getId())
				.eq(SeckillOrder::getGoodsId, goodsId));
		if(seckillOrder != null){
			model.addAttribute("errmsg", RespBeanEnum.REPEATE_ERROR.getMessage());
			return "secKillFail";
		}

		Order order = orderService.seckill(user, goodsVo);
		model.addAttribute("order", order);
		model.addAttribute("goods", goodsVo);
		return "OrderDetail";
	}
}
