package com.csw.mybatisSpringboot.service;


import com.csw.mybatisSpringboot.entity.DogLeash;

import java.util.List;
import java.util.Map;


public interface DogLeashService {
    void insertDogLeash(DogLeash dogLeash);

    List<DogLeash> selectDogLeashDogs();

    Map<String, Object> selectOneToOneByMybatisPlusPage(int currentPage, int pageSize);

    void insertDogLeashForeach(List<DogLeash> list);


}
