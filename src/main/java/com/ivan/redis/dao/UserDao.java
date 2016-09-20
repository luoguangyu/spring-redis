package com.ivan.redis.dao;

import com.ivan.redis.entity.User;

import java.util.List;

/**
 * Created by Ivan.Luo
 * Date: 9/18/2016 4:16 PM
 */
public interface UserDao
{
	/**
	 * ����
	 * <br>------------------------------<br>
	 * @param user
	 * @return
	 */
	boolean add(User user);

	/**
	 * �������� ʹ��pipeline��ʽ
	 * <br>------------------------------<br>
	 * @param list
	 * @return
	 */
	boolean add(List<User> list);

	/**
	 * ɾ��
	 * <br>------------------------------<br>
	 * @param key
	 */
	void delete(String key);

	/**
	 * ɾ�����
	 * <br>------------------------------<br>
	 * @param keys
	 */
	void delete(List<String> keys);

	/**
	 * �޸�
	 * <br>------------------------------<br>
	 * @param user
	 * @return
	 */
	boolean update(User user);

	/**
	 * ͨ��key��ȡ
	 * <br>------------------------------<br>
	 * @param keyId
	 * @return
	 */
	User get(String keyId);
}
