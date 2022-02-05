package com.gmy.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gmy.entity.Inf;
import com.gmy.mapper.BookMapper;
import com.gmy.mapper.InfMapper;
import com.gmy.mapper.UserMapper;
import com.gmy.service.IInfService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 借阅信息管理 服务实现类
 * </p>
 *
 * @author 如月十八
 * @since 2022-01-25
 */
@Service
public class InfServiceImpl extends ServiceImpl<InfMapper, Inf> implements IInfService {

    @Autowired
    private InfMapper infMapper;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer create(Inf inf) {
        return infMapper.insert(inf);
    }

    @Override
    public Integer update(Inf inf) {
        return infMapper.updateById(inf);
    }

    @Override
    public List<Inf> listAll(int cur, int size) {
        Page<Inf> page=new Page<>(cur,size);
        infMapper.selectPage(page,null);
        List<Inf> infList=page.getRecords();
        for (Inf inf :infList){
            System.out.println(inf);
            //暂时没有转过弯来，用复杂的绕一下
            inf.setBookName(bookMapper.selectById(inf.getBookId()).getName());
            inf.setReaderName(userMapper.selectById(inf.getReaderId()).getName());
            System.out.println(inf);
        }
        return infList;
    }
}
