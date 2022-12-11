package cn.knowei.seckill.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author knowei
 * @date 2022/12/10 16:13
 */
public class MD5Utils {

    private static final String salt = "zlw20020821";

    public static String md5(String str){
        return DigestUtils.md5Hex(str);
    }
    public static String inputPassFromPass(String inputPass){
        String str = "" + salt.charAt(0) + salt.charAt(2) + inputPass +
                salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    public static String fromPassToDbPass(String fromPass, String salt){
        String str = salt.charAt(0) + salt.charAt(2) + fromPass + salt.charAt(5) +salt.charAt(4);
        return md5(str);
    }

    public static String inputPassDBPass(String inputPass, String salt){
        String fromPass = inputPassFromPass(inputPass);
        String dbPass = fromPassToDbPass(fromPass, salt);
        return dbPass;
    }

    public static void main(String[] args) {
        System.out.println(inputPassFromPass("123456"));
        //066dd348f353270b2a41afbf047f3caf
        System.out.println(fromPassToDbPass("066dd348f353270b2a41afbf047f3caf", salt));
        //12cacb71d0b8591e8d3a16550f7aa589
        System.out.println(inputPassDBPass("123456", salt));
        //12cacb71d0b8591e8d3a16550f7aa589
    }

}
