package site.timely.services.base.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户
 *
 * @author TianGanLin
 * @version 1.0.0, 2017/9/10
 * @since 1.8
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User implements java.io.Serializable {

    // Fields

    /**
     * 主键
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 用户名
     */
    @Column(length = 32, unique = true, nullable = false)
    private String username;        // 用户名

    /**
     * 密码
     */
    @Column(length = 32, nullable = false)
    private String password;        // 密码
    /**
     * 昵称
     */
    @Column
    private String nickname;        // 昵称
    /**
     * 真实姓名
     */
    @Column
    private String realname;        // 真实姓名
    /**
     * 身份证
     */
    @Column
    private String idnumber;        // 身份证
    /**
     * 头像
     */
    @Column
    private String icon;            // 头像
    /**
     * 头像(小图)
     */
    @Column
    private String iconSm;          // 头像(小图)
    /**
     * 性别
     */
    @Column
    private String sex;             // 性别
    /**
     * 生日
     */
    @Column
    @Temporal(TemporalType.DATE)
    private Date birthday;          // 生日
    /**
     * 录入时间
     */
    @Column
    @Temporal(TemporalType.DATE)
    private Date date;              // 录入时间
    /**
     * 手机号
     */
    @Column
    private String phone;           // 手机号
    /**
     * 权限
     */
    @Column
    private Integer power;          // 权限

    // Constructors

    /**
     * default constructor
     */
    public User() {
    }

    /**
     * minimal constructor
     */
    public User(String username) {
        this();
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIconSm() {
        return iconSm;
    }

    public void setIconSm(String iconSm) {
        this.iconSm = iconSm;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }
}