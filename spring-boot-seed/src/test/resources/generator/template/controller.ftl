package ${basePackage}.controller;
import ${basePackage}.support.utils.Result;
import ${basePackage}.model.entity.${modelNameUpperCamel};
import ${basePackage}.service.${modelNameUpperCamel}Service;
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
* @author ${author}
* @date ${date}
*/
@Slf4j
@RestController
@RequestMapping("${baseRequestMapping}")
@Api(tags = "${modelNameUpperCamel}Controller")
public class ${modelNameUpperCamel}Controller {
    @Resource
    private ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    @ApiOperation(value = "获取信息（通过主键）")
    @GetMapping("/detail")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "id", value = "id")
    })
    public Result<${modelNameUpperCamel}> detail(@RequestParam Integer id) {
        ${modelNameUpperCamel} ${modelNameLowerCamel} = new ${modelNameUpperCamel}();
        try{
            ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.findById(id);
        }catch (Exception e) {
            log.error("${modelNameUpperCamel}Controller 获取信息异常:{}", e);
            return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg("${modelNameUpperCamel}Controller 获取信息异常!");
        }
        return Result.ok().setData(${modelNameLowerCamel});
    }

    @ApiOperation(value = "获取信息（list不分页）")
    @GetMapping("/list")
    public Result<List<${modelNameUpperCamel}>> list() {
        List<${modelNameUpperCamel}> list = new ArrayList<>();
        try{
            list = ${modelNameLowerCamel}Service.findAll();
        }catch (Exception e) {
            log.error("${modelNameUpperCamel}Controller 获取信息异常:{}", e);
            return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg("${modelNameUpperCamel}Controller 获取信息异常!");
        }
        return Result.ok().setData(list);
    }

    @ApiOperation(value = "获取信息（list分页）")
    @GetMapping("/listPages")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageNum", value = "起始页"),
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageSize", value = "页大小")
    })
    public Result<List<${modelNameUpperCamel}>> listPages(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
        List<${modelNameUpperCamel}> list = new ArrayList<>();
        try{
            PageHelper.startPage(pageNum, pageSize);
            list = ${modelNameLowerCamel}Service.findAll();
        }catch (Exception e) {
            log.error("${modelNameUpperCamel}Controller 获取信息异常:{}", e);
            return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg("${modelNameUpperCamel}Controller 获取信息异常!");
        }
        PageInfo pageInfo = new PageInfo(list);
        return Result.ok().setData(pageInfo);
    }

    @ApiOperation(value = "添加信息")
    @PostMapping("/add")
    public Result add(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        try{
            ${modelNameLowerCamel}Service.save(${modelNameLowerCamel});
        }catch (Exception e) {
            log.error("${modelNameUpperCamel}Controller 保存信息异常:{}", e);
            return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg("${modelNameUpperCamel}Controller 保存信息异常!");
        }
        return Result.ok();
    }

    @ApiOperation(value = "修改信息")
    @PutMapping("/update")
    public Result update(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        try{
            ${modelNameLowerCamel}Service.update(${modelNameLowerCamel});
        }catch (Exception e) {
            log.error("${modelNameUpperCamel}Controller 更新信息异常:{}", e);
            return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg("${modelNameUpperCamel}Controller 更新信息异常!");
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
            ${modelNameLowerCamel}Service.deleteById(id);
        }catch (Exception e) {
            log.error("${modelNameUpperCamel}Controller 更新信息异常:{}", e);
            return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg("${modelNameUpperCamel}Controller 更新信息异常!");
        }
        return Result.ok();
    }
}
