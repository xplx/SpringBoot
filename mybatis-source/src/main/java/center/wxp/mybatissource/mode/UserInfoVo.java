package center.wxp.mybatissource.mode;

import java.math.BigDecimal;
import java.util.Date;

public class UserInfoVo {
    private Long id;

    private String name;

    private Integer age;

    private String password;

    private BigDecimal salary;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "UserInfoVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", salary=" + salary +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}