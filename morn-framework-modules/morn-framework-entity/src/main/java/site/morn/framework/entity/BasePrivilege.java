package site.morn.framework.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Data;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import site.morn.constant.MetricUnit.Text;

/**
 * 权限基础映射类
 *
 * @author timely-rain
 * @since 1.0.2, 2019/5/12
 */
@Data
@DynamicInsert
@DynamicUpdate
@FieldNameConstants
@MappedSuperclass
public class BasePrivilege implements Serializable {

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
   * 父节点
   */
  @Column
  private Long parentId;

  /**
   * 层级
   */
  @Column
  private Integer level;

  /**
   * 查询码
   */
  @Column
  private String searchCode;

  /**
   * 权限名
   */
  @Column(length = Text.SHORT)
  private String name;

  /**
   * 说明
   */
  @Column
  private String description;

  /**
   * 类型，0:菜单目录 1:菜单 2:按钮
   */
  @Column
  private Integer type;

  /**
   * 权限码
   */
  @Column
  private String code;

  /**
   * 路径
   */
  @Column
  private String url;

  /**
   * 排序的序号
   */
  @Column
  private Integer sort;
}
