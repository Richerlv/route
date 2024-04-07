package com.example.route.controller;

import com.example.route.mapper.TestMapper;
import com.example.route.pojo.Test;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author: Richerlv
 * @date: 2024/4/2 15:29
 * @description:
 */

@Slf4j
@CrossOrigin
@Controller
public class HelloController {

    @Autowired
    private TestMapper testDao;

    @ResponseBody
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        log.info("SOMEONE SAY HELLO!");
        return "hello!";
    }

    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public List<Test> test() {
        return testDao.getIds();
    }
}
