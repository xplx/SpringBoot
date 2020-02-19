package com.example.seed.entity;

import java.io.Serializable;

/**
 * (Test)实体类
 *
 * @author wxp
 * @since 2020-02-09 19:34:13
 */
public class Test implements Serializable {
    private static final long serialVersionUID = 518164274259706981L;
    
    private Integer id;
    
    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}