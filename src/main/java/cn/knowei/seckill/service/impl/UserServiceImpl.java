package cn.knowei.seckill.service.impl;

import cn.knowei.seckill.exception.GlobalException;
import cn.knowei.seckill.mapper.UserMapper;
import cn.knowei.seckill.pojo.User;
import cn.knowei.seckill.service.UserService;
import cn.knowei.seckill.utils.CookieUtil;
import cn.knowei.seckill.utils.MD5Utils;
import cn.knowei.seckill.utils.UUIDUtil;
import cn.knowei.seckill.vo.LoginVo;
import cn.knowei.seckill.vo.RespBean;
import cn.knowei.seckill.vo.RespBeanEnum;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author knowei
 * @since 2022-12-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public RespBean doLogin(LoginVo login, HttpServletRequest request, HttpServletResponse response) {
        String mobile = login.getMobile();
        String password = login.getPassword();

//        if(StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)){
//            return RespBean.error(RespBeanEnum.LOGINVO_ERROR);
//        }
//
//        if(!ValidatorUtil.isMobile(mobile)){
//            return RespBean.error(RespBeanEnum.MOBILE_ERROR);
//        }

        User user = this.getById(mobile);
        if(user == null){
//            return RespBean.error(RespBeanEnum.LOGINVO_ERROR);
            //抛出全局异常处理
            throw new GlobalException(RespBeanEnum.LOGINVO_ERROR);
        }

        if(!MD5Utils.fromPassToDbPass(password, user.getSlat()).equals(user.getPasword())){
//            return RespBean.error(RespBeanEnum.LOGINVO_ERROR);
            throw new GlobalException(RespBeanEnum.LOGINVO_ERROR);
        }

        //生成cookie
        String ticket = UUIDUtil.uuid();
        request.getSession().setAttribute(ticket, user);
        CookieUtil.setCookie(request, response, "userTicket", ticket);
        return RespBean.success();
    }
}
