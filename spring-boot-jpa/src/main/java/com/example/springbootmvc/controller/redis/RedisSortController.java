package com.example.springbootmvc.controller.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author wuxiaopeng
 * @date 2019-05-06
 */
@Controller
@RequestMapping("/sort")
public class RedisSortController {

	public static String SALES_LIST = "phone:sales:list";
	public static String BUY_DYNAMIC = "phone:buy:dynamic";
	public static String separator = "#";

	@Autowired
	@Qualifier("redisTemplate")
	private RedisTemplate redisClient;

	@RequestMapping("/simpleset")
	public @ResponseBody String simpleSet(){

		return "success";
	}

	public int phoneRank(int phoneId) {
		int hello = 0;
		return 0;
	}
}
