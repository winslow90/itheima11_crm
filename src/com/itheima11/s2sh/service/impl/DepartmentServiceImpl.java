package com.itheima11.s2sh.service.impl;

import java.io.Serializable;
import java.util.List;

import com.itheima11.s2sh.dao.DepartmentDao;
import com.itheima11.s2sh.domain.Department;
import com.itheima11.s2sh.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService{
	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	public List<Department> getAllDepartment() {
		return this.departmentDao.getAllDepartment();
	}

	@Override
	public void saveDepartment(Department department) {
		// TODO Auto-generated method stub
		this.departmentDao.saveDepartment(department);
	}

	@Override
	public Department getDepartmentById(Serializable id) {
		// TODO Auto-generated method stub
		return this.departmentDao.getDepartmentById(id);
	}

	@Override
	public void updateDepartment(Department department) {
		// TODO Auto-generated method stub
		this.departmentDao.updateDepartment(department);
	}
}
