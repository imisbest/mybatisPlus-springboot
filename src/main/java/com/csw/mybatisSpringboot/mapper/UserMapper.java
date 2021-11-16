package com.csw.mybatisSpringboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.csw.mybatisSpringboot.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
