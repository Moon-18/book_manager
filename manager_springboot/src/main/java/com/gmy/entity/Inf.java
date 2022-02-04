package com.gmy.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 借阅信息管理
 * </p>
 *
 * @author 如月十八
 * @since 2022-01-25
 */
@ApiModel(value = "Inf对象", description = "借阅信息管理")
public class Inf implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    private Long id;

    @ApiModelProperty("对应图书id")
    private Integer bookId;

    @ApiModelProperty("对应读者id")
    private Integer readerId;

    @ApiModelProperty("这一条借阅信息的状态，正常还是异常，字符串类型的，标明状态")
    private String state;

    @ApiModelProperty("还书时间，允许为空，表示未还;对应更新字段时间;自动填充")
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime inDate;

    @ApiModelProperty("借出时间，不允许为空;对应创建字段时间;自动填充")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime outDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getReaderId() {
        return readerId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public LocalDateTime getInDate() {
        return inDate;
    }

    public void setInDate(LocalDateTime inDate) {
        this.inDate = inDate;
    }

    public LocalDateTime getOutDate() {
        return outDate;
    }

    public void setOutDate(LocalDateTime outDate) {
        this.outDate = outDate;
    }

    @Override
    public String toString() {
        return "Inf{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", readerId=" + readerId +
                ", state='" + state + '\'' +
                ", inDate=" + inDate +
                ", outDate=" + outDate +
                '}';
    }
}
