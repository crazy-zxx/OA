package com.oa.service.impl;

import java.util.List;

import com.oa.base.BaseDaoImpl;
import com.oa.entity.Department;
import com.oa.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("unchecked")
public class DepartmentServiceImpl extends BaseDaoImpl<Department> implements DepartmentService {

	public List<Department> findTopList() {
		return getSession().createQuery(//
				"FROM Department d WHERE d.parent IS NULL")//
				.list();
	}

	public List<Department> findChildren(Long parentId) {
		return getSession().createQuery(//
				"FROM Department d WHERE d.parent.id=?")//
				.setParameter(0, parentId)//
				.list();
	}

}
