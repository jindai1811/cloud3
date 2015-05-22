package com.serket.cloud.service.base;

import com.serket.cloud.util.Page;

import java.util.List;

public interface BaseService<T> {

	/**
	 * 分页查询
	 * 
	 * @param p
	 *            分页信息 和分页条件
	 */
	void list(Page p);

	/**
	 * 查询所有
	 * @return 列表
	 */
	List<T> findAll( );

	/**
	 * 保存
	 * 
	 * @param obj
	 *            要保存的实体
	 */
	void save(T obj);


	/**
	 * 更新
	 * @param obj 要更新的信息
	 */
	void update(T obj);
	/**
	 * 根据id获取
	 * 
	 * @param id
	 *            id
	 * @return 对象
	 */
	T getById(String id);

	/**
	 * 删除
	 * 
	 * @param ids
	 *            要删除的id的集合
	 */
	void del(String[] ids);

}
