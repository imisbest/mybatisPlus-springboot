package com.csw.mybatisSpringboot.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.csw.mybatisSpringboot.entity.Dog;
import com.csw.mybatisSpringboot.entity.DogLeash;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DogLeashesMapper extends BaseMapper<DogLeash> {

    List<DogLeash> selectList();/*mybatis-plus*/

    Page<DogLeash> selectOneToOneByMybatisPlusPage(Page<Dog> page0);

    void insertDogLeashForeach(List<DogLeash> list);


}
