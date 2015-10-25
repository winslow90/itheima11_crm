package com.itheima11.s2sh.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.BeanUtils;

import com.itheima11.s2sh.domain.Department;
import com.itheima11.s2sh.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{
	
	/**
	 * 1、获取页面表单中的数据
	 * 2、回显
	 */
	private Department model = new Department();
	
	@Override
	public Department getModel() {
		// TODO Auto-generated method stub
		return this.model;
	}
	
	private DepartmentService departmentService;
	private String name;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	public String showDepartments(){
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		/**
		 * 把一个对象放入到map
		 */
		List<Department> departments = this.departmentService.getAllDepartment();
		ActionContext.getContext().put("departments", departments);
		//<s:iterator value="#request.departments">
		//ServletActionContext.getRequest().setAttribute("departments", departments);
		
		
		/**
		 * 对象栈的操作
		 */
		//1把一个对象放入到栈顶
		//<s:iterator>   value不写，默认迭代栈顶的元素
//		ActionContext.getContext().getValueStack().push(departments);
//		ActionContext.getContext().getValueStack().getRoot().add(0, departments);
		
		//获取栈顶的元素
//		ActionContext.getContext().getValueStack().peek();
//		ActionContext.getContext().getValueStack().getRoot().get(0);
		
		//弹栈
		//ActionContext.getContext().getValueStack().pop();
		
		//改变对象栈中的某一个元素的值
		ActionContext.getContext().getValueStack().setValue("name", "asfda");
		ActionContext.getContext().put("bbb", "bbb");
		
		String name = ActionContext.getContext().getValueStack().findValue("name").toString();
		String bbb = ActionContext.getContext().getValueStack().findValue("bbb").toString();
		System.out.println(name);
		System.out.println(bbb);
		return "listAction";
	}
	
	public String map(){
		Map<String, Department> map = new HashMap<String, Department>();
		Department department = new Department();
		department.setName("开发部");
		department.setDescription("程序员比较多");
		map.put("d1", department);
		ActionContext.getContext().put("map", map);
		return "listAction";
	}
	
	public String listMap(){
		List<Map<String, Department>> list = new ArrayList<Map<String,Department>>();
		
		Map<String, Department> map = new HashMap<String, Department>();
		Department department = new Department();
		department.setName("开发部");
		department.setDescription("程序员比较多");
		map.put("d1", department);
		
		list.add(map);
		
		ActionContext.getContext().put("list", list);
		
		return "listAction";
	}
	
	public String mapList(){
		Map<String, List<Department>> map = new HashMap<String, List<Department>>();
		
		List<Department> departments = new ArrayList<Department>();
		Department department = new Department();
		department.setName("开发部");
		department.setDescription("程序员比较多");
		departments.add(department);
		
		map.put("l1", departments);
		
		ActionContext.getContext().put("map", map);
		return "listAction";
	}
	
	public String listMapList(){
		List<Map<String, List<Department>>> list = new ArrayList<Map<String,List<Department>>>();
		
		Map<String, List<Department>> map = new HashMap<String, List<Department>>();
		
		List<Department> departments = new ArrayList<Department>();
		Department department = new Department();
		department.setName("开发部");
		department.setDescription("程序员比较多");
		departments.add(department);
		
		map.put("l1", departments);
		
		list.add(map);
		
		ActionContext.getContext().put("listMapList", list);
		
		return "listAction";
	}
	
	public String addUI(){
		return "addUI";
	}
	
	public String add(){
		Department department = new Department();
		BeanUtils.copyProperties(this.model, department);
		this.departmentService.saveDepartment(department);
		return "chainAction";
	}
	
	public String updateUI(){
		Department department = this.departmentService.getDepartmentById(this.getModel().getDid());
		ActionContext.getContext().getValueStack().push(department);
		ServletActionContext.getRequest().setAttribute("department", department);
		//ActionContext.getContext().put("department", department);
		return "updateUI";
	}
	
	public String update(){
		//根据did查找department
		Department department = this.departmentService.getDepartmentById(this.getModel().getDid());
		//把页面上最新的数据赋值到department对象中
		BeanUtils.copyProperties(this.getModel(), department);
		this.departmentService.updateDepartment(department);
		return "chainAction";
	}
}
