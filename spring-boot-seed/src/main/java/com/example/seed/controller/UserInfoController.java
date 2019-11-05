package com.example.seed.controller;
import com.example.seed.support.utils.Result;
import com.example.seed.model.entity.UserInfo;
import com.example.seed.service.UserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import io.swagger.annotations.Api;
import java.util.ArrayList;
import com.example.seed.support.utils.enums.StatusCode;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

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
    public Result<List<UserInfo>> list() {
        List<UserInfo> list = new ArrayList<>();
        try{
            list = userInfoService.findAll();
        }catch (Exception e) {
            log.error("UserInfoController 获取信息异常:{}", e);
            return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg("UserInfoController 获取信息异常!");
        }
        return Result.ok().setData(list);
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
            list = userInfoService.findAll();
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
            userInfoService.save(userInfo);
        }catch (Exception e) {
            log.error("UserInfoController 保存信息异常:{}", e);
            return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg("UserInfoController 保存信息异常!");
        }
        return Result.ok();
    }

    @ApiOperation(value = "修改信息")
    @PutMapping("/update")
    public Result update(UserInfo userInfo) {
        try{
            userInfoService.update(userInfo);
        }catch (Exception e) {
            log.error("UserInfoController 更新信息异常:{}", e);
            return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg("UserInfoController 更新信息异常!");
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
