package cn.knowei.seckill.service;

import cn.knowei.seckill.pojo.User;
import cn.knowei.seckill.vo.LoginVo;
import cn.knowei.seckill.vo.RespBean;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author knowei
 * @since 2022-12-10
 */
public interface UserService extends IService<User> {

    RespBean doLogin(LoginVo login, HttpServletRequest request, HttpServletResponse response);

    User getUserByCookie(String userTicket, HttpServletRequest request, HttpServletResponse response);
}
