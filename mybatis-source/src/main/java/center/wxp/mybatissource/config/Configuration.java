package center.wxp.mybatissource.config;

import center.wxp.mybatissource.properties.JdbcProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuxiaopeng
 * @description:Configuration这里就是统一进行管理配置以及提供一些对配置基本的操作方法
 * @date 2020/4/16 16:28
 */
public class Configuration {
    private JdbcProperties jdbcProperties;
    private Map<String, MapperStatement> mapperMap = new HashMap<String, MapperStatement>();

    public void addMapperStatement(MapperStatement mapperStatement) {
        mapperMap.put(mapperStatement.getId(), mapperStatement);
    }

    public MapperStatement getMapperStatement(String id) {
        return mapperMap.get(id);
    }

    public JdbcProperties getJdbcProperties() {
        return jdbcProperties;
    }

    public void setJdbcProperties(JdbcProperties jdbcProperties) {
        this.jdbcProperties = jdbcProperties;
    }
}
