package com.csw.mybatisSpringboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.csw.mybatisSpringboot.entity.DogCollar;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DogCollarMapper extends BaseMapper<DogCollar> {
    List<DogCollar> selectCollarLeashByLast();
}
