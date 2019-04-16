package site.morn.framework.user.entity;

import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import site.morn.framework.entity.BaseUser;

/**
 * 用户
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
public class User extends BaseUser {

  private static final long serialVersionUID = 1L;

}
