package com.example.seed.support.mybatis.plugin;

import com.example.seed.support.mybatis.plugin.annotation.CreateTime;
import com.example.seed.support.mybatis.plugin.annotation.UpdateTime;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Properties;

/**
 * @author wuxiaopeng
 * @description: 自定义拦截器实现在新增/更新操作时动态为sql注入creationDate以及lastUpdateDate时间字段
 * @date 2020/4/15 14:08
 */
@Intercepts({@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})})
public class SqlInsertOrUpdateInterceptor implements Interceptor {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        // 获取 SQL 命令
        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
        log.info("获取到的sql命令为:{}", sqlCommandType);
        // 获取参数
        Object parameter = invocation.getArgs()[1];
        if (parameter != null) {
            // 获取成员变量
            Field[] declaredFields = parameter.getClass().getDeclaredFields();
            for (Field field : declaredFields) {
                if (field.getAnnotation(CreateTime.class) != null) {
                    // insert 语句插入 createTime
                    if (SqlCommandType.INSERT.equals(sqlCommandType)) {
                        field.setAccessible(true);
                        if (field.get(parameter) == null) {
                            field.set(parameter, new Date());
                        }
                    }
                }
                // insert 或 update 语句插入 updateTime
                if (field.getAnnotation(UpdateTime.class) != null) {
                    if (SqlCommandType.INSERT.equals(sqlCommandType) || SqlCommandType.UPDATE.equals(sqlCommandType)) {
                        field.setAccessible(true);
                        if (field.get(parameter) == null) {
                            field.set(parameter, new Date());
                        }
                    }
                }
            }
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
