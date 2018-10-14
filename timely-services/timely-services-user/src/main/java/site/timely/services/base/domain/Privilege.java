package site.timely.services.base.domain;

import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * site.timely.services.base.domain
 *
 * @author timely-rain
 * @version 1.0.0, 2017/9/17
 * @since 1.0-SNAPSHOT
 */
@Entity
@Inheritance
@DynamicInsert
@DynamicUpdate
public class Privilege {

  @Id
  @GeneratedValue
  private Long id;                // 主键

  /**
   * 父节点
   */
  @Column
  private Long parentId;

  /**
   * 权限名
   */
  @Column(length = 32, nullable = false)
  private String name;

  /**
   * 说明
   */
  @Column
  private String description;

  /**
   * 类型，0:菜单目录 1:菜单 2:按钮
   */
  @Column(nullable = false)
  private Integer type;

  /**
   * 权限码
   */
  @Column
  private String code;

  /**
   * 权限等级
   */
  private Integer level;

  /**
   * 是否为操作日志(1是,0否)
   */
  private Boolean isLog;

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

  /**
   * 创建时间
   */
  @Column
  @Temporal(TemporalType.DATE)
  private Date date;

  /**
   * 角色
   */
  @ManyToMany
  private Set<Role> roles;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getParentId() {
    return parentId;
  }

  public void setParentId(Long parentId) {
    this.parentId = parentId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }

  public Boolean getLog() {
    return isLog;
  }

  public void setLog(Boolean log) {
    isLog = log;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Integer getSort() {
    return sort;
  }

  public void setSort(Integer sort) {
    this.sort = sort;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }
}
