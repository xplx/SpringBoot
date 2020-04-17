package com.example.seed.support.config;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局事物管理
 * @author wuxiaopeng
 * @date 2020/3/19 9:46
 */
@Aspect
@Configuration
public class TransactionManagerConfig {
    private final static Logger logger = LoggerFactory.getLogger(TransactionManagerConfig.class);
    private static final int AOP_TIME_OUT = 50000;
    /**
     * 第一个” *“符号:表示返回值的类型任意。
     * “*”表示包下的所有类，
     * 而“.. *”表示包，子孙包下的所有类。
     * （..）:括号表示参数，两个点表示任何参数类型。
     */
    //(* com.example.seed.service.*.*(..))
    private static final String AOP_POINTCUT_EXPRESSION = "execution (* com.example.seed.service.*.*(..)) || execution (* com.example.seed.service.*.*(..))";

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Bean
    public TransactionInterceptor txAdvice(){
        NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();

        /** 只读事务，不做更新操作 */
        RuleBasedTransactionAttribute readOnlyTx = new RuleBasedTransactionAttribute();
        readOnlyTx.setReadOnly(true);
        readOnlyTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        /** 当前存在事务就加入当前事务，当前不存在事务就创建一个新的事务 */
        RuleBasedTransactionAttribute requiredTx = new RuleBasedTransactionAttribute();

        /** 什么异常需要回滚 */
        requiredTx.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
        requiredTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        requiredTx.setTimeout(AOP_TIME_OUT);

        Map<String, TransactionAttribute> methodMap = new HashMap<>();
        /** 可以提及事务或回滚事务的方法 */
        methodMap.put("add*", requiredTx);
        methodMap.put("save*", requiredTx);
        methodMap.put("update*", requiredTx);
        methodMap.put("modify*", requiredTx);
        methodMap.put("edit*", requiredTx);
        methodMap.put("insert*", requiredTx);
        methodMap.put("delete*", requiredTx);
        methodMap.put("remove*", requiredTx);
        methodMap.put("repair*", requiredTx);
        methodMap.put("binding*", requiredTx);

        /** 其他方法无事务，只读 */
        methodMap.put("*", readOnlyTx);
        source.setNameMap(methodMap);

        TransactionInterceptor txAdvice = new TransactionInterceptor(transactionManager, source);
        return txAdvice;
    }

    @Bean(name = "txAdviceAdvisor")
    public Advisor txAdviceAdvisor() {
        logger.info("===============================创建txAdviceAdvisor===================================");
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(AOP_POINTCUT_EXPRESSION);
        return new DefaultPointcutAdvisor(pointcut, txAdvice());
    }
}
