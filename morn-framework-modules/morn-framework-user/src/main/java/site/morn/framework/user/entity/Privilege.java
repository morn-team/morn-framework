package site.morn.framework.user.entity;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import site.morn.framework.entity.BasePrivilege;

/**
 * 权限
 *
 * @author timely-rain
 * @since 1.0.0, 2017/9/17
 */
@Data
@DynamicInsert
@DynamicUpdate
@Entity
@EqualsAndHashCode(callSuper = true)
@FieldNameConstants
public class Privilege extends BasePrivilege {

  /**
   * 角色
   */
  @ManyToMany
  private Set<Role> roles;
}
