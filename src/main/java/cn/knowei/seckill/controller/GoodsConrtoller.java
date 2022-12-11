package cn.knowei.seckill.controller;

import cn.knowei.seckill.pojo.User;
import cn.knowei.seckill.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author knowei
 * @date 2022/12/10 22:51
 */
@Controller
@RequestMapping("goods")
public class GoodsConrtoller {

	@Autowired
	private UserService userService;

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
		return "goodList";
	}

}
