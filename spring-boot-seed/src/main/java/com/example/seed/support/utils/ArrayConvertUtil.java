package com.example.seed.support.utils;

import cn.hutool.core.util.ArrayUtil;
import tk.mybatis.template.util.EmptyUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wuxiaopeng
 * @description: 数组转换
 * @date 2020/3/6 14:37
 */
public class ArrayConvertUtil {

    /**
     * list转换成数组
     * @param objects
     * @return
     */
    public static Object[] listConvertArray(List<Object> objects){
        if (EmptyUtil.isEmpty(objects)) {
            return new Object[1];
        }
        return objects.toArray(new Object[objects.size()]);
    }

    /**
     * 数组转换成list
     * @param objects
     * @return
     */
    public static List<Object> arrayConvertList(Object[] objects){
        if (ArrayUtil.isEmpty(objects)) {
            return new ArrayList<>();
        }
        return Arrays.asList(objects);
    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        String[] strings1 = ArrayUtil.toArray(strings.iterator(), String.class);
        System.out.println(strings1);
    }
}
