package cn.knowei.seckill.exception;

import cn.knowei.seckill.vo.RespBean;
import cn.knowei.seckill.vo.RespBeanEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author knowei
 * @date 2022/12/10 22:29
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GlobalException extends RuntimeException{
    private RespBeanEnum respBeanEnum;
}
