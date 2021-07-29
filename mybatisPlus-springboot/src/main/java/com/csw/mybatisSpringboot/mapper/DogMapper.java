package com.csw.mybatisSpringboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.csw.mybatisSpringboot.entity.Dog;

import java.util.List;


public interface DogMapper extends BaseMapper<Dog> {

    List selectList();/*mybatis-plus*/

    List selectpageTables( int currentPage,int pageSize);

    List selectTables();

    Page<Dog> selectTablePage(Page<Dog> page0);

}
