package com.csw.mybatisSpringboot.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.csw.mybatisSpringboot.entity.Dog;

import java.util.List;
import java.util.Map;

public interface DogService {
    void insertDog(Dog dog);

    Dog selectDogById(String s);

    void updateDog(Dog dog);

    void deleteById(String s);

    List selectAllDog();
    /*单表插件分页*/
    Map selectPage(Page<Dog> page, QueryWrapper<Dog> queryWrapper);
    /*查询所有一对多不分页*/
    Map selectTables();
    /*查询所有一对多，手动代码分页，适合一队一*/
    Map selectpageTables(int currentPage, int pageSize);
    /*查询所有一对多，插件分页，适合一队一*/
    Page<Dog> selectTablePage(Page<Dog> page0);
    /*查询所有一对多，后续手动分页，适合所有情况（特别是一对多）*/
    Map selectTablesByLast(int currentPage, int pageSize);



}
