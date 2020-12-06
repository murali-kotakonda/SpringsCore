package com.myapp.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myapp.dto.Employee;
import com.myapp.dto.EmployeeListResponse;

@Repository("empDao")
public class EmployeeDao {

	static int resultsPerPage;
	static Properties props;
	
	static {
		String resourceName = "config.properties"; // could also be a constant
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		 props = new Properties();
		try(InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
		    props.load(resourceStream);
		} catch (IOException e) {
			
		}
		resultsPerPage =Integer.parseInt((String)props.get("pageSize"));
	}
	@Autowired
	private SessionFactory sessionFactory;

	public void saveEmployee(final Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		session.save(employee);// 1 row in emp table and 2 rows in address table
		transaction.commit();
		session.close();
	}
	
	public void updateEmployee(final Employee newEmpDetails) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		
		//get current data
		Employee empFromDB = getEmpById(newEmpDetails.getId());
		
		//update with new data
		copyEmp(newEmpDetails, empFromDB);
		
		session.merge(empFromDB);
		transaction.commit();
		session.close();
	}

	private void copyEmp(Employee source, Employee target) {
		if (StringUtils.isNotEmpty(source.getName())) {
			target.setName(source.getName());
		}
		if (StringUtils.isNotEmpty(source.getlName())) {
			target.setlName(source.getlName());
		}
		if (StringUtils.isNotEmpty(source.getEmail())) {
			target.setEmail(source.getEmail());
		}
		target.setAge(source.getAge());
		target.setSalary(source.getSalary());
	}

	public boolean deleteEmployee(final Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		session.delete(employee);
		transaction.commit();
		session.close();
		return true;
	}
	
	public List<Employee> getAllEmployees() {
		Session session = sessionFactory.openSession();
		Criteria c = session.createCriteria(Employee.class);
		List<Employee> list = (List<Employee>)c.list();
		session.close();
		return list;
	}
	
	public Employee getEmpById(int id) {
		Session session = sessionFactory.openSession();
		Query q = session
				.createQuery("from Employee e where id=:id");
		q.setParameter("id", id);
		Employee validEmp = (Employee) q.uniqueResult();
		session.close();
		return validEmp;
	} 
	
	public Employee getValidEmpByAuth(Employee employee) {
		Session session = sessionFactory.openSession();
		Query q = session
				.createQuery("from Employee e where e.loginName=:eName and e.password=:ePass");
		q.setParameter("eName", employee.getLoginName());
		q.setParameter("ePass", employee.getPassword());
		Employee validEmp = (Employee) q.uniqueResult();
		session.close();
		return validEmp;
	}
	
	public Employee searchByName(String name) {
		Session session = sessionFactory.openSession();
		Query q = session
				.createQuery("from Employee e where loginName=:name");
		q.setParameter("name", name);
		Employee validEmp = (Employee) q.uniqueResult();
		session.close();
		return validEmp;
	}
	
	public boolean isEmployeeExists(String str) {
		Session session = sessionFactory.openSession();
		Query q = session
				.createQuery("select count(*) from Employee  where loginname=:inputName");
		q.setParameter("inputName", str);
		long count = (Long) q.uniqueResult();
		session.close();
		return count >=1 ? true : false;
	}
	
	/**
	Where should we specify the page file?
	-> in configuration file like .properties
	
	
	1.Provide a config.properties
	
	config.properties
	-------------------------------
	pageSize=5
	
	EmployeeDao has to read the propeties file and fetch the value for  "pageSize"

	 */
	public EmployeeListResponse listEmployeess(int pageId) {
		Session sf = sessionFactory.openSession();
		Query query2 = sf.createQuery("select count(*) from Employee");
		long count = (Long)query2.uniqueResult();
		
		Query query = sf.createQuery("from Employee");
		query.setMaxResults(resultsPerPage);
		int fr =(pageId-1)*resultsPerPage;
		long noOfPages = count%resultsPerPage == 0? count/resultsPerPage :(count/resultsPerPage )+1;
		query.setFirstResult(fr);
		List<Employee> list =(List<Employee>)  query.list();
		sf.close();
		
		return  new EmployeeListResponse(list, noOfPages);
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}