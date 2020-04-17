package center.wxp.mybatissource;

import center.wxp.mybatissource.mapper.UserInfoMapper;
import center.wxp.mybatissource.mode.UserInfoVo;
import center.wxp.mybatissource.support.SqlSessionFactoryBuilder;
import center.wxp.mybatissource.support.server.SqlSession;
import center.wxp.mybatissource.support.server.SqlSessionFactory;

import java.io.InputStream;
import java.util.List;

/**
 * @author wuxiaopeng
 * @description:
 * @date 2020/4/16 16:31
 */
public class App {
    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        InputStream inputStream = App.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        System.out.println(sqlSessionFactory);
        System.out.println(sqlSessionFactory.getConfiguration().getJdbcProperties().getUrl());

        SqlSession sqlSession = sqlSessionFactory.openSession();


        UserInfoVo userInfoVo = null;
        List<UserInfoVo> userInfoVos = null;

        //使用sqlSession直接查询
//        userInfoVo = sqlSession.selectOne("center.wxp.mybatissource.mapper.UserInfoMapper.getById", 1L);
//        System.out.println(userInfoVo);
//        userInfoVos = sqlSession.selectList("center.wxp.mybatissource.mapper.UserInfoMapper.getAll");
//        System.out.println(userInfoVos);


        //使用Mapper
        UserInfoMapper demoMapper = sqlSession.getMapper(UserInfoMapper.class);
        userInfoVo = demoMapper.getById(1);
        System.out.println(userInfoVo);
        userInfoVos = demoMapper.getAll();
        System.out.println(userInfoVos);
    }
}
