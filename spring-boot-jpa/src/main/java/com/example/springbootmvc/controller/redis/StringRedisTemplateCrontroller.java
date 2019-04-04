package com.example.springbootmvc.controller.redis;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * redis常用操作
 */
@Controller
@RequestMapping("/redis")
public class StringRedisTemplateCrontroller {

	@Autowired
	private StringRedisTemplate redisClient;
	
	@RequestMapping("/setget.html") 
	public @ResponseBody String env(@RequestParam(defaultValue="123") String para  ) throws Exception{
		//设置redis值
		redisClient.opsForValue().set("testenv", para);
		String str = redisClient.opsForValue().get("testenv");
		return str;
	}
	
	@RequestMapping("/addmessage.html") 
	public @ResponseBody String addMessage() throws Exception{
		//leftPush提交到最前面代码。
		redisClient.opsForList().leftPush("platform:message","hello,xiandafu left");
		redisClient.opsForList().leftPush("platform:message","hello,spring boot");
		return "success";
	}
	
	@RequestMapping("/readmessage.html") 
	public @ResponseBody String readMessage() throws Exception{
		String str = redisClient.opsForList().leftPop("platform:message");
		return str;
	}
	
	
	@RequestMapping("/addcache.html") 
	public @ResponseBody String addMessage(String key,String value) throws Exception{
		redisClient.opsForHash().put("cache", key, value);
		return "success";
	}
	
	@RequestMapping("/getcache.html") 
	public @ResponseBody String addMessage(String key) throws Exception{
		String str = (String)redisClient.opsForHash().get("cache", key);
		return str;
	}
	
	@RequestMapping("/boundvalue.html") 
	public @ResponseBody String boundValue (String key) throws Exception{
		BoundListOperations operations = redisClient.boundListOps(key);
		operations.leftPush("a");
		operations.leftPush("b");
		return String.valueOf(operations.size());		
		
	}

	@RequestMapping("/publish")
	public @ResponseBody String publishNews()throws Exception{
		redisClient.convertAndSend("news", "hello,word");
		return "success";
	}
	
	@RequestMapping("/connectionset.html") 
	public @ResponseBody String connectionSet (final String key,final String value) throws Exception{
		redisClient.execute(new RedisCallback(){

			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				try {
					connection.set(key.getBytes("UTF-8"), value.getBytes("UTF-8"));
				} catch (UnsupportedEncodingException e) {
					throw new RuntimeException(e);
				}
				return null;
			}
			
		});
		
		return "success";
		
	}
	
	
}
