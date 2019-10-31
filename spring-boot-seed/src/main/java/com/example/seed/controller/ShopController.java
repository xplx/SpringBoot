package com.example.seed.controller;
import com.example.seed.support.utils.Result;
import com.example.seed.model.entity.Shop;
import com.example.seed.service.ShopService;
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
@RequestMapping("/shop")
@Api(tags = "ShopController")
public class ShopController {
    @Resource
    private ShopService shopService;

    @ApiOperation(value = "获取信息（通过主键）")
    @GetMapping("/detail")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "id", value = "id")
    })
    public Result detail(@RequestParam Integer id) {
        Shop shop = new Shop();
        try{
            shop = shopService.findById(id);
        }catch (Exception e) {
            log.error("ShopController 获取信息异常:{}", e);
            return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg("ShopController 获取信息异常!");
        }
        return Result.ok().setData(shop);
    }

    @ApiOperation(value = "获取信息（list不分页）")
    @GetMapping("/list")
    public Result list() {
        List<Shop> list = new ArrayList<>();
        log.info("123");
        try{
            list = shopService.findAll();
        }catch (Exception e) {
            log.error("ShopController 获取信息异常:{}", e);
            return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg("ShopController 获取信息异常!");
        }
        return Result.ok().setData(list);
    }

    @ApiOperation(value = "获取信息（list分页）")
    @GetMapping("/listPages")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageNum", value = "起始页"),
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageSize", value = "页大小")
    })
    public Result listPages(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
        List<Shop> list = new ArrayList<>();
        try{
            PageHelper.startPage(pageNum, pageSize);
            list = shopService.findAll();
        }catch (Exception e) {
            log.error("ShopController 获取信息异常:{}", e);
            return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg("ShopController 获取信息异常!");
        }
        PageInfo pageInfo = new PageInfo(list);
        return Result.ok().setData(pageInfo);
    }

    @ApiOperation(value = "添加信息")
    @PostMapping("/add")
    public Result add(Shop shop) {
        try{
            shopService.save(shop);
        }catch (Exception e) {
            log.error("ShopController 保存信息异常:{}", e);
            return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg("ShopController 保存信息异常!");
        }
        return Result.ok();
    }

    @ApiOperation(value = "修改信息")
    @PutMapping("/update")
    public Result update(Shop shop) {
        try{
            shopService.update(shop);
        }catch (Exception e) {
            log.error("ShopController 更新信息异常:{}", e);
            return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg("ShopController 更新信息异常!");
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
            shopService.deleteById(id);
        }catch (Exception e) {
            log.error("ShopController 更新信息异常:{}", e);
            return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg("ShopController 更新信息异常!");
        }
        return Result.ok();
    }
}
