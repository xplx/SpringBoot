package center.wxp.mybatissource.config;

/**
 * @author wuxiaopeng
 * @description:这里对应的是Mapper.xml对应的配置，在这里只是配置了几个基本的，目前未包括全部
 * @date 2020/4/16 16:26
 */
public class MapperStatement {
    //由二位坐标构成的ID=namespave.id
    private String id;
    //sql语句
    private String sql;
    //返回类型
    private String resultType;
    //查询语句类型
    private String queryType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }
}
