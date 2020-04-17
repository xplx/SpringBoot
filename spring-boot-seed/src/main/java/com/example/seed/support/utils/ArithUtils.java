package com.example.seed.support.utils;

import java.math.BigDecimal;

/**
 * @author wuxiaopeng
 * @description:数学计算工具类由于Java的简单类型不能够精确的对浮点数进行运算，
 * 这个工具类提供精 确的浮点数运算，包括加减乘除和四舍五入。
 * @date 2020/4/9 9:43
 */
public class ArithUtils {
    public static void main(String[] args) {
        double d1 = 0.09;
        double d2 = 0.01;
        double d3 = d2 + d1;
        //结果：0.09999999999999999，金额必须是完全精确的计算, 故不能使用double或者float, 而应该采用java.math.BigDecimal.
        System.out.println(d3);
        BigDecimal b1 = new BigDecimal(0.09);
        BigDecimal b2 = new BigDecimal(0.01);
        //结果：0.09999999999999999687749774324174723005853593349456787109375
        System.out.println(b1.add(b2));
        BigDecimal b3 = new BigDecimal("0.09");
        BigDecimal b4 = new BigDecimal("0.01");
        System.out.println(b3.add(b4));
        BigDecimal a = new BigDecimal("1.00");
        BigDecimal b = new BigDecimal(1);
        System.out.println(a.equals(b));
        //BigDecimal比较时，不仅比较值，而且还比较精度？
        if(a.compareTo(b)==0){
            System.out.println("true");
        }
    }
}
