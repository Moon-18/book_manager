package com.gmy.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

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

    /**
     * 防止精度丢失
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty("ID")
    private Long id;

    /**
     * 防止精度丢失
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty("对应图书id")
    private Long bookId;

    @ApiModelProperty("对应图书名称")
    @TableField(exist = false)
    private String bookName;

    /**
     * 防止精度丢失
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty("对应读者id")
    private Long readerId;

    @ApiModelProperty("对应读者名称")
    @TableField(exist = false)
    private String readerName;

    @ApiModelProperty("这一条借阅信息的状态，正常还是异常，字符串类型的，标明状态")
    private String state;

    @ApiModelProperty("还书时间，允许为空，表示未还;对应更新字段时间;自动填充")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)//日期序列化反序列化注解
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime inDate;

    @ApiModelProperty("借出时间，允许为空;对应创建字段时间;自动填充")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)//日期序列化反序列化注解
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime outDate;

    @ApiModelProperty("备注信息")
    private String message;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getReaderId() {
        return readerId;
    }

    public void setReaderId(Long readerId) {
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    @Override
    public String toString() {
        return "Inf{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", readerId=" + readerId +
                ", readerName='" + readerName + '\'' +
                ", state='" + state + '\'' +
                ", inDate=" + inDate +
                ", outDate=" + outDate +
                ", message='" + message + '\'' +
                '}';
    }
}
