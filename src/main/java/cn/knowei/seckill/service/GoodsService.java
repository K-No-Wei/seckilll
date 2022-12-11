package cn.knowei.seckill.service;

import cn.knowei.seckill.pojo.Goods;
import cn.knowei.seckill.vo.GoodsVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author knowei
 * @since 2022-12-11
 */
public interface GoodsService extends IService<Goods> {

	List<GoodsVo> findGoodsVo();

	GoodsVo findGoodsVoByGoodsId(Long goodsId);
}
