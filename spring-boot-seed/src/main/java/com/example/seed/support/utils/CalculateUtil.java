package com.example.seed.support.utils;

import cn.hutool.core.convert.Convert;

import java.math.BigDecimal;

/**
 * 我们在使用BigDecimal时，使用它的BigDecimal(String)构造器创建对象才有意义。
 * 其他的如BigDecimal b = new BigDecimal(1)这种，还是会发生精度丢失的问题。
 * @author wuxiaopeng
 */
public class CalculateUtil {

    public static final String add = "+";
    public static final String minus = "-";
    public static final String mul = "*";
    public static final String div = "/";


    /**
     * Double计算
     * 使用进行BigDecimal计算
     * 除法默认保留两位四舍五入的算法
     */
    public static Double getArithmetic(Object a, Object b, String operatorType) {
        BigDecimal a1 = new BigDecimal(String.valueOf(a));
        BigDecimal b1 = new BigDecimal(String.valueOf(b));
        if (operatorType.equals(add)) {
            return a1.add(b1).doubleValue();
        } else if (operatorType.equals(minus)) {
            return a1.subtract(b1).doubleValue();
        } else if (operatorType.equals(mul)) {
            return a1.multiply(b1).doubleValue();
        } else if (operatorType.equals(div)) {
            return a1.divide(b1, 2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        return null;
    }

    /**
     * 乘法计算,四舍五入
     */
    public static BigDecimal multiply(BigDecimal a, BigDecimal b, Integer newScale) {
        if (EmptyUtil.isEmpty(newScale)) {
            newScale = 2;
        }
        return a.multiply(b).setScale(newScale, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 乘法计算,四舍五入
     */
    public static BigDecimal multiply(BigDecimal a, BigDecimal b) {
        return a.multiply(b).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 除法计算
     */
    public static Double getDivArithmetic(String a, String b, int roundingMode, int scale) {
        BigDecimal a1 = new BigDecimal(a);
        BigDecimal b1 = new BigDecimal(b);
        return a1.divide(b1, scale, roundingMode).doubleValue();
    }

    /**
     * 为空返回0
     */
    public static BigDecimal toNullZero(Object obj) {
        BigDecimal back = Convert.toBigDecimal(obj);
        if (EmptyUtil.isEmpty(back)) {
            return BigDecimal.ZERO;
        }
        return back;
    }

    public static void main(String[] args) {
        //丢失精度
        BigDecimal a = new BigDecimal(1.01);
        BigDecimal b = new BigDecimal(1.02);
        //使用它的BigDecimal(String)构造器创建对象才有意义,不会丢失精度
        BigDecimal c = new BigDecimal("1.01");
        BigDecimal d = new BigDecimal("1.02");
        System.out.println(a.add(b));
        System.out.println(c.add(d));
    }
}
