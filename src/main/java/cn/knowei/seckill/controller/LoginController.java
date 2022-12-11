package cn.knowei.seckill.controller;

import cn.knowei.seckill.service.UserService;
import cn.knowei.seckill.vo.LoginVo;
import cn.knowei.seckill.vo.RespBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author knowei
 * @date 2022/12/10 20:33
 */
@Controller
@RequestMapping("login")
@Slf4j
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("toLogin")
    public String toLogin(){
        return "login";
    }

    @PostMapping("doLogin")
    @ResponseBody
    public RespBean doLogin(@Valid LoginVo login, HttpServletRequest request, HttpServletResponse response){
        log.info("{}", login);
        return userService.doLogin(login, request, response);
    }
}
