package com.example.seed.support.config;

import com.example.seed.support.mybatis.plugin.PageHelperPlugin;
import com.example.seed.support.mybatis.plugin.SqlExecuteTimeCountInterceptor;
import com.example.seed.support.mybatis.plugin.SqlInsertOrUpdateInterceptor;
import com.example.seed.support.mybatis.plugin.SqlStatusInterceptor;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

import static com.example.seed.support.constant.ProjectConstant.MAPPER_PACKAGE;
import static com.example.seed.support.constant.ProjectConstant.MODEL_PACKAGE;


/**
 * Mybatis & Mapper & PageHelper 配置
 */
@Configuration
public class MybatisConfigurer {

    @Bean
    public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        factory.setTypeAliasesPackage(MODEL_PACKAGE);

        //配置分页插件，详情请查阅官方文档
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        //分页尺寸为0时查询所有纪录不再执行分页
        properties.setProperty("pageSizeZero", "true");
        //页码<=0 查询第一页，页码>=总页数查询最后一页
        properties.setProperty("reasonable", "true");
        //支持通过 Mapper 接口参数来传递分页参数
        properties.setProperty("supportMethodsArguments", "true");
        pageHelper.setProperties(properties);

        //添加插件
        factory.setPlugins(new Interceptor[]{pageHelper});

        //自定义插件
        PageHelperPlugin pageHelperPlugin = new PageHelperPlugin();
        pageHelperPlugin.setProperties(properties);

        //自定义插件，改写sql语句
        SqlStatusInterceptor sqlStatusInterceptor = new SqlStatusInterceptor();

        //自定义插件，获取执行时间
        SqlExecuteTimeCountInterceptor sqlExecuteTimeCountInterceptor = new SqlExecuteTimeCountInterceptor();

        //自定义插件，保存或更新时间
        SqlInsertOrUpdateInterceptor sqlInsertOrUpdateInterceptor = new SqlInsertOrUpdateInterceptor();

        //加载插件数组
        Interceptor[] interceptors = {pageHelper, sqlInsertOrUpdateInterceptor, sqlExecuteTimeCountInterceptor};
        factory.setPlugins(interceptors);
        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factory.setConfigLocation(resolver.getResource("classpath:mybatis-config.xml"));
        //factory.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
        //构建会话工厂SqlSessionFactory
        return factory.getObject();
    }

    /**
     * TK的全局配置
     *
     * @return
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
        mapperScannerConfigurer.setBasePackage(MAPPER_PACKAGE);

        //配置通用Mapper，详情请查阅官方文档
        Properties properties = new Properties();
        properties.setProperty("mappers", "tk.mybatis.template.core.Mapper");
        //insert、update是否判断字符串类型!='' 即 test="str != null"表达式内是否追加 and str != ''
        properties.setProperty("notEmpty", "true");
        ////主键自增回写方法,默认值MYSQL,详细说明请看文档
        properties.setProperty("IDENTITY", "MYSQL");
        mapperScannerConfigurer.setProperties(properties);
        return mapperScannerConfigurer;
    }

}

