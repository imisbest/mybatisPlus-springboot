package com.csw.mybatisSpringboot.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
    private static final String RECORES = "records";
    private static final String STATUS = "status";
    private static final String SUCCESS = "success";
    @Autowired
    private DogMapper dogMapper;

    @Override/*mybatis-plus，单表插入一条数据*/
    public void insertDog(Dog dog) {
        dogMapper.insert(dog);
    }

    @Override/*批量插入*/
    public void insertDogForeach(List<Dog> list) {
        dogMapper.insertDogForeach(list);
    }

    @Override/*批量更新*/
    public void updateDogForeach(List<Dog> list) {
        dogMapper.updateDogForeach(list);
    }

    @Override/*批量删除*/
    public void deleteDogForeach(List<Dog> list, String string) {
        dogMapper.deleteDogForeach(list, string);
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
    public List<Dog> selectAllDog() {
        return dogMapper.selectList();
    }

    @Override/*mybatis-plus，单表分页查询*/
    public Map<String, Object> selectPage(Page<Dog> page, QueryWrapper<Dog> queryWrapper) {
        Page<Dog> dogPage = dogMapper.selectPage(page, queryWrapper);
        Map<String, Object> map = new HashMap<>();
        map.put(RECORES, dogPage.getRecords());//数据
        map.put(STATUS, SUCCESS);
        return map;
    }


    @Override/*sql手动分页，一对多（适合一对一的情况）*/
    public Map<String, Object> selectpageTables(int currentPage, int pageSize) {
        List<Dog> list = dogMapper.selectpageTables(currentPage, pageSize);
        Map<String, Object> map = new HashMap<>();
        map.put(RECORES, list);//数据
        map.put(STATUS, SUCCESS);
        return map;
    }

    @Override/*sql,一对多查询所有*/
    public Map<String, Object> selectTables() {
        List<Dog> list = dogMapper.selectTables();
        Map<String, Object> map = new HashMap<>();
        map.put(RECORES, list);//数据
        map.put(STATUS, SUCCESS);
        return map;
    }

    @Override/*一对多mybatis-plus分页,sql手动写（适合一对一的情况）*/
    public Page<Dog> selectTablePage(Page<Dog> page0) {
        return dogMapper.selectTablePage(page0);
    }

    @Override/*一对多，sql查询，后续手动分页，适合所有情况，特别是（一对多）*/
    public Map<String, Object> selectTablesByLast(int currentPage, int pageSize) {
        /*
         * currentPage 1, pageSize 3
         * 第一页 1-3
         * currentPage 2, pageSize 3
         * 第二页 4-6
         * */
        List<Dog> list = dogMapper.selectTables();
        int length = list.size();
        List<Dog> returnList = new ArrayList<>();
        int start = (currentPage - 1) * pageSize + 1;
        int end = currentPage * pageSize;
        Map<String, Object> map0 = new HashMap<>();
        for (int i = start - 1; i < end; i++) {
            if (i + 1 <= length) {
                returnList.add(list.get(i));
            }
            map0.put(RECORES, returnList);//数据
            map0.put(STATUS, SUCCESS);

        }
        return map0;
    }


}
