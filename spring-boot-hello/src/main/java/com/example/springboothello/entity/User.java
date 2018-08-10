package com.example.springboothello.entity;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;

public class User {
	//直接定义类
	public interface Update{}
	public interface Add{}


	@NotNull(groups={Update.class})
	@NotNull(message = "id不能为空")
	@Min(value = 1, message = "id必须为正整数")
	Long id;

	/**
	 * 分组调用
	 */
	@NotNull(groups={Update.class})
	@NotNull(message = "name不能为空")
	String name;

	Date time;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
}
