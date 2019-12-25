package club.maddm.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCrypt;


import java.util.UUID;

/**
 * 加密工具类
 */
public class CodecUtils {
    /**
     * md5加密
     * @param data 即将加密的数据
     * @param salt 盐
     * @return
     */
    @Deprecated
    public static String md5Hex(String data,String salt) {
        if (StringUtils.isBlank(salt)) {
            salt = data.hashCode() + "";
        }
        return DigestUtils.md5Hex(salt + DigestUtils.md5Hex(data));
    }

    /**
     * md5 16进制加密
     * @param data 即将加密的数据
     * @param salt 盐
     * @return
     */
    @Deprecated
    public static String shaHex(String data, String salt) {
        if (StringUtils.isBlank(salt)) {
            salt = data.hashCode() + "";
        }
        return DigestUtils.sha512Hex(salt + DigestUtils.sha512Hex(data));
    }

    /**
     * 生成盐的方法
     * @return
     */
    public static String generateSalt(){
        return BCrypt.gensalt(12);
    }

    /**
     * bCrypt方式加密
     * @param data 即将加密的数据
     * @return
     */
    public static String bCryptHashpw(String data) {
        return BCrypt.hashpw(data, BCrypt.gensalt());
    }

    /**
     * bCrypt方式加密
     * @param data 即将加密的数据
     * @return
     */
    public static String bCryptHashpw(String data,String salt) {
        return BCrypt.hashpw(data, salt);
    }

    /**
     * 比较是否相同
     * @param password 输入的密码
     * @param hashed 加密后的密码
     * @return
     */
    public static boolean bCryptCheckpw(String password,String hashed) {
        return BCrypt.checkpw(password, hashed);
    }
}