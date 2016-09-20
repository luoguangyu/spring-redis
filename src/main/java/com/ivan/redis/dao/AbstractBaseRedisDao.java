package com.ivan.redis.dao;

/**
 * Created by Ivan.Luo
 * Date: 9/18/2016 4:11 PM
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * AbstractBaseRedisDao
 *
 * @author http://blog.csdn.net/java2000_wl
 * @version <b>1.0</b>
 */
public abstract class AbstractBaseRedisDao<K, V>
{

	@Autowired
	protected RedisTemplate<K, V> redisTemplate;

	/**
	 * ����redisTemplate
	 *
	 * @param redisTemplate the redisTemplate to set
	 */
	public void setRedisTemplate(RedisTemplate<K, V> redisTemplate)
	{
		this.redisTemplate = redisTemplate;
	}

	/**
	 * ��ȡ RedisSerializer
	 * <br>------------------------------<br>
	 */
	protected RedisSerializer<String> getRedisSerializer()
	{
		return redisTemplate.getStringSerializer();
	}
}