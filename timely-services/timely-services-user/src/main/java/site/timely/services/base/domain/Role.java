package site.timely.services.base.domain;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * 角色
 *
 * @author TianGanLin
 * @version 1.0.0, 2017/9/10
 * @since 1.0-SNAPSHOT
 */
@Entity
@Inheritance
@DynamicInsert
@DynamicUpdate
public class Role {

    @Id
    @GeneratedValue
    private Long id;                    // 主键

    @Column(nullable = false)
    private String name;                // 名称

    @Column
    private String description;         // 描述

    @Column
    private String creator;             // 创建人

    @Column
    @Temporal(TemporalType.DATE)
    private Date date;                  // 创建时间

    @ManyToMany(mappedBy = "roles")
    private Set<Privilege> privileges;  // 权限

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;            // 用户

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Set<Privilege> privileges) {
        this.privileges = privileges;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
