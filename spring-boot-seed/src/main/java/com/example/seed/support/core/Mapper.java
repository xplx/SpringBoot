package com.example.seed.support.core;


import com.example.seed.support.param.DeleteBySelectMapper;
import com.example.seed.support.param.InsertOrUpdateMapper;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

/**
 * 定制版MyBatis Mapper插件接口，如需其他接口参考官方文档自行添加。
 * @author wuxiaopeng
 * @date 2020-03-03
 */
public interface Mapper<T>
        extends
        BaseMapper<T>,
        ConditionMapper<T>,
        IdsMapper<T>,
        InsertListMapper<T>,
        DeleteBySelectMapper<T>,
        InsertOrUpdateMapper<T> {
}
