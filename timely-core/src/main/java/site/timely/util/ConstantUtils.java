package site.timely.util;

import java.util.Objects;

/**
 * 常量工具类
 *
 * @author timely-rain
 * @verion 1.0.0, 2017/9/28
 * @see Constant
 * @since 1.0-SNAPSHOT
 */
public class ConstantUtils {
    /**
     * 判断是否管理员
     *
     * @param username 用户名
     * @return 是否管理员
     */
    public static boolean isAdmin(String username) {
        return Objects.equals(Constant.ADMIN, username);
    }
}
