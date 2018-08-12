package com.example.druid.pojo;

import javax.persistence.*;

public class Department {
    @Id
    private Integer id;

    private String name;

    private String partment;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return partment
     */
    public String getPartment() {
        return partment;
    }

    /**
     * @param partment
     */
    public void setPartment(String partment) {
        this.partment = partment;
    }
}