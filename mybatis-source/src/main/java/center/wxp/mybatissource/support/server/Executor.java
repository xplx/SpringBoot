package center.wxp.mybatissource.support.server;

import center.wxp.mybatissource.config.MapperStatement;

import java.util.List;

/**
 * @author wuxiaopeng
 * @description:
 * @date 2020/4/16 16:39
 */
public interface Executor {
    /**
     *
     * @param ms
     * @param parameter
     * @param <E>
     * @return
     */
    <E> List<E> query(MapperStatement ms, Object parameter);
}
