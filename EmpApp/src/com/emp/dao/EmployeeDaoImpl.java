package com.emp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emp.model.Employee;
import com.emp.model.EmployeeResponse;
 
@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

	int resultsPerPage = 5;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addEmployee(Employee employee) {
		org.hibernate.classic.Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(employee);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public EmployeeResponse listEmployeess() {
		org.hibernate.classic.Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Employee");
		List<Employee> list = (List<Employee>)query.list();
		session.close();
		return  new EmployeeResponse(list, list.size());
	}
	
	public EmployeeResponse listEmployeess(int pageId) {
		Session sf = sessionFactory.openSession();
		//get entire count from db
		Query query2 = sf.createQuery("select count(*) from Employee");
		long count = (Long)query2.uniqueResult();
		
		Query query = sf.createQuery("from Employee");
		query.setMaxResults(resultsPerPage);
		int fr =(pageId-1)*resultsPerPage;
		long noOfPages = count%resultsPerPage == 0? 
				count/resultsPerPage :(count/resultsPerPage )+1;
		query.setFirstResult(fr);
		return  new EmployeeResponse((List<Employee>)query.list(), noOfPages);
	}

	public Employee getEmployee(int empid) {
		return (Employee) sessionFactory
				.openSession()
				.get(Employee.class, empid);
	}

	public void deleteEmployee(Employee employee) {
		sessionFactory.openSession()
		.createQuery("DELETE FROM Employee WHERE empid = "+employee.getEmpId())
		.executeUpdate();
	}

}
