package site.morn.framework.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldNameConstants;
import site.morn.boot.support.entity.OrganizedEntity;
import site.morn.constant.MetricUnit.Text;
import site.morn.validate.group.Add;
import site.morn.validate.group.Login;
import site.morn.validate.group.Update;

/**
 * 用户基础映射类
 *
 * @author timely-rain
 * @since 1.0.2, 2019/4/16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@FieldNameConstants
@MappedSuperclass
public class BaseUser extends OrganizedEntity implements Serializable {

  /**
   * @serialField
   */
  private static final long serialVersionUID = 1L;

  /**
   * 主键
   */
  @Id
  @GeneratedValue
  private Long id;
  /**
   * 用户名
   */
  @Column(length = Text.SHORT)
  @NotNull(groups = {Add.class, Update.class, Login.class})
  @Size(min = 4, max = Text.SHORT)
  private String username;
  /**
   * 密码
   */
  @Column(nullable = false)
  @NotNull(groups = Add.class)
  @Size(min = 4, max = 64)
  private String password;
  /**
   * 编码
   */
  @Size(max = 32)
  @Column(length = 32)
  private String code;
  /**
   * 昵称
   */
  @Column(length = 32)
  private String nickname;
  /**
   * 身份证
   */
  @Column(length = 18)
  private String idNumber;
  /**
   * 头像
   */
  @Lob
  @Column
  private String icon;
  /**
   * 头像(小图)
   */
  @Column
  private String iconSm;
  /**
   * 性别
   */
  @Column
  private String sex;
  /**
   * 生日
   */
  @Column
  @Temporal(TemporalType.DATE)
  private Date birthday;
  /**
   * 手机
   */
  @Column
  private String phone;
  /**
   * 地址
   */
  @Column
  private String address;
  /**
   * 邮箱
   */
  @Column
  private String email;
  /**
   * 备注
   */
  @Size(max = Text.NORMAL)
  @Column
  private String description;
}
