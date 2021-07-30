package com.csw.mybatisSpringboot.service;

import java.util.Map;

public interface DogCollarService {
    Map<String, Object> selectCollarLeashByLast(int currentPage, int pageSize);
}
