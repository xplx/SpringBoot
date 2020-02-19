package com.example.seed.controller;

import com.example.seed.entity.Test;
import com.example.seed.service.TestService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Test)表控制层
 *
 * @author wxp
 * @since 2020-02-09 19:34:22
 */
@RestController
@RequestMapping("test")
public class TestController {
    /**
     * 服务对象
     */
    @Resource
    private TestService testService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Test selectOne(Integer id) {
        return this.testService.queryById(id);
    }

}