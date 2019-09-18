package site.morn.framework.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldNameConstants;
import site.morn.boot.data.entity.CreatorEntity;
import site.morn.constant.MetricUnit.Text;

/**
 * 权限基础映射类
 *
 * @author timely-rain
 * @since 1.0.2, 2019/5/12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@FieldNameConstants
@MappedSuperclass
public class BasePrivilege extends CreatorEntity implements Serializable {

  /**
   * @serialField
   */
  private static final long serialVersionUID = 1L;

  /**
   * 主键
   */
  @Id
  @GeneratedValue
  protected Long id;

  /**
   * 父节点
   */
  @Column
  protected Long parentId;

  /**
   * 层级
   */
  @Column
  protected Integer level;

  /**
   * 查询码
   */
  @Column
  protected String searchCode;

  /**
   * 权限名
   */
  @Column(length = Text.SHORT)
  protected String name;

  /**
   * 说明
   */
  @Column
  protected String description;

  /**
   * 类型，0:菜单目录 1:菜单 2:按钮
   */
  @Column
  protected Integer type;

  /**
   * 权限码
   */
  @Column(length = 32)
  protected String code;

  /**
   * 路径
   */
  @Column
  protected String url;

  /**
   * 排序的序号
   */
  @Column
  protected Integer sort;
}
