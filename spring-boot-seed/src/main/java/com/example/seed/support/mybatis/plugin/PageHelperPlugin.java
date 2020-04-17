package com.example.seed.support.mybatis.plugin;

import com.github.pagehelper.BasePageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.plugin.*;

import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * @author wuxiaopeng
 * @description: 分页插件
 * @date 2020/4/14 15:55
 */
@Slf4j
/**
 * type:拦截类。
 * method:拦截方法。
 * args：拦截方法参数。
 */
@Intercepts(@Signature(
        type = ParameterHandler.class,
        method = "setParameters",
        args = {PreparedStatement.class}))
public class PageHelperPlugin extends BasePageHelper implements Interceptor {

    /**
     * //执行代理类方法
     *
     * @param invocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        log.info("Mybatis使用分页插件");
        //invocation.proceed()通过反射进行链式调用，
        // 拦截器实现类的intercept方法里最后不要忘了执行invocation.proceed()方法，
        // 否则多个拦截器情况下，执行链条会断掉。
        return doIntercept(invocation);
    }

    /**
     * 创建代理对象
     *
     * @param target
     * @return
     */
    @Override
    public Object plugin(Object target) {
        log.info("plugin使用分页插件");
        return Plugin.wrap(target, this);
    }

    /**
     * 插件自定义属性
     *
     * @param properties
     */
    @Override
    public void setProperties(Properties properties) {
        log.info("setProperties使用分页插件");
    }

    /**
     * 真正的拦截器方法
     *
     * @param invocation
     * @return
     * @throws Throwable
     */
    public Object doIntercept(Invocation invocation) throws Throwable {
        //获取拦截方法的参数
        Object[] args = invocation.getArgs();
        PreparedStatement ps = (PreparedStatement) args[0];
        System.out.println(ps);
        ParameterMetaData parameterMetaData = ps.getParameterMetaData();
        System.out.println(parameterMetaData);
        ResultSet resultSet = ps.getResultSet();
        System.out.println(resultSet);
        //调用方法判断是否需要进行分页，如果不需要，直接返回结果
        //返回默认查询
        return invocation.proceed();
    }
}
