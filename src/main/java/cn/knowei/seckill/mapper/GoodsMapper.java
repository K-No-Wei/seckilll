package cn.knowei.seckill.mapper;

import cn.knowei.seckill.pojo.Goods;
import cn.knowei.seckill.vo.GoodsVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author knowei
 * @since 2022-12-11
 */
public interface GoodsMapper extends BaseMapper<Goods> {

	List<GoodsVo> findGoodsVo();

	GoodsVo findGoodsVoByGoodsId(Long goodsId);
}
