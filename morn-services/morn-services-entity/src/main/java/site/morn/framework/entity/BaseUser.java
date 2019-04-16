package site.morn.framework.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import site.morn.boot.support.entity.ReviserEntity;
import site.morn.validate.group.Add;
import site.morn.validate.group.Update;

/**
 * 用户基础映射类
 *
 * @author timely-rain
 * @since 0.0.1-SNAPSHOT, 2019/4/16
 */
@Data
@DynamicInsert
@DynamicUpdate
@EqualsAndHashCode(callSuper = true)
@FieldNameConstants
@MappedSuperclass
public class BaseUser extends ReviserEntity implements java.io.Serializable {

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
  @Column(length = 32, unique = true, nullable = false)
  @NotNull(groups = {Add.class, Update.class})
  @Size(min = 4, max = 32)
  private String username;        // 用户名
  /**
   * 密码
   */
  @Column(length = 32, nullable = false)
  @NotNull(groups = Add.class)
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
   * 手机
   */
  @Column
  private String phone;           // 手机
}
