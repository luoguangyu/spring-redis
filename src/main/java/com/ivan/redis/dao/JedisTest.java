package com.ivan.redis.dao;

import com.google.gson.Gson;
import com.ivan.redis.entity.User;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ivan.Luo
 * Date: 9/18/2016 5:45 PM
 *
 * Use Jedis to access Redis directly
 */
public class JedisTest
{
	public static void main(String[] args)
	{
		Jedis jedis = new Jedis("localhost", 6379);
		jedis.auth("ivan");
		JedisTest jedisTest = new JedisTest();

		jedisTest.listTest(jedis);
		jedisTest.mapTest(jedis);
		jedisTest.setTest(jedis);
	}

	/**
	 * List operation
	 * @param jedis
	 */
	void listTest(Jedis jedis)
	{
		System.out.println("list testing...");
		//jedis.del("list1");
		System.out.println(jedis.lrange("list1", 0, -1));
		User u = new User();
		u.setId("1");
		u.setName("ivan");

		Gson gson = new Gson();
		String objectJson = gson.toJson(u);
		System.out.println("user to be added: " + objectJson);
		jedis.lpush("list1", objectJson);
	}

	void mapTest(Jedis jedis)
	{
		System.out.println("map testing...");
		Map map = new HashMap<String, String>();

		map.put("name", "xinxin");
		map.put("age", "22");
		map.put("qq", "123456");
		jedis.hmset("map1", map);

		List<String> rsmap = jedis.hmget("map1", "name", "age", "qq");
		System.out.println(rsmap);
	}

	void setTest(Jedis jedis)
	{
		System.out.println("set testing...");
		jedis.sadd("set1", "liu");
		jedis.sadd("set1", "liu1");
		jedis.sadd("set1", "liu1");

		System.out.println(jedis.smembers("set1"));//获取所有加入的value
		System.out.println(jedis.sismember("set1", "who"));//判断 who 是否是user集合的元素
		System.out.println(jedis.srandmember("set1"));
		System.out.println(jedis.scard("set1"));//返回集合的元素个数
	}
}
