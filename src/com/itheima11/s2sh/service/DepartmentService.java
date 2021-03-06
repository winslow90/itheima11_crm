package com.itheima11.s2sh.service;

import java.io.Serializable;
import java.util.List;

import com.itheima11.s2sh.domain.Department;

public interface DepartmentService {
	public List<Department> getAllDepartment();
	public void saveDepartment(Department department);
	public Department getDepartmentById(Serializable id);
	public void updateDepartment(Department department);
}
