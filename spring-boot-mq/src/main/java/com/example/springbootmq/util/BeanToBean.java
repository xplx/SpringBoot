package com.example.springbootmq.util;

import com.example.springbootmq.bean.Users;
import com.example.springbootmq.bean.UsersModel;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @Description:
 * @author:wuxiaopeng
 * @create: 2019-02-20 16:49
 **/
public class BeanToBean {
    /**
     * 将dto和entity之间的属性互相转换,dto中属性一般为String等基本类型,
     * <p>
     * 但是entity中可能有复合主键等复杂类型,需要注意同名问题
     * @param src
     * @param target
     */

    public static Object populate(Object src, Object target) {
        Method[] srcMethods = src.getClass().getMethods();
        Method[] targetMethods = target.getClass().getMethods();
        for (Method m : srcMethods) {
            String srcName = m.getName();
            if (srcName.startsWith("get")) {
                try {
                    Object result = m.invoke(src);
                    for (Method mm : targetMethods) {
                        String targetName = mm.getName();
                        if (targetName.startsWith("set")
                                && targetName.substring(3, targetName.length())
                                .equals(srcName.substring(3, srcName.length()))) {
                            mm.invoke(target, result);
                        }
                    }
                } catch (Exception e) {
                }
            }
        }
        return target;
    }

    /**
     * dto集合和实体类集合间的互相属性映射
     *
     * @param src
     * @param target
     * @param targetClass
     * @return
     */

    @SuppressWarnings("unchecked")
    public static <S, T> List<T> populateList(List<S> src, List<T> target,
                                              Class<?> targetClass) {
        for (int i = 0; i < src.size(); i++) {
            try {
                Object object = targetClass.newInstance();
                target.add((T) object);
                populate(src.get(i), object);
            } catch (Exception e) {
                continue;// 某个方法反射异常
            }
        }
        return target;

    }

    public static void main(String[] args) {
        Users users = new Users();
        users.setId(1);
        users.setUsername("huang");
        users.setPassword("123456");
        UsersModel usersModel = new UsersModel();
        usersModel = (UsersModel) BeanToBean.populate(users, usersModel);
        System.out.println(usersModel.toString());
    }

}
