package center.wxp.mybatissource.support.serverImpl;

import center.wxp.mybatissource.config.Configuration;
import center.wxp.mybatissource.support.server.Executor;
import center.wxp.mybatissource.support.server.SqlSession;
import center.wxp.mybatissource.support.server.SqlSessionFactory;

/**
 * @author wuxiaopeng
 * @description: 目前这个类当中并没有什么实现，
 * 只是接收了configuration，在之后我们会编写openSession的方法获取到一个SqlSession。
 * @date 2020/4/16 16:29
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        Executor executor = new SimpleExecutor(configuration.getJdbcProperties());
        SqlSession sqlSession = new DefaultSqlSession(configuration, executor);
        return sqlSession;
    }
}
