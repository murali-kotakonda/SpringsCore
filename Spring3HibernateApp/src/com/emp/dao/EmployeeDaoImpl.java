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

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addEmployee(Employee employee) {
		org.hibernate.classic.Session session = 
				sessionFactory.openSession();
		session.getTransaction().begin();;
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
		return  new EmployeeResponse(list, 1);
	}
	
	
	
	int resultsPerPage = 5;
	@SuppressWarnings("unchecked")
	public EmployeeResponse listEmployeess(int pageId) {
		Session sf = sessionFactory.getCurrentSession();
		//get entire count from db
		long count = (Long)sf.createQuery("select count(*) from Employee").uniqueResult();
		Query query = sf.createQuery("from Employee");
		//query.setMaxResults(resultsPerPage);
		
		
		int fr =(pageId-1)*resultsPerPage;
		long noOfPages = count%resultsPerPage == 0? 
				count/resultsPerPage :(count/resultsPerPage )+1;
		
		//query.setFirstResult(fr);
		return  new EmployeeResponse((List<Employee>)query.list(), noOfPages);
	//	return (List<Employee>) sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
	}

	public Employee getEmployee(int empid) {
		return (Employee) sessionFactory.getCurrentSession().get(Employee.class, empid);
	}

	public void deleteEmployee(Employee employee) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Employee WHERE empid = "+employee.getEmpId()).executeUpdate();
	}

}
