package com.csw.mybatisSpringboot.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.csw.mybatisSpringboot.entity.Dog;
import com.csw.mybatisSpringboot.entity.DogLeash;
import com.csw.mybatisSpringboot.mapper.DogLeashesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DogLeashsServiceImpl implements DogLeashService {
    @Autowired
    private DogLeashesMapper dogLeashesMapper;

    @Override
    public void insertDogLeash(DogLeash dogLeash) {
        dogLeashesMapper.insert(dogLeash);
    }

    @Override
    public List selectDogLeashDogs() {
        return dogLeashesMapper.selectList();
    }

    @Override
    public Map selectOneToOneByMybatisPlusPage(int currentPage, int pageSize) {
        Page<Dog> page0 = new Page<>(currentPage, pageSize);
        Page pagelist = dogLeashesMapper.selectOneToOneByMybatisPlusPage(page0);
        Map map = new HashMap();
        map.put("records", pagelist.getRecords());//数据
        map.put("status", "success");
        return map;
    }


}
