package com.csw.mybatisSpringboot.service;

import com.csw.mybatisSpringboot.entity.DogCollar;
import com.csw.mybatisSpringboot.mapper.DogCollarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DogCollarServiceImpl implements DogCollarService {
    @Autowired
    private DogCollarMapper dogCollarMapper;

    @Override
    public Map<String, Object> selectCollarLeashByLast(int currentPage, int pageSize) {
        /*
         * currentPage 1, pageSize 3
         * 第一页 1-3
         * currentPage 2, pageSize 3
         * 第二页 4-6
         * */
        List<DogCollar> list = dogCollarMapper.selectCollarLeashByLast();
        int length = list.size();
        List<DogCollar> returnList = new ArrayList<>();
        int start = (currentPage - 1) * pageSize + 1;
        int end = currentPage * pageSize;
        Map<String, Object> map0 = new HashMap<>();
        for (int i = start - 1; i < end; i++) {
            if (i + 1 <= length) {
                returnList.add(list.get(i));
            }

            map0.put("records", returnList);//数据
            map0.put("status", "success");

        }
        return map0;
    }

}
