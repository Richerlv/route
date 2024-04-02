package com.example.route.mapper;

import com.example.route.pojo.Test;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Richerlv
 * @date: 2024/4/2 15:48
 * @description:
 */
@Repository
public interface TestMapper {
    List<Test> getIds();
}
