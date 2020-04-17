package center.wxp.mybatissource.support.serverImpl;

import center.wxp.mybatissource.config.Configuration;
import center.wxp.mybatissource.proxy.MapperProxy;
import center.wxp.mybatissource.support.server.Executor;
import center.wxp.mybatissource.support.server.SqlSession;

import java.lang.reflect.Proxy;
import java.util.List;

/**
 * @author wuxiaopeng
 * @description: DefaultSqlSession的具体处理交给了Executor，
 * 所以这里的具体的实现就比较简单了
 * @date 2020/4/16 16:45
 */
public class DefaultSqlSession implements SqlSession {
    private Configuration configuration;
    private Executor executor;

    public DefaultSqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    @Override
    public <E> List<E> selectList(String statement) {
        return executor.query(configuration.getMapperStatement(statement), null);
    }

    @Override
    public <E> List<E> selectList(String statement, Object parameter) {
        return executor.query(configuration.getMapperStatement(statement), parameter);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        List<T> list = executor.query(configuration.getMapperStatement(statement), parameter);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        T newProxyInstance = (T) Proxy.newProxyInstance(type.getClassLoader(), new Class[]{type}, new MapperProxy(this));
        return newProxyInstance;
    }
}
