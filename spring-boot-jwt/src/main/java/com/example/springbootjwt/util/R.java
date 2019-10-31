package com.example.springbootjwt.util;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2018-05-16
 * Time: 11:04
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel("返回类")
public class R<T> implements Serializable {

    private static final long serialVersionUID = 6499915993882715319L;

    private static final String CODE = "code";
    private static final String MSG = "msg";

    @ApiModelProperty("code")
    private Integer code=200;

    @ApiModelProperty("返回信息")
    private String msg="操作成功";

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("对象")
    private T data;

    private HashMap<String,Object> exend;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public R setData(T data)  {
        try {
            if (EmptyUtil.isNotEmpty(data)) {
                if (!isAllFieldNull(data)) {
                    this.data = data;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonIgnore
    public HashMap<String, Object> getExend() {
        return exend;
    }

    public void setExend(HashMap<String, Object> exend) {
        this.exend = exend;
    }

    public R() {
        exend = new HashMap<>();
    }

    public static R failure(int code, String msg) {
        R r = new R();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.exend.putAll(map);
        return r;
    }

    public static R ok() {
        return new R();
    }

    public R put(String key, Object value) {
        exend.put(key, value);
        return this;
    }


    public boolean isAllFieldNull(Object obj) throws Exception{
        Class stuCla = (Class) obj.getClass();
        Field[] fs = stuCla.getDeclaredFields();
        boolean flag = true;
        for (Field f : fs) {
            f.setAccessible(true);
            Object val = f.get(obj);
            if(val!=null) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
