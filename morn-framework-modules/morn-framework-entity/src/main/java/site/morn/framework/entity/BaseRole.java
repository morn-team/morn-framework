package site.morn.framework.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldNameConstants;
import site.morn.boot.data.entity.ReviserEntity;
import site.morn.constant.MetricUnit.Text;
import site.morn.data.group.Add;

/**
 * 角色基础映射类
 *
 * @author timely-rain
 * @since 1.0.2, 2019/5/12
 */
@Data
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
  @Size(max = Text.SHORT)
  private String name;                // 名称

  /**
   * 角色描述
   */
  @Column
  @Size(max = Text.NORMAL)
  private String description;         // 描述
}
