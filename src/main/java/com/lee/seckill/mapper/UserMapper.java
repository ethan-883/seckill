package com.lee.seckill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.seckill.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
* @author ethan
* @description 针对表【t_user(用户表)】的数据库操作Mapper
* @createDate 2023-02-16 22:06:31
* @Entity generator.domain.User
*/
public interface UserMapper extends BaseMapper<User> {

}




