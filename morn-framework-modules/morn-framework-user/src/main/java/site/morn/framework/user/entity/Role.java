package site.morn.framework.user.entity;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import site.morn.framework.entity.BaseRole;

/**
 * 角色
 *
 * @author timely-rain
 * @since 1.0.0, 2017/9/10
 */
@Data
@DynamicInsert
@DynamicUpdate
@Entity
@EqualsAndHashCode(callSuper = true)
@FieldNameConstants
public class Role extends BaseRole {

  /**
   * 权限
   */
  @ManyToMany(mappedBy = "roles")
  private Set<Privilege> privileges;

  /**
   * 用户
   */
  @JoinColumn
  @ManyToMany
  private Set<User> users;
}
