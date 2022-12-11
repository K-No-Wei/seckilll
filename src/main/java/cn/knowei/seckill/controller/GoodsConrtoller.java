package cn.knowei.seckill.controller;

import cn.knowei.seckill.pojo.Goods;
import cn.knowei.seckill.pojo.User;
import cn.knowei.seckill.service.GoodsService;
import cn.knowei.seckill.service.UserService;
import cn.knowei.seckill.vo.GoodsVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author knowei
 * @date 2022/12/10 22:51
 */
@Controller
@RequestMapping("goods")
@Slf4j
public class GoodsConrtoller {

	@Autowired
	private UserService userService;

	@Autowired
	private GoodsService goodsService;

	@RequestMapping("toList")
	public String toList(Model model, User user){
//		if(StringUtils.isEmpty(ticket)){
//			return "login";
//		}
//
//		User user = userService.getUserByCookie(ticket, request, response);
////		User user = (User) session.getAttribute(ticket);
		if(user == null){
			return "login";
		}
		model.addAttribute("user", user);
		model.addAttribute("goodsList", goodsService.findGoodsVo());
		return "goodList";
	}

	@RequestMapping("toDetail/{goodsId}")
	public String toDetail(Model model, User user, @PathVariable Long goodsId){
		model.addAttribute("user", user);

		GoodsVo voByGoodsId = goodsService.findGoodsVoByGoodsId(goodsId);
		Date startDate = voByGoodsId.getStartDate();
		Date endDate = voByGoodsId.getEndDate();
		Date nowDate = new Date();
		int secKillStatus;
		int remainSeconds = 0;
		//秒杀未开始
		if(nowDate.before(startDate)){
			secKillStatus = 0;
			remainSeconds = (int) ((startDate.getTime() - nowDate.getTime()) / 1000);
		} else if (nowDate.after(endDate)) {
			secKillStatus = 2;
			remainSeconds =-1;
		}else {
			secKillStatus = 1;
		}

		model.addAttribute("goods", voByGoodsId);
		model.addAttribute("secKillStatus", secKillStatus);
		model.addAttribute("remainSeconds", remainSeconds);

		return "goodsDetail";
	}
}
