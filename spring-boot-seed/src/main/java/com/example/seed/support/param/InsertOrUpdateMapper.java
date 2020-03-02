package com.example.seed.support.param;

import org.apache.ibatis.annotations.InsertProvider;

import java.util.List;

@tk.mybatis.mapper.annotation.RegisterMapper
public interface InsertOrUpdateMapper<T> {
    /**
     * 根据Condition条件进行查询，删除获取到的id数据
     *
     * @param condition
     * @return
     */
    @InsertProvider(type = InsertOrUpdate.class, method = "dynamicSQL")
    int insertOrUpdateKeySelective(Object condition);

    /**
     * 批量插入或更新数据
     *
     * @param recordList
     * @return
     */
    @InsertProvider(type = InsertOrUpdate.class, method = "dynamicSQL")
    int insertOrUpdateSelectiveList(List<? extends T> recordList);
}
