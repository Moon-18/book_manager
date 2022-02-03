package com.gmy.mapper;

import com.gmy.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 图书馆的管理员列表 Mapper 接口
 * </p>
 *
 * @author 高明岩
 * @since 2022-01-25
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    @Select("select id from user where ACCOUNT=#{account}")
    public int getId(String account);

}
