package com.example.seed.support.mybatis.plugin;


import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.util.Properties;

/**
 * @author wuxiaopeng
 * @description: 拦截到执行的sql再对该sql进行改写
 * @date 2020/4/15 11:41
 */
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})})
public class SqlStatusInterceptor implements Interceptor {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
        //获取sql
        String sql = String.valueOf(metaStatementHandler.getValue("delegate.boundSql.sql"));
        //添加limit条件
        sql = "select * from (" + sql + ") as temp limit 1";
        //重新设置sql
        metaStatementHandler.setValue("delegate.boundSql.sql", sql);
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        String dialect = properties.getProperty("dialect");
        log.info("mybatis intercept dialect:{}", dialect);
    }
}
