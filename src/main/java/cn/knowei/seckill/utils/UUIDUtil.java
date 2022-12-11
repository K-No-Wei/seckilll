package cn.knowei.seckill.utils;

import java.util.UUID;

/**
 * @author knowei
 * @date 2022/12/10 22:45
 */

public class UUIDUtil {
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
