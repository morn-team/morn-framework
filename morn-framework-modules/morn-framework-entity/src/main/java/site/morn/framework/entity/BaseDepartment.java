package site.morn.framework.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldNameConstants;
import site.morn.boot.support.entity.ReviserEntity;
import site.morn.constant.MetricUnit.Text;
import site.morn.tree.TreeNode;
import site.morn.validate.group.Add;

/**
 * 组织机构基础映射类
 *
 * @author timely-rain
 * @since 1.0.2, 2019/5/16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@FieldNameConstants
@MappedSuperclass
public class BaseDepartment extends ReviserEntity implements Serializable, TreeNode {


  /**
   * 序列化
   */
  private static final long serialVersionUID = 1L;

  /**
   * 主键id
   */
  @Id
  @GeneratedValue
  private Long id;

  /**
   * 父级id
   */
  @Column
  private Long parentId;

  /**
   * 名称
   */
  @Column(length = Text.SHORT)
  @NotNull(groups = {Add.class})
  private String name;

  /**
   * 编号
   */
  @Column(length = Text.SHORT)
  private String code;

  /**
   * 邮箱
   */
  @Column(length = Text.SHORT)
  private String email;

  /**
   * 联系方式
   */
  @Column
  private String contact;

  /**
   * 地址
   */
  @Column
  private String address;

  /**
   * 备注
   */
  @Column
  private String remark;

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
}
