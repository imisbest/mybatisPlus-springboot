package com.csw.mybatisSpringboot.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.csw.mybatisSpringboot.entity.Dog;
import com.csw.mybatisSpringboot.mapper.DogMapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DogServiceImpl implements DogService {
    @Autowired
    private DogMapper dogMapper;

    @Override/*mybatis-plus，单表插入一条数据*/
    public void insertDog(Dog dog) {
        dogMapper.insert(dog);
    }

    @Override/*mybatis-plus，单表根据id查询*/
    public Dog selectDogById(String s) {
        return dogMapper.selectById(s);
    }

    @Override/*mybatis-plus，单表更新一条数据*/
    public void updateDog(Dog dog) {
        dogMapper.updateById(dog);
    }

    @Override/*mybatis-plus，电表根据id删除一条数据*/
    public void deleteById(String s) {
        dogMapper.deleteById(s);
    }

    @Override/*mybatis-plus，单表查询一张表查询所有狗*/
    public List selectAllDog() {
        List daoList = dogMapper.selectList();
        return daoList;
    }

    @Override/*mybatis-plus，单表分页查询*/
    public Map selectPage(Page<Dog> page, QueryWrapper<Dog> queryWrapper) {
        Page<Dog> dogPage = dogMapper.selectPage(page, queryWrapper);
        Map map = new HashMap();
        map.put("records", dogPage.getRecords());//数据
        map.put("status", "success");
        return map;
    }


    @Override/*sql手动分页，一对多（适合一对一的情况）*/
    public Map selectpageTables(int currentPage, int pageSize) {
        List list = dogMapper.selectpageTables(currentPage, pageSize);
        Map map = new HashMap();
        map.put("records", list);//数据
        map.put("status", "success");
        return map;
    }

    @Override/*sql,一对多查询所有*/
    public Map selectTables() {
        List list = dogMapper.selectTables();
        Map map = new HashMap();
        map.put("records", list);//数据
        map.put("status", "success");
        return map;
    }

    @Override/*一对多mybatis-plus分页,sql手动写（适合一对一的情况）*/
    public Page<Dog> selectTablePage(Page<Dog> page0) {
        return dogMapper.selectTablePage(page0);
    }

    @Override/*一对多，sql查询，后续手动分页，适合所有情况，特别是（一对多）*/
    public Map selectTablesByLast(int currentPage, int pageSize) {
        /*
         * currentPage 1, pageSize 3
         * 第一页 1-3
         * currentPage 2, pageSize 3
         * 第二页 4-6
         * */
        List list = dogMapper.selectTables();
        int length = list.size();
        List returnList = new ArrayList();
        int start = (currentPage - 1) * pageSize + 1;
        int end = currentPage * pageSize;
        Map map0 = new HashMap();
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
