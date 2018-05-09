package site.timely.exception;

/**
 * 异常常量
 *
 * @author timely-rain
 * @verion 1.0.0, 2017/10/10
 * @since 1.0-SNAPSHOT
 */
public interface ExceptionConstant {
    /**
     * 默认异常码，当获取指定异常码国际化信息为空时使用
     */
    String DEFAULT_CODE = "default";

    /************************ 平台公共异常从00000-09999 ************************/
    /**
     * session超时
     */
    String SESSION_TIMEOUT = "00000";

    /**
     * 数据库无法连接
     */
    String DB_NOT_CONNECT = "00023";

    /**
     * 记录已删除
     */
    String RECORD_DELETE = "00001";

    /**
     * 编号重复
     */
    String CODE_REPEAT = "00002";

    /**
     * 名称重复
     */
    String NAME_REPEAT = "00003";

    /**
     * 记录存在子节点
     */
    String RECORD_HAS_CHILD = "00004";

    /**
     * 系统默认数据
     */
    String SYS_RECORD = "00005";

    /**
     * 用户名、密码相同
     */
    String PASSWORD_USERNAME_SAME = "00006";

    /**
     * 密码长度不符合要求
     */
    String PASSWORD_LENGTH_NOT_MATCH = "00007";

    /**
     * 密码字符种类不符合要求
     */
    String PASSWORD_CHARACTER_TYPE_NOT_MATCH = "00008";

    /**
     * 密码和原来的一样
     */
    String PASSWORD_SAME_AS_PREVIOUS = "00009";

    /**
     * 过多的密码字符重复
     */
    String PASSWORD_CHARACTER_REPEAT_OVER_MAX = "00010";

    /**
     * 原密码不正确
     */
    String PASSWORD_INCORRECT = "00011";

    /**
     * 密码太弱
     */
    String PASSWORD_TOO_WEAK = "00012";

    /**
     * 无法删除
     */
    String CAN_NOT_DELETE = "00013";

    /**
     * 关联类型已删除
     */
    String DEVICETYPE_IS_DELETE = "00015";

    /**
     * 新密码与之前修改过的密码有重复
     */
    String PWD_REPEATED = "00016";

    /**
     * 密码错误
     */
    String PASSWORD_ERROR = "00019";

    /**
     * 邮件未发送
     */
    String MAIL_SEND_ERROR = "00100";

    /**
     * 数据库外键约束
     */
    String DB_FOREIGN_KEY_ERROR = "00101";

    /**
     * 资产编号已存在
     */
    String ASSETNUM_REPEAT = "00109";

    /**
     * 没有权限访问
     */
    String NO_PRIVILEGE = "09999";
}
