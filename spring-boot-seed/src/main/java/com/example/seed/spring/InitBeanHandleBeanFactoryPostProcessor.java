package com.example.seed.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author xiaopeng
 * @date 2021年03月25日 14:17
 * @description 属性处理器BeanFactoryPostProcessor
 */
public class InitBeanHandleBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition getBeanInitOrder = beanFactory.getBeanDefinition("getBeanInitOrder");
        MutablePropertyValues propertyValues = getBeanInitOrder.getPropertyValues();
        propertyValues.addPropertyValue("name", "mateEgg");
        System.out.println("执行BeanFactoryPostProcessor的postProcessBeanFactory方法");
    }
}
