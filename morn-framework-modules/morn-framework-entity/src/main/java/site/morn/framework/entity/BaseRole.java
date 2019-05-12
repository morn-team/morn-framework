package site.morn.framework.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import site.morn.boot.support.entity.ReviserEntity;
import site.morn.constant.MetricUnit.Text;
import site.morn.validate.group.Add;

/**
 * 角色基础映射类
 *
 * @author timely-rain
 * @since 1.0.2, 2019/5/12
 */
@Data
@DynamicInsert
@DynamicUpdate
@EqualsAndHashCode(callSuper = true)
@FieldNameConstants
@MappedSuperclass
public class BaseRole extends ReviserEntity implements Serializable {

  /**
   * @serialField
   */
  private static final long serialVersionUID = 1L;

  /**
   * 主键
   */
  @Id
  @GeneratedValue
  private Long id;                    // 主键

  /**
   * 角色名称
   */
  @Column(length = Text.SHORT)
  @NotNull(groups = Add.class)
  @Max(Text.SHORT)
  private String name;                // 名称

  /**
   * 角色描述
   */
  @Column
  @Max(Text.NORMAL)
  private String description;         // 描述
}
