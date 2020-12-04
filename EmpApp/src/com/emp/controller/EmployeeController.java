package com.emp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.emp.bean.EmployeeBean;
import com.emp.model.Employee;
import com.emp.model.EmployeeResponse;
import com.emp.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addEmployee() {
		EmployeeBean employeeBean = new EmployeeBean();
		return new ModelAndView("addEmployee","command",employeeBean);
	}

	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public ModelAndView saveEmployee(
			@ModelAttribute("command") EmployeeBean employeeBean,
			BindingResult result) {
		if(employeeBean.getAge()<18){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("msg", "age should be > 18.");
			map.put("command", employeeBean);
			return new ModelAndView("addEmployee",map);
		}
		employeeService.addEmployee(prepareModel(employeeBean));
		return new ModelAndView("readDetails", "myData", "employee created");
	}
	
	@RequestMapping(value = "/allEmployees", method = RequestMethod.GET)
	public ModelAndView listEmployeesWithoutPagination() {
		EmployeeResponse listEmployeess = employeeService.listEmployeess();

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employees",prepareListofBean(listEmployeess.getEmps()));
		model.put("count", listEmployeess.getCount());
		
		return new ModelAndView("employeesList", model);
	}

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public ModelAndView listEmployees(
			@RequestParam(value = "pageId", required = false, defaultValue = "1") Integer pageId) {
		Map<String, Object> model = new HashMap<String, Object>();
		pageId = pageId == null ? 0 : pageId;
		EmployeeResponse listEmployeess = employeeService.listEmployeess(pageId);
		model.put("employees",
				prepareListofBean(listEmployeess.getEmps()));
		model.put("count", listEmployeess.getCount());
		return new ModelAndView("employeesList", model);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView editEmployee(
			@ModelAttribute("command") EmployeeBean employeeBean,
			BindingResult result) {
		employeeService.deleteEmployee(prepareModel(employeeBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employee", null);
		EmployeeResponse listEmployeess = employeeService.listEmployeess(1);
		model.put("employees",
				prepareListofBean(listEmployeess.getEmps()));
		model.put("count", listEmployeess.getCount());
		return new ModelAndView("addEmployee", model);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(
			@ModelAttribute("command") EmployeeBean employeeBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employee", prepareEmployeeBean(employeeService
				.getEmployee(employeeBean.getId())));
		EmployeeResponse listEmployeess = employeeService.listEmployeess(1);
		model.put("employees",
				prepareListofBean(listEmployeess.getEmps()));
		model.put("count", listEmployeess.getCount());
		return new ModelAndView("addEmployee", model);
	}

	private Employee prepareModel(EmployeeBean employeeBean) {
		Employee employee = new Employee();
		employee.setEmpAddress(employeeBean.getAddress());
		employee.setEmpAge(employeeBean.getAge());
		employee.setEmpName(employeeBean.getName());
		employee.setSalary(employeeBean.getSalary());
		employee.setEmpId(employeeBean.getId());
		employeeBean.setId(null);
		return employee;
	}

	private List<EmployeeBean> prepareListofBean(List<Employee> employees) {
		List<EmployeeBean> beans = null;
		if (employees != null && !employees.isEmpty()) {
			beans = new ArrayList<EmployeeBean>();
			EmployeeBean bean = null;
			for (Employee employee : employees) {
				bean = new EmployeeBean();
				bean.setName(employee.getEmpName());
				bean.setId(employee.getEmpId());
				bean.setAddress(employee.getEmpAddress());
				bean.setSalary(employee.getSalary());
				bean.setAge(employee.getEmpAge());
				beans.add(bean);
			}
		}
		return beans;
	}

	private EmployeeBean prepareEmployeeBean(Employee employee) {
		EmployeeBean bean = new EmployeeBean();
		bean.setAddress(employee.getEmpAddress());
		bean.setAge(employee.getEmpAge());
		bean.setName(employee.getEmpName());
		bean.setSalary(employee.getSalary());
		bean.setId(employee.getEmpId());
		return bean;
	}
}
