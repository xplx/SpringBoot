package com.example.seed.controller;

import com.example.seed.model.dto.UserInfoDto;
import com.example.seed.model.entity.UserInfo;
import com.example.seed.service.UserInfoService;
import com.example.seed.support.param.CriteriaRewrite;
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
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;
import wiki.xsx.core.log.Log;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
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

    @ApiOperation(value = "获取信息list，自定义注解查询")
    @GetMapping("/infoList")
    public Result<UserInfo> infoList(UserInfoDto userInfo) {
        List<UserInfo> userInfoList = new ArrayList<>();
        try {
            //通过注解获取相应的条件信息
            Condition condition = CriteriaRewrite.equalToCondition(new Condition(UserInfo.class), userInfo);
            condition.orderBy("id").desc();
            userInfoList = userInfoService.findListByCondition(condition, UserInfo.class);
        } catch (Exception e) {
            log.error("UserInfoController 获取信息异常:{}", e);
            return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg("UserInfoController 获取信息异常!");
        }
        return Result.ok().setData(userInfoList);
    }

    @ApiOperation(value = "获取信息list，复杂的查询条件")
    @GetMapping("/userInfoList")
    public Result<UserInfo> userInfoList(UserInfoDto userInfo) {
        List<UserInfo> userInfoList = new ArrayList<>();
        try {
            //自where查询，需要支持（a or b or c） and d ，创建两个Criteria变量
            //创建两个criteria使用and或者or来连接
            Condition condition = new Condition(UserInfo.class);
            Condition.Criteria criteria = condition.createCriteria();
            criteria.orEqualTo("id", userInfo.getId());
            criteria.orEqualTo("age", userInfo.getAge());
            Condition.Criteria criteria1 = condition.createCriteria();
            criteria1.andEqualTo("name", userInfo.getName());
            condition.and(criteria1);
            userInfoList = userInfoService.findListByCondition(condition, UserInfo.class);
        } catch (Exception e) {
            log.error("UserInfoController 获取信息异常:{}", e);
            return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg("UserInfoController 获取信息异常!");
        }
        return Result.ok().setData(userInfoList);
    }

    @ApiOperation(value = "获取信息（list不分页，缓存设置）")
    @GetMapping("/list")
    @Cacheable(value = "UserInfo", key = "#dto.id")
    public Result<List<UserInfo>> list(UserInfoDto dto) {
        List<UserInfo> list = new ArrayList<>();
        try {
            list = userInfoService.findListByObject(dto);
        } catch (Exception e) {
            log.error("UserInfoController 获取信息异常:{}", e);
            return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg("UserInfoController 获取信息异常!");
        }
        return Result.ok().setData(list);
    }

    @ApiOperation(value = "修改信息")
    @PutMapping("/update")
    //清楚指定key缓存（没有key值，将用接收参数作为key值）
    @CacheEvict(value = "UserInfo", key = "#userInfo.id")
    public Result update(UserInfo userInfo) {
        try {
            userInfoService.updateByKeySelectiveTb(userInfo);
        } catch (Exception e) {
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
        try {
            PageHelper.startPage(pageNum, pageSize);
            list = userInfoService.findListAll();
        } catch (Exception e) {
            log.error("UserInfoController 获取信息异常:{}", e);
            return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg("UserInfoController 获取信息异常!");
        }
        PageInfo pageInfo = new PageInfo(list);
        return Result.ok().setData(pageInfo);
    }

    @ApiOperation(value = "添加或更新信息")
    @PostMapping("/addOrUpdate")
    public Result addOrUpdate(UserInfo userInfo) {
        try {
            userInfoService.saveOrUpdateKeySelective(userInfo);
        } catch (Exception e) {
            log.error("UserInfoController 保存信息异常:{}", e);
            return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg("UserInfoController 保存信息异常!");
        }
        return Result.ok();
    }

    @ApiOperation(value = "批量添加或更新信息")
    @PostMapping("/saveOrUpdateList")
    public Result saveOrUpdateList(@RequestBody List<UserInfo> list) {
        try {
            userInfoService.saveOrUpdateKeySelectiveList(list);
        } catch (Exception e) {
            log.error("UserInfoController 保存信息异常:{}", e);
            return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg("UserInfoController 保存信息异常!");
        }
        return Result.ok();
    }

    @ApiOperation(value = "删除信息（主键）")
    @DeleteMapping("/delete")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", allowMultiple = true, dataType = "Integer", name = "ids", value = "ids")
    })
    public Result delete(@RequestParam Integer[] ids) {
        try {
            Condition condition = new Condition(UserInfo.class);
            Condition.Criteria criteria = condition.createCriteria();
            criteria.andNotIn("id", Arrays.asList((Integer[]) ids));
            criteria.andEqualTo("age", 12);
            userInfoService.deleteBySelectCondition(condition);
        } catch (Exception e) {
            log.error("UserInfoController 更新信息异常:{}", e);
            return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg("UserInfoController 更新信息异常!");
        }
        return Result.ok();
    }
}
