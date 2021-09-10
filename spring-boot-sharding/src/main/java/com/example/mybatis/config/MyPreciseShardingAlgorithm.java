//package com.example.mybatis.config;
//
//import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
//import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
//
//import java.util.Collection;
//
///**
// * @author wuxiaopeng
// * @description: MyPreciseShardingAlgorithm是根据id取模4来获取表名的
// * @date 2019/12/13 9:41
// */
//public class MyPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Integer> {
//    @Override
//    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Integer> shardingValue) {
//        for (String tableName : availableTargetNames) {
//            if (tableName.endsWith(shardingValue.getValue() % 4 + "")) {
//                return tableName;
//            }
//        }
//        throw new IllegalArgumentException();
//    }
//}
