package com.gmy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gmy.common.lang.Result;
import com.gmy.entity.Book;
import com.gmy.entity.Inf;
import com.gmy.entity.User;
import com.gmy.mapper.BookMapper;
import com.gmy.mapper.InfMapper;
import com.gmy.mapper.UserMapper;
import com.gmy.service.IInfService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Transactional
    @Override
    public Result create(Inf inf) {
        //这么写不大对，最好是重写mapper里面的sql语句，判断执行后的结果是否为空，来代替这个，因为你无法直接两个的名字
        //是否存在书
        QueryWrapper<Book> wrapper1 = new QueryWrapper<>();
//        System.out.println("书名" + inf.getBookName());
        wrapper1.eq("name", inf.getBookName());//bug 存入图书的时候加了\n 字符串形式,也存进去了,排查1h
        Book book = bookMapper.selectOne(wrapper1);
//        System.out.println("图书" + book);
        if (book == null) {
            return Result.fail(431, "图书不存在");
        }
        //设置book id
        inf.setBookId(book.getId());
        //是否存在读者
        QueryWrapper<User> wrapper2 = new QueryWrapper<>();
        wrapper2.eq("name", inf.getReaderName());
        User user = userMapper.selectOne(wrapper2);
        if (user == null) {
            return Result.fail(432, "用户不存在");
        }
        inf.setReaderId(user.getId());
        //是否允许借出
        if (book.getAllow() == 0) {
            return Result.fail(433, "该本图书禁止外借");
        }
        //是否有余量
        if (book.getCurNum() == 0) {
            return Result.fail(434, "图书没有余量");
        }
        //更新inf表
        inf.setState("借出");
        infMapper.insert(inf);
        //更新book表
        book.setCurNum(book.getCurNum() - 1);
        bookMapper.updateById(book);
        return Result.succ(null);
    }

    @Transactional
    @Override
    public Result update(Inf inf) {
        System.out.println(inf);
        //读取图书 用户id
        QueryWrapper<Book> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("name", inf.getBookName());
        Book book = bookMapper.selectOne(wrapper1);
        QueryWrapper<User> wrapper2 = new QueryWrapper<>();
        wrapper2.eq("name", inf.getReaderName());
        User user = userMapper.selectOne(wrapper2);
//        System.out.println(book);
//        System.out.println(user);
        //查看是否存在这条记录
        QueryWrapper<Inf> wrapper3 = new QueryWrapper<>();
        wrapper3.eq("book_id", book.getId())
                .eq("reader_id", user.getId())
                .eq("state", "借出");
        Inf temp = infMapper.selectOne(wrapper3);
        if (temp == null) {
            return Result.fail(451, "记录未找到");
        }
        //标记已归还
        temp.setState("归还");
        temp.setMessage(inf.getMessage());
        infMapper.updateById(temp);
        //更新图书数量
        book.setCurNum(book.getCurNum() + 1);
        bookMapper.updateById(book);
        return Result.succ(null);

    }

    @Override
    public Result listAll(int cur, int size) {
        Page<Inf> page = new Page<>(cur, size);
        infMapper.selectPage(page, null);
        List<Inf> infList = page.getRecords();
        for (Inf inf : infList) {
//            System.out.println(inf);
            //暂时没有转过弯来，用复杂的绕一下
            inf.setBookName(bookMapper.selectById(inf.getBookId()).getName());
            inf.setReaderName(userMapper.selectById(inf.getReaderId()).getName());
//            System.out.println(inf);
        }
        return Result.succ(infList);
    }
}
