package com.example.seed.controller;
import com.example.seed.support.utils.Result;
import com.example.seed.model.entity.Info;
import com.example.seed.service.InfoService;
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
* @date 2020/03/05
*/
@Slf4j
@RestController
@RequestMapping("/info")
@Api(tags = "InfoController")
public class InfoController {
    @Resource
    private InfoService infoService;

    @ApiOperation(value = "获取信息（通过主键）")
    @GetMapping("/detail")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "id", value = "id")
    })
    public Result<Info> detail(@RequestParam Integer id) {
        Info info = new Info();
        try{
            info = infoService.findById(id);
        }catch (Exception e) {
            log.error("InfoController 获取信息异常:{}", e);
            return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg("InfoController 获取信息异常!");
        }
        return Result.ok().setData(info);
    }

    @ApiOperation(value = "获取信息（list不分页）")
    @GetMapping("/list")
    public Result<List<Info>> list() {
        List<Info> list = new ArrayList<>();
        try{
            list = infoService.findListAll();
        }catch (Exception e) {
            log.error("InfoController 获取信息异常:{}", e);
            return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg("InfoController 获取信息异常!");
        }
        return Result.ok().setData(list);
    }

    @ApiOperation(value = "获取信息（list分页）")
    @GetMapping("/listPages")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageNum", value = "起始页"),
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageSize", value = "页大小")
    })
    public Result<List<Info>> listPages(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
        List<Info> list = new ArrayList<>();
        try{
            PageHelper.startPage(pageNum, pageSize);
            list = infoService.findListAll();
        }catch (Exception e) {
            log.error("InfoController 获取信息异常:{}", e);
            return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg("InfoController 获取信息异常!");
        }
        PageInfo pageInfo = new PageInfo(list);
        return Result.ok().setData(pageInfo);
    }

    @ApiOperation(value = "添加信息")
    @PostMapping("/add")
    public Result add(Info info) {
        try{
            infoService.saveSelectiveObject(info);
        }catch (Exception e) {
            log.error("InfoController 保存信息异常:{}", e);
            return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg("InfoController 保存信息异常!");
        }
        return Result.ok();
    }

    @ApiOperation(value = "修改信息")
    @PutMapping("/update")
    public Result update(Info info) {
        try{
            infoService.updateByKeySelectiveTb(info);
        }catch (Exception e) {
            log.error("InfoController 更新信息异常:{}", e);
            return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg("InfoController 更新信息异常!");
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
            infoService.deleteById(id);
        }catch (Exception e) {
            log.error("InfoController 更新信息异常:{}", e);
            return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg("InfoController 更新信息异常!");
        }
        return Result.ok();
    }
}
