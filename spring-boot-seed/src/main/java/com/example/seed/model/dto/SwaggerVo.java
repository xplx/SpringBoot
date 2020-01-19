package com.example.seed.model.dto;

/**
 * @author wuxiaopeng
 * @description: swagger的返回值
 * @date 2020/1/11 10:02
 */
public class SwaggerVo {
    /**
     * 参数名
     */
    private String name;
    /**
     * 查询方式
     */
    private String in;
    /**
     * 描述
     */
    private String description;
    /**
     * 是否必传
     */
    private String required;
    /**
     * 参数类型
     */
    private String type;
    /**
     * 示例值
     */
    private String example;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIn() {
        return in;
    }

    public void setIn(String in) {
        this.in = in;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    @Override
    public String toString() {
        return "SwaggerVo{" +
                "name='" + name + '\'' +
                ", in='" + in + '\'' +
                ", description='" + description + '\'' +
                ", required='" + required + '\'' +
                ", type='" + type + '\'' +
                ", example='" + example + '\'' +
                '}';
    }
}
