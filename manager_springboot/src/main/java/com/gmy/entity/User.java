package com.gmy.entity;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 图书馆的管理员列表
 * </p>
 *
 * @author 如月十八
 * @since 2022-01-25
 */
@ApiModel(value = "User对象", description = "图书馆的管理员列表")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 防止精度丢失
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String name;

    private String account;

    private String password;

    private String type;


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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
