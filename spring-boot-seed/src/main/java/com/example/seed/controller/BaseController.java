package com.example.seed.controller;

import com.example.seed.support.utils.Result;
import com.example.seed.support.utils.enums.StatusCode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.template.core.Service;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author wuxiaopeng
 * @date 2019/10/31
 */
@Slf4j
@Api(tags = "BaseController")
@Validated
public class BaseController<BaseService extends Service, Entity> {
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected BaseService service;

    protected String userId;
    protected String tenantId;

    @ModelAttribute
    public void initValue() {
        if (this.request == null) {
            return;
        }
        //获取header属性值
        this.userId = this.request.getHeader("userId");
        this.tenantId = this.request.getHeader("tenantId");
    }

    @GetMapping(value = "get")
    @ApiOperation(value = "获取信息（主键id）")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "id", value = "id")
    })
    public Result<Entity> get(@Valid @NotEmpty @RequestParam String id) {
        Object obj = service.findById(id);
        return Result.ok().setData(obj);
    }

    @GetMapping(value = "list")
    @ApiOperation(value = "获取List信息（不分页）")
    public Result<Entity> list(Entity entity) {
        List<Object> list = service.findListByObject(entity);
        return Result.ok().setData(list);
    }

    @GetMapping(value = "listPages")
    @ApiOperation(value = "获取List信息（分页）")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageNum", value = "起始页"),
            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageSize", value = "页大小")
    })
    public Result<PageInfo<List<Entity>>> listPages(Entity entity,
                                                    @RequestParam(defaultValue = "1") Integer pageNum,
                                                    @RequestParam(defaultValue = "10") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Object> list = service.findListByObject(entity);
        PageInfo pageInfo = new PageInfo(list);
        return Result.ok().setData(pageInfo);
    }

    @PostMapping(value = "save")
    @ApiOperation(value = "保存信息（主键id自动生成）")
    public Result save(@Valid @RequestBody Entity entity, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg(bindingResult.getAllErrors().toString());
        }
        //使用雪花算法，自动生成主键id
        service.saveSelectiveIdObject(entity);
        return Result.ok();
    }

    @PutMapping(value = "update")
    @ApiOperation(value = "更新信息（主键id更新）")
    public Result update(@Valid @RequestBody Entity entity){
        service.updateByKeySelectiveTb(entity);
        return Result.ok();
    }

    @DeleteMapping(value = "deleteByKey")
    @ApiOperation(value = "删除信息（主键id删除）")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "id", value = "id")
    })
    public Result deleteByKey(@Valid @NotEmpty @RequestParam String id){
        service.deleteByIds(id);
        return Result.ok();
    }
}
