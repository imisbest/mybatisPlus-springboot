package com.csw.mybatisSpringboot.service;



import com.csw.mybatisSpringboot.entity.DogLeash;

import java.util.List;
import java.util.Map;


public interface DogLeashService {
    void insertDogLeash(DogLeash dogLeash);

    List selectDogLeashDogs();

    Map selectOneToOneByMybatisPlusPage(int currentPage, int pageSize);

}
