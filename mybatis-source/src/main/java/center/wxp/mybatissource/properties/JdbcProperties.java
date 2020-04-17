package center.wxp.mybatissource.properties;

/**
 * @author wuxiaopeng
 * @description:这里配置的是上面对应的jdbc.properties配置文件的字段
 * @date 2020/4/16 16:25
 */
public class JdbcProperties {
    private String url;
    private String driver;
    private String username;
    private String password;
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getDriver() {
        return driver;
    }
    public void setDriver(String driver) {
        this.driver = driver;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
