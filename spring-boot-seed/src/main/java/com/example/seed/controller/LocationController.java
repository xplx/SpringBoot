package com.example.seed.controller;
import com.example.seed.model.entity.User;
import com.example.seed.service.UserService;
import com.example.seed.support.utils.Result;
import com.example.seed.model.entity.Location;
import com.example.seed.service.LocationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.Date;
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
* @date 2020/06/11
*/
@Slf4j
@RestController
@RequestMapping("/location")
@Api(tags = "LocationController")
public class LocationController {
    @Resource
    private LocationService locationService;
    @Resource
    private UserService userService;

    @ApiOperation(value = "获取信息（通过主键）")
    @GetMapping("/detail")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "id", value = "id")
    })
    public Result<Location> detail(@RequestParam Integer id) {
        Location location = new Location();
        try{
            location = locationService.findById(id);
        }catch (Exception e) {
            log.error("LocationController 获取信息异常:{}", e);
            return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg("LocationController 获取信息异常!");
        }
        return Result.ok().setData(location);
    }

    @ApiOperation(value = "获取信息（list不分页）")
    @GetMapping("/list")
    public Result<List<Location>> list() {
        List<Location> list = new ArrayList<>();
        try{
            list = locationService.findListAll();
        }catch (Exception e) {
            log.error("LocationController 获取信息异常:{}", e);
            return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg("LocationController 获取信息异常!");
        }
        return Result.ok().setData(list);
    }

    @ApiOperation(value = "获取信息（list分页）")
    @GetMapping("/listPages")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageNum", value = "起始页"),
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageSize", value = "页大小")
    })
    public Result<List<Location>> listPages(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
        List<Location> list = new ArrayList<>();
        try{
            PageHelper.startPage(pageNum, pageSize);
            list = locationService.findListAll();
        }catch (Exception e) {
            log.error("LocationController 获取信息异常:{}", e);
            return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg("LocationController 获取信息异常!");
        }
        PageInfo pageInfo = new PageInfo(list);
        return Result.ok().setData(pageInfo);
    }

    @ApiOperation(value = "添加信息")
    @PostMapping("/add")
    @Transactional(propagation = Propagation.REQUIRED)
    public Result add() {
        try{
            locationService.saveLocationPropagation();
        }catch (Exception e) {
            log.error("LocationController 保存信息异常:{}", e);
            return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg("LocationController 保存信息异常!");
        }
        return Result.ok();
    }

    @ApiOperation(value = "修改信息")
    @PutMapping("/update")
    public Result update(Location location) {
        try{
            locationService.updateByKeySelectiveTb(location);
        }catch (Exception e) {
            log.error("LocationController 更新信息异常:{}", e);
            return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg("LocationController 更新信息异常!");
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
            locationService.deleteById(id);
        }catch (Exception e) {
            log.error("LocationController 更新信息异常:{}", e);
            return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg("LocationController 更新信息异常!");
        }
        return Result.ok();
    }
}
