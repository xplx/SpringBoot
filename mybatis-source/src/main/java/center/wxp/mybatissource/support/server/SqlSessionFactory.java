package center.wxp.mybatissource.support.server;

import center.wxp.mybatissource.config.Configuration;

/**
 * @author wuxiaopeng
 * @description:SqlSessionFactory主要是管理SqlSession
 * @date 2020/4/16 16:23
 */
public interface SqlSessionFactory {
    public Configuration getConfiguration();

    public SqlSession openSession();
}
