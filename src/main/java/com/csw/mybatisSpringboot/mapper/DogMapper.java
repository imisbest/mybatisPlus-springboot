package com.csw.mybatisSpringboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.csw.mybatisSpringboot.entity.Dog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DogMapper extends BaseMapper<Dog> {

    List<Dog> selectList();/*mybatis-plus*/

    List<Dog> selectpageTables(int currentPage, int pageSize);

    List<Dog> selectTables();

    Page<Dog> selectTablePage(Page<Dog> page0);

    /*foreach批量插入*/
    void insertDogForeach(@Param("list") List<Dog> list);

    /*foreach批量更新*/
    void updateDogForeach(List<Dog> list);

    /*foreach批量删除*/
    void deleteDogForeach(List<Dog> list, String string);
}
