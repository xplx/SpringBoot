package center.wxp.mybatissource.support.serverImpl;

import center.wxp.mybatissource.config.MapperStatement;
import center.wxp.mybatissource.properties.JdbcProperties;
import center.wxp.mybatissource.support.server.Executor;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wuxiaopeng
 * @description:最基本的SimpleExecutor.
 * （1）在MyBatis中这个代码是分好几个类进行处理的，这里为了讲解方便，统一放在一个类中。
 *
 * （2）数据库的连接操作：这里使用jdbc连接数据库获取到connection进行操作。
 *
 * （3）使用泛型处理返回的结果（handlerResultSet）。
 * @date 2020/4/16 16:39
 */
public class SimpleExecutor implements Executor {
    private JdbcProperties jdbcProperties;

    /**
     * 这里我们实现了最基本的Simple,在MyBatis有3种情况需要处理，我们实现最简单的方式
     * 这里我们接收了jdbcproperties为了之后直接进行数据库的连接操作，
     * 在mybatis数据库的连接关闭，提交，回滚是有一个事务类Transaction。
     *
     * @param jdbcProperties
     */
    public SimpleExecutor(JdbcProperties jdbcProperties) {
        this.jdbcProperties = jdbcProperties;
    }

    @Override
    public <E> List<E> query(MapperStatement ms, Object parameter) {
        //具体的方法待实现
        List<E> ret = new ArrayList<E>();
        // 具体的方法待实现
        try {
            // 加载驱动
            Class.forName(jdbcProperties.getDriver());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // 获取连接
            connection = DriverManager.getConnection(jdbcProperties.getUrl(), jdbcProperties.getUsername(),
                    jdbcProperties.getPassword());
            // 预编译sql语句
            preparedStatement = connection.prepareStatement(ms.getSql());
            // 处理sql语句中的占位符
            parameterize(preparedStatement, parameter);
            // 执行sql语句
            resultSet = preparedStatement.executeQuery();
            // 处理结果
            handlerResultSet(resultSet, ret, ms.getResultType());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ret;
    }

    /**
     * 参数设置
     * @param preparedStatement
     * @param parameter
     * @throws SQLException
     */
    private void parameterize(PreparedStatement preparedStatement, Object parameter) throws SQLException {
        if (parameter instanceof String) {
            preparedStatement.setString(1, (String) parameter);
        } else if (parameter instanceof Long) {
            preparedStatement.setLong(1, (Long) parameter);
        } else if (parameter instanceof Integer) {
            preparedStatement.setInt(1, (Integer) parameter);
        }
    }

    private <E> void handlerResultSet(ResultSet resultSet, List<E> ret, String className) {
        Class<E> clazz = null;
        try {
            clazz = (Class<E>) Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            while (resultSet.next()) {
                // 通过反射实例化对象
                Object entity = clazz.newInstance();
                // 使用反射工具将resultSet中的数据填充到entity中
                // id,name,sex,age
                // 获取实体类的所有属性，返回Field数组
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);
                    String fname = field.getName();
                    Type type = field.getGenericType();
                    if (type.toString().equals("class java.lang.String")) {
                        String column = resultSet.getString(fname);
                        field.set(entity, column);
                    } else if (type.toString().equals("class java.lang.Long")) {
                        Long column = resultSet.getLong(fname);
                        field.set(entity, column);
                    }else {
                        Object column = resultSet.getObject(fname);
                        field.set(entity, column);
                    }
                }
                ret.add((E) entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
