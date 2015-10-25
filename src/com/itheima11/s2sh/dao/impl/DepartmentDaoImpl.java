package com.itheima11.s2sh.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.itheima11.s2sh.dao.DepartmentDao;
import com.itheima11.s2sh.domain.Department;

public class DepartmentDaoImpl implements DepartmentDao{
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public List<Department> getAllDepartment() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from Department");
	}

	@Override
	public void saveDepartment(Department department) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.save(department);
	}
	
	/**
	 * Serializable能接受基本类型的包装类和String
	 */
	@Override
	public Department getDepartmentById(Serializable id) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.load(Department.class, id);
	}

	@Override
	public void updateDepartment(Department department) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.update(department);
	}
}
