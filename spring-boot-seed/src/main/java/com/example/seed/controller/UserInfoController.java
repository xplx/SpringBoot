package com.example.seed.controller;

import com.example.seed.model.dto.UserInfoDto;
import com.example.seed.model.entity.UserInfo;
import com.example.seed.service.UserInfoService;
import com.example.seed.support.utils.Result;
import com.example.seed.support.utils.enums.StatusCode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
*
* @author wuxiaopeng
* @date 2019/10/31
*/
@Slf4j
@RestController
@RequestMapping("/user/info")
@Api(tags = "UserInfoController")
public class UserInfoController {
    @Resource
    private UserInfoService userInfoService;

    @ApiOperation(value = "获取信息（通过主键）")
    @GetMapping("/detail")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "id", value = "id")
    })
    public Result<UserInfo> detail(@RequestParam Integer id) {
        UserInfo userInfo = new UserInfo();
        try{
            userInfo = userInfoService.findById(id);
        }catch (Exception e) {
            log.error("UserInfoController 获取信息异常:{}", e);
            return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg("UserInfoController 获取信息异常!");
        }
        return Result.ok().setData(userInfo);
    }

    @ApiOperation(value = "获取信息（list不分页）")
    @GetMapping("/list")
    @Cacheable(value = "UserInfo",key = "#dto.id")
    public Result<List<UserInfo>> list(UserInfoDto dto) {
        List<UserInfo> list = new ArrayList<>();
        try{
            list = userInfoService.findListByObject(dto);
        }catch (Exception e) {
            log.error("UserInfoController 获取信息异常:{}", e);
            return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg("UserInfoController 获取信息异常!");
        }
        return Result.ok().setData(list);
    }

    @ApiOperation(value = "修改信息")
    @PutMapping("/update")
    //清楚指定key缓存（没有key值，将用接收参数作为key值）
    @CacheEvict(value = "UserInfo",key = "#userInfo.id")
    public Result update(UserInfo userInfo) {
        try{
            userInfoService.updateByKeySelectiveTb(userInfo);
        }catch (Exception e) {
            log.error("UserInfoController 更新信息异常:{}", e);
            return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg("UserInfoController 更新信息异常!");
        }
        return Result.ok();
    }

    @ApiOperation(value = "获取信息（list分页）")
    @GetMapping("/listPages")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageNum", value = "起始页"),
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageSize", value = "页大小")
    })
    public Result<List<UserInfo>> listPages(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
        List<UserInfo> list = new ArrayList<>();
        try{
            PageHelper.startPage(pageNum, pageSize);
            list = userInfoService.findListAll();
        }catch (Exception e) {
            log.error("UserInfoController 获取信息异常:{}", e);
            return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg("UserInfoController 获取信息异常!");
        }
        PageInfo pageInfo = new PageInfo(list);
        return Result.ok().setData(pageInfo);
    }

    @ApiOperation(value = "添加信息")
    @PostMapping("/add")
    public Result add(UserInfo userInfo) {
        try{
            userInfoService.saveSelectiveId(userInfo);
        }catch (Exception e) {
            log.error("UserInfoController 保存信息异常:{}", e);
            return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg("UserInfoController 保存信息异常!");
        }
        return Result.ok();
    }


    @ApiOperation(value = "删除信息（主键）")
    @DeleteMapping("/delete")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "id", value = "id")
    })
    public Result delete(@RequestParam Integer id) {
        try{
            userInfoService.deleteById(id);
        }catch (Exception e) {
            log.error("UserInfoController 更新信息异常:{}", e);
            return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg("UserInfoController 更新信息异常!");
        }
        return Result.ok();
    }
}
