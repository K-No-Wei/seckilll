package cn.knowei.seckill.exception;

import cn.knowei.seckill.vo.RespBean;
import cn.knowei.seckill.vo.RespBeanEnum;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author knowei
 * @date 2022/12/10 22:30
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public RespBean Exception(Exception e){
        if(e instanceof GlobalException){
            GlobalException ex = (GlobalException) e;
            return  RespBean.error(ex.getRespBeanEnum());
        } else if (e instanceof  BindException) {
            BindException ex = (BindException) e;
            RespBean error = RespBean.error(RespBeanEnum.BIND_ERROR);
            error.setMessage("参数校验异常" + ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
            return  error;
        }
        return RespBean.error(RespBeanEnum.ERROR);
    }
}
