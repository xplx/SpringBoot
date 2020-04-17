package com.example.seed.feign;

import com.example.seed.model.entity.UserInfo;
import com.example.seed.support.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 餐配企业-学校绑定关系管理
 * @author wuxiaopeng
 */
@FeignClient(name = "spring-boot-seed")
public interface FeignUserService {


    /**
     * 获取用户id
     * @return
     */
    @GetMapping("/user/info/listPagess")
    Result<List<UserInfo>> listPagesForSchool(@RequestParam("id") String id);
}
