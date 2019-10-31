package com.example.seed.support.core;

import org.apache.ibatis.exceptions.TooManyResultsException;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

/**
 * Service 层 基础接口，其他Service 接口 请继承该接口
 */
public interface Service<T> {
    /**
     * 主键查询
     * @param id
     * @return
     */
    T findById(Object id);

    /**
     * //通过Model中某个成员变量名称（非数据表中column的名称）查找,value需符合unique约束
     * @param fieldName
     * @param value
     * @return
     * @throws TooManyResultsException
     */
    T findBy(String fieldName, Object value) throws TooManyResultsException;

    /**
     * 通过多个ID查找//eg：ids -> “1,2,3,4”
     * @param ids
     * @return
     */
    List<T> findByIds(String ids);

    /**
     * 根据条件查询
     * @param condition
     * @return
     */
    List<T> findByCondition(Condition condition);

    /**
     * 获取所有
     * @return
     */
    List<T> findAll();//获取所有

    /**
     * 实体类保存
     * @param model
     */
    void save(T model);

    /**
     * 批量保存
     * @param models
     */
    void save(List<T> models);

    /**
     * 实体类更新
     * @param model
     */
    void update(T model);
    /**
     * 通过主鍵刪除
     * @param id
     */
    void deleteById(Object id);//

    /**
     * //批量刪除 eg：ids -> “1,2,3,4”(数组形式)
     * @param ids
     */
    void deleteByIds(String ids);

}
