package cn.knowei.seckill.controller;

import cn.knowei.seckill.pojo.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;

/**
 * @author knowei
 * @date 2022/12/10 22:51
 */
@Controller
@RequestMapping("goods")
public class GoodsConrtoller {

	@RequestMapping("toList")
	public String toList(HttpSession session, Model model, @CookieValue("userTicket") String ticket){
		System.out.println(ticket);
		if(StringUtils.isEmpty(ticket)){
			return "login";
		}
		User user = (User) session.getAttribute(ticket);
		System.out.println(user);
		if(user == null){
			return "login";
		}
		model.addAttribute("user", user);
		return "goodList";
	}

}
