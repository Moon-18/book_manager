package com.gmy.entity;

import java.io.Serializable;
import java.time.LocalDate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author 高明岩
 * @since 2022-01-25
 */
@ApiModel(value = "Book对象", description = "")
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("作者")
    private String writer;

    @ApiModelProperty("入馆日期")
    private LocalDate inDate;

    @ApiModelProperty("图书种类，科教文卫体与其他")
    private String kind;

    private String comment;

    @ApiModelProperty("是否允许外借，0否，1是")
    private Integer allow;

    @ApiModelProperty("当前在馆数量")
    private Integer curNum;

    @ApiModelProperty("图书全部数量")
    private Integer sumNum;


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

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public LocalDate getInDate() {
        return inDate;
    }

    public void setInDate(LocalDate inDate) {
        this.inDate = inDate;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getAllow() {
        return allow;
    }

    public void setAllow(Integer allow) {
        this.allow = allow;
    }

    public Integer getCurNum() {
        return curNum;
    }

    public void setCurNum(Integer curNum) {
        this.curNum = curNum;
    }

    public Integer getSumNum() {
        return sumNum;
    }

    public void setSumNum(Integer sumNum) {
        this.sumNum = sumNum;
    }

    @Override
    public String toString() {
        return "Book{" +
        "id=" + id +
        ", name=" + name +
        ", writer=" + writer +
        ", inDate=" + inDate +
        ", kind=" + kind +
        ", comment=" + comment +
        ", allow=" + allow +
        ", curNum=" + curNum +
        ", sumNum=" + sumNum +
        "}";
    }
}
