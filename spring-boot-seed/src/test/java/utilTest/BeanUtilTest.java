package utilTest;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.DynaBean;
import cn.hutool.core.collection.CollUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author wuxiaopeng
 * @description:
 * @date 2020/1/21 13:50
 */
public class BeanUtilTest {
    public static void main(String[] args) {
        beanToMap();
    }

    /**
     *
     */
    private static void beanToMap(){
        SubPerson person = new SubPerson();
        person.setAge(14);
        person.setName("测试A11");
        person.setSubName("sub名字");

        Map<String, Object> map = BeanUtil.beanToMap(person);
        DynaBean bean = BeanUtil.createDynaBean("1");
        System.out.println(bean);
        System.out.println(map);
    }
    /**
     *  使用Map填充bean
     */
    private static void fillBeanWithMap(){
        HashMap<String, Object> map = CollUtil.newHashMap();
        map.put("name", "Joe");
        map.put("aGe", 12);
        map.put("openId", "DFDFSDFWERWER");
        map.put("subName", "DFDFSDFWERWER");
        Person p = new Person();
        SubPerson person = BeanUtil.fillBeanWithMap(map, new SubPerson(), true);
        BeanUtil.copyProperties(person, p);
        System.out.println(person);

        //忽略大小写
        SubPerson person1 = BeanUtil.fillBeanWithMapIgnoreCase(map, new SubPerson(), false);
        System.out.println(person1);
    }
}


class Person{
    private String name;
    private int age;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class SubPerson extends Person{
    public static final String SUBNAME = "TEST";

    private UUID id;
    private String subName;
    private Boolean isSlow;

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getSubName() {
        return subName;
    }
    public void setSubName(String subName) {
        this.subName = subName;
    }
    public Boolean isSlow() {
        return isSlow;
    }
    public void setSlow(Boolean isSlow) {
        this.isSlow = isSlow;
    }

    @Override
    public String toString() {
        return "SubPerson{" +
                "id=" + id +
                ", subName='" + subName + '\'' +
                ", isSlow=" + isSlow +
                '}';
    }
}
