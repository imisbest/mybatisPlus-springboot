package com.csw.mybatisSpringboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.csw.mybatisSpringboot.entity.DogCollar;

import java.util.List;

public interface DogCollarMapper extends BaseMapper<DogCollar> {
    List selectCollarLeashByLast();
}
