package com.csw.mybatisSpringboot.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.csw.mybatisSpringboot.entity.Dog;
import com.csw.mybatisSpringboot.entity.DogLeash;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DogLeashesMapper extends BaseMapper<DogLeash> {

    List selectList();/*mybatis-plus*/

    Page selectOneToOneByMybatisPlusPage(Page<Dog> page0);



}
