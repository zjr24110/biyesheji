package com.gm.wj.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.List;

/**
 * @author Evan
 * @date 2019/4
 */

@Entity
@Table(name = "user")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String username;
    private String password;
    private String salt;
    private String name;
    private String phone;
    private int major;
    private boolean enabled;
    private String profession;
    @Transient
    private List<AdminRole> roles;
        // 默认构造函数
    public User() {}
        // 用于配合自定义查询的构造函数
    public User(int id,String username, String name, String phone, int major, boolean enabled,String profession) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.phone = phone;
        this.major = major;
        this.enabled = enabled;
        this.profession = profession;

    }
    public String getProfession() {
        return profession;
    }

    public void setProfession( String profession ) {
        this.profession = profession;
    }

    public int getId() {
        return id;
    }

    public int getMajor() {
        return major;
    }

    public void setMajor( int major ) {
        this.major = major;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }




    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<AdminRole> getRoles() {
        return roles;
    }

    public void setRoles(List<AdminRole> roles) {
        this.roles = roles;
    }
}

