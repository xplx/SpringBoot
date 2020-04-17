package com.example.seed.controller;

import com.example.seed.model.entity.UserInfo;
import com.example.seed.service.UserInfoService;
import com.example.seed.support.utils.Result;
import com.example.seed.support.utils.enums.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wuxiaopeng
 * @description: 测试事物回滚
 * @date 2020/3/16 15:46
 */
@Slf4j
@RestController
@RequestMapping("/user/transactional")
@Api(tags = "事物回滚测试 TransactionalController")
public class TransactionalController {
    @Resource
    private UserInfoService userInfoService;

    /**
     * 1：有try、@Transactional异常不回滚
     *
     * @param userInfo
     * @return
     */
    @ApiOperation(value = "添加或更新信息(addTryRuntime)")
    @PostMapping("/addTryRuntime")
    @Transactional(rollbackFor = Exception.class)
    public Result addTry(UserInfo userInfo) {
        try {
            userInfoService.saveSelectiveObject(userInfo);
            if (true) {
                throw new RuntimeException();
            }
        } catch (Exception e) {
            log.info("业务异常：", e);
            //添加这样才能进行事物回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg("UserInfoController 保存信息异常!");
        }
        return Result.ok();
    }

    /**
     * 1：有try、@Transactional没有return可以回滚
     *
     * @param userInfo
     * @return
     */
    @ApiOperation(value = "添加或更新信息(addTryNoBack)")
    @PostMapping("/addTryNoBack")
    @Transactional(rollbackFor = Exception.class)
    public void addTryNoBack(UserInfo userInfo) {
        try {
            userInfoService.saveSelectiveObject(userInfo);
            if (true) {
                throw new RuntimeException();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 1：有try、@Transactional没有return可以回滚
     *
     * @param userInfo
     * @return
     */
    @ApiOperation(value = "添加或更新信息(addTryYesBack)")
    @PostMapping("/addTryYesBack")
    @Transactional(rollbackFor = Exception.class)
    public void addTryYesBack(UserInfo userInfo) {
        try {
            userInfoService.saveSelectiveObject(userInfo);
            if (true) {
                throw new RuntimeException();
            }
        } catch (Exception e) {
            log.info("异常：", e);
            throw e;
            //return getBack("fail");
        }
    }


    public String getBack(String str) {
        return str;
    }

    /**
     * 1：@Transactional,如果事务内报了RuntimeException错误，事务可以回滚。
     *
     * @param userInfo
     * @return
     */
    @ApiOperation(value = "添加或更新信息(addRuntime)")
    @PostMapping("/addRuntime")
    @Transactional
    public Result addRuntimeNoTry(UserInfo userInfo) {
        userInfoService.saveSelectiveObject(userInfo);
        if (true) {
            throw new RuntimeException();
        }
        return Result.ok();
    }

    /**
     * 1：@Transactional,不会回滚，如果事务内报了Exception错误（非RuntimeException错误），事务不可以回滚
     * 2：@Transactional(rollbackFor = Exception.class)，加上rollbackFor = Exception.class 参数也可以实现回滚。
     *
     * @param userInfo
     * @return
     */
    @ApiOperation(value = "添加或更新信息(addException)")
    @PostMapping("/addException")
    @Transactional(rollbackFor = Exception.class)
    public Result addExceptionNoTry(UserInfo userInfo) throws Exception {
        userInfoService.saveSelectiveObject(userInfo);
        if (true) {
            throw new Exception();
        }
        return Result.ok();
    }
}
