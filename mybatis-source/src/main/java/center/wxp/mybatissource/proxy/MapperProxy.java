package center.wxp.mybatissource.proxy;

import center.wxp.mybatissource.support.server.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collection;

/**
 * @author wuxiaopeng
 * @description:
 * （1）由于MapperProxy是一个代理类，所以需要实现接口InvocationHandler的Invoke方法。
 * （2）在Invoke方法中直接使用SqlSession进行执行，那么主要的核心就是要判断具体执行什么方法，这里现在通过返回值是否是集合来判断是否是执行selectOne还是SelectList。
 * @date 2020/4/16 16:51
 */
public class MapperProxy implements InvocationHandler {
    private SqlSession sqlSession;

    public MapperProxy(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String statement = method.getDeclaringClass().getName() + "." + method.getName();
        //isAssignableFrom方法是判断是否为某个类的父类
        if (Collection.class.isAssignableFrom(method.getReturnType())) {
            //返回值是集合的话，那么是调用selectList
            return sqlSession.selectList(statement, null == args ? null : args[0]);
        } else {
            return sqlSession.selectOne(statement, null == args ? null : args[0]);
        }
    }
}
