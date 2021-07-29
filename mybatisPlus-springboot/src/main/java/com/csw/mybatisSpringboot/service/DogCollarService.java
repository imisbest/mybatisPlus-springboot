package com.csw.mybatisSpringboot.service;

import java.util.Map;

public interface DogCollarService {
    Map selectCollarLeashByLast(int currentPage, int pageSize);
}
