package cn.knowei.seckill.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author knowei
 * @date 2022/12/10 21:14
 */

@ToString
@Getter
@AllArgsConstructor
public enum RespBeanEnum {
    //通用状态码
    SUCCESS(200,"success"),
    ERROR(500,"服务端异常"),
    //登录模块5002xx
    SESSION_ERROR(500210,"session不存在或者已经失效"),
    LOGINVO_ERROR(500211,"用户名或者密码错误"),
    MOBILE_ERROR(500212,"手机号码格式错误"),
    //
    BIND_ERROR(500212, "参数校验异常"),

    EMPTY_STOCK(500500, "库存不足"),

    REPEATE_ERROR(500501, "该商品每人只限购买一次"),
    ;
    private final Integer code;
    private final String message;
}

