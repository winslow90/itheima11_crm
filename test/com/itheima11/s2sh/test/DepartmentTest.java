package com.itheima11.s2sh.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima11.s2sh.dao.DepartmentDao;
import com.itheima11.s2sh.domain.Department;
import com.itheima11.s2sh.service.DepartmentService;

public class DepartmentTest extends SpringUtils{
	@Test
	public void testSaveDepartment(){
		DepartmentService departmentService = (DepartmentService)context.getBean("departmentService");
		departmentService.getAllDepartment();
	}
	
	@Test
	public void testDepartmentAction(){
		context.getBean("departmentAction");
	}
	
	
	/**
	 * different object with the same identitifer
	 * 两个持久化对象的标示符都一样，在hibernate内部不允许这种情况出现
	 */
	@Test
	public void testHibernate(){
		SessionFactory sessionFactory = (SessionFactory)context.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Department department = (Department)session.get(Department.class, 1L);
		department.setDescription("asfd");
		
		Department department2 = new Department();
		department2.setDid(1L);
		
		session.update(department2);
		transaction.commit();
		session.close();
	}
	
	/**
	 * dao层的代码
	 * 	Department department = this.hibernateTemplate.load(Department.class, id);//session关闭了
		department.getName();   //报错了，因为没有session
		return department;
	 */
	@Test
	public void testSession_Close(){
		DepartmentDao departmentDao = (DepartmentDao)context.getBean("departmentDao");
		departmentDao.getDepartmentById(1L);
	}
	
	/**
	 * 因为在service层的方法中有事务，所以在service层的方法内部，session没有关闭
	 */
	@Test
	public void testSession_Close_2(){
		DepartmentService departmentService = (DepartmentService)context.getBean("departmentService");
		departmentService.getDepartmentById(1L);
	}
	
	/**
	 * Department department = departmentService.getDepartmentById(1L);
	 * 当上面的代码调用完毕以后,事务环境已经没有了，所以session关闭了
	 */
	@Test
	public void testSession_Close_3(){
		DepartmentService departmentService = (DepartmentService)context.getBean("departmentService");
		Department department = departmentService.getDepartmentById(1L);//session关闭了
		department.getName();//no session的异常
	}
}
