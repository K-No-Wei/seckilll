package cn.knowei.seckill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author knowei
 * @date 2022/12/10 15:50
 */
@RestController
public class DemoController {

    @RequestMapping("test")
    public String test(){
        return "Hello";
    }
}
