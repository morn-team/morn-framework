package site.morn.services.base.domain;

import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * 用户
 *
 * @author TianGanLin
 * @version 1.0.0, 2017/9/10
 * @since 1.0-SNAPSHOT
 */
@Entity
@Inheritance
@DynamicInsert
@DynamicUpdate
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
  @NotNull
  @Size(min = 4, max = 32)
  private String username;        // 用户名
  /**
   * 密码
   */
  @Column(length = 32, nullable = false)
  @NotNull
  @Size(min = 4, max = 32)
  private String password;        // 密码
  /**
   * 昵称
   */
  @Column(length = 32)
  private String nickname;        // 昵称
  /**
   * 真实姓名
   */
  @Column(length = 32)
  private String realname;        // 真实姓名
  /**
   * 身份证
   */
  @Column(length = 18)
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
  @Column(nullable = false)
  @Temporal(TemporalType.DATE)
  private Date date;              // 创建时间
  /**
   * 手机号
   */
  @Column
  private String phone;           // 手机号
  /**
   * 角色
   */
  @ManyToMany
  @JoinColumn
  private Set<Role> roles;

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

  // Getter And Setter

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

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }
}
