package com.example.seed.support.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

import com.example.seed.model.constant.UserInfoStatusEnum;
import com.example.seed.model.constant.StatusValueEnum;

import com.example.seed.model.dto.UserInfoDto;
import com.example.seed.model.vo.UserInfoVo;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;

/**
 * @author wuxiaopeng
 * @description: bean操作类
 * @date 2020/1/6 18:43
 */
public class BeanUtil {
    /**
     * list类转换
     *
     * @param entities
     * @param modelBeanClass
     * @param <T>
     * @param <M>
     * @return
     * @throws Exception
     */
    public static <T, M> ArrayList<M> toModelList(List<T> entities, Class<M> modelBeanClass) {
        try {
            ArrayList<M> modelList = new ArrayList<M>();
            if (!EmptyUtil.isEmpty(entities)) {
                for (T entity : entities) {
                    M currentModel = modelBeanClass.newInstance();
                    modelList.add(toModel(entity, currentModel));
                }
            }
            return modelList;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e.getMessage());
        } catch (InstantiationException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 对象转换
     * @param entity
     * @param model
     * @param <M>
     * @param <E>
     * @return
     */
    public static <M, E> M toModel(E entity, M model) {
        if (model != null && entity != null) {
            BeanUtils.copyProperties(entity, model);
        } else {
            model = null;
        }
        return model;
    }

    public static <M, E> M toModelClass(E entity, Class<M> model) {
        try {
            M currentModel = model.newInstance();
            if (model != null && entity != null) {
                BeanUtils.copyProperties(entity, currentModel);
            } else {
                currentModel = null;
            }
            return currentModel;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e.getMessage());
        } catch (InstantiationException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static <M, E> M copyProperty(E entity, Class<M> model) {
        try {
            Map<String, Object> entityMap = cn.hutool.core.bean.BeanUtil.beanToMap(entity);
            M resultMode = model.newInstance();
            cn.hutool.core.bean.BeanUtil.copyProperties(entity, resultMode);
            System.out.println(resultMode);
            for (Field field : model.getDeclaredFields()) {
                field.setAccessible(true);
                String fieldName = field.getName();
                if (entityMap.containsKey(fieldName)) {
                    if (EmptyUtil.isNotEmpty(entityMap.get(fieldName))) {
                        Object entityValue = entityMap.get(fieldName);
                        field.set(model, entityValue);
                    }
                }
            }
            return resultMode;
        } catch (InstantiationException e) {
            throw new RuntimeException(e.getMessage());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


//    public static void main(String[] args) {
//        UserInfoVo userInfoVo = new UserInfoVo();
//        userInfoVo.setId(0L);
//        userInfoVo.setName("");
//        userInfoVo.setAge(0);
//        userInfoVo.setPassword("");
//        userInfoVo.setSalary(new BigDecimal("0"));
//        userInfoVo.setCreateTime(new Date());
//        userInfoVo.setUpdateTime(new Date());
//
//        UserInfoDto userInfoDto = copyProperty(userInfoVo, UserInfoDto.class);
//    }
}
