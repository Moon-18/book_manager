package com.gmy.service;

import com.gmy.entity.Inf;
import com.baomidou.mybatisplus.extension.service.IService;

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
    //修改一条记录->还书,标注异常
}
