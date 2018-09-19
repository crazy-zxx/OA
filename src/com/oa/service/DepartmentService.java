package com.oa.service;

import java.util.List;

import com.oa.base.BaseDao;
import com.oa.entity.Department;

public interface DepartmentService extends BaseDao<Department> {

	/**
	 * 查询所有顶级部门的列表
	 * @return
	 */
	List<Department> findTopList();

	/**
	 * 查询子部门列表
	 * @param parentId
	 * @return
	 */
	List<Department> findChildren(Long parentId);

}
