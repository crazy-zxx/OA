package com.oa.service;

import java.util.List;

import com.oa.base.BaseDao;
import com.oa.entity.Privilege;

public interface PrivilegeService extends BaseDao<Privilege> {

	/**
	 * 查询所有顶级权限的集合
	 * 
	 * @return
	 */
	List<Privilege> findTopList();

	/**
	 * 查询所有权限URL的集合（不能有null，不能重复）
	 * 
	 * @return
	 */
	List<String> getAllPrivilegeUrls();

}
