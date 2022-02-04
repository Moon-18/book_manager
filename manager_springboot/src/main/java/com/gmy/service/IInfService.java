package com.gmy.service;

import com.gmy.entity.Inf;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 借阅信息管理 服务类
 * </p>
 *
 * @author 如月十八
 * @since 2022-01-25
 */
public interface IInfService extends IService<Inf> {
    //增加一条记录->借书
    public Integer create(Inf inf);
    //修改一条记录->还书,而且需要标注异常
    public Integer update(Inf inf);
    //分页查看全部历史记录
    public List<Inf> listAll(int cur,int size);
    //最近7天总借阅量

    //不同种类图书累计总借阅量

}
