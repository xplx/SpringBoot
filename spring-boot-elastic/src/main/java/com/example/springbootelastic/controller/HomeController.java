package com.example.springbootelastic.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaopeng
 * @date 2021年09月09日 9:14
 * @description 测试线程安全
 */
@RestController
//@Scope("prototype")
public class HomeController {
    private int i;
    private ThreadLocal<Integer> j = new ThreadLocal<>();

    /**
     * ThreadLocal的方式可以达到线程隔离，但还是无法达到并发安全。
     * @return
     */
    @GetMapping("testsingleton1")
    public int test1() {
        return ++i;
    }

    /**
     * web服务器默认的请求线程池大小为10，这10个核心线程可以被之后不同的Http请求复用，
     * 所以这也是为什么相同线程名的结果不会重复的原因。
     * @return
     */
    @GetMapping("testsingleton2")
    public int test2() {
        if (j.get() == null) {
            j.set(0);
        }
        j.set(j.get().intValue() + 1);
        System.out.println("{}" + Thread.currentThread().getName() + "-> {}" + j.get());
        return j.get().intValue();
    }


}
