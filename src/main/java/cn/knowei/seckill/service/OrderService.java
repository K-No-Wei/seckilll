package cn.knowei.seckill.service;

import cn.knowei.seckill.pojo.Order;
import cn.knowei.seckill.pojo.User;
import cn.knowei.seckill.vo.GoodsVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author knowei
 * @since 2022-12-11
 */
public interface OrderService extends IService<Order> {

	Order seckill(User user, GoodsVo goodsId);
}
