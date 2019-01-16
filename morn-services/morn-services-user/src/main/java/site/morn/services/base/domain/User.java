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
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;

/**
 * 用户
 *
 * @author timely-rain
 * @since 1.0.0, 2017/9/10
 */
@Data
@Entity
@Inheritance
@DynamicInsert
@DynamicUpdate
public class User implements java.io.Serializable {

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
  private String nickname;        // 姓名
  /**
   * 身份证
   */
  @Column(length = 18)
  private String idNumber;        // 身份证
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
   * 手机号
   */
  @Column
  private String phone;           // 手机号
  /**
   * 录入时间
   */
  @CreatedDate
  @Column
  @Temporal(TemporalType.DATE)
  private Date date;              // 创建时间
  /**
   * 角色
   */
  @ManyToMany
  @JoinColumn
  private Set<Role> roles;
}
