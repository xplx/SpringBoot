package com.example.seed.support.param;

import org.apache.ibatis.annotations.DeleteProvider;

@tk.mybatis.mapper.annotation.RegisterMapper
public interface DeleteBySelectMapper<T> {
    /**
     * 根据Condition条件进行查询，删除获取到的id数据
     *
     * @param condition
     * @return
     */
    @DeleteProvider(type = DeleteBySelect.class, method = "dynamicSQL")
    int deleteBySelectCondition(Object condition);
}
