package center.wxp.mybatissource.support.server;

import java.util.List;

/**
 * @author wuxiaopeng
 * @description:SqlSession主要是进行数据库操作的
 * @date 2020/4/16 16:24
 */
public interface SqlSession {
    <T> T selectOne(String statement, Object parameter);

    <E> List<E> selectList(String statement);

    <E> List<E> selectList(String statement, Object parameter);

    /**
     * 获取mapper使用动态代理，获取mapper
     * @param type
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> type);
}
