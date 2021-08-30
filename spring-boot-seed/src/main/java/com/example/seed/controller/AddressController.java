package com.example.seed.controller;

import com.example.seed.feign.FeignUserService;
import com.example.seed.mapper.AddressMapper;
import com.example.seed.model.dto.UserInfoDto;
import com.example.seed.model.dto.UserInfoSaveUpdateDto;
import com.example.seed.model.entity.Address;
import com.example.seed.model.entity.UserInfo;
import com.example.seed.model.vo.UserInfoVo;
import com.example.seed.service.AddressService;
import com.example.seed.service.UserInfoService;
import com.example.seed.support.resubmit.Resubmit;
import com.example.seed.support.utils.Result;
import com.example.seed.support.validator.group.Update;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.template.annotation.ConditionRewrite;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wuxiaopeng
 * @date 2019/10/31
 */
@Slf4j
@RestController
@RequestMapping("/address")
@Api(tags = "addressController")
public class AddressController {
    @Resource
    private AddressService addressService;

    @PostMapping("/save")
    @ApiOperation("保存数据")
    public void save(@RequestBody Address address){
        addressService.save(address);
    }
}
