package model;

import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeeCRUD {

	private EntityManagerFactory entityManagerFactory;

	EmployeeCRUD() {
		entityManagerFactory = Persistence.createEntityManagerFactory("FirstJPA");
	}

	public void createEmployee(Employee employee) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public void readEmployee(BigDecimal id){
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Employee employee = entityManager.find(Employee.class, id);
		System.out.println("Found employee:\n");
		System.out.println(employee.toString());
		entityManager.close(); 
	}
	
	public void updateSalary(BigDecimal id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Employee employee = entityManager.find(Employee.class, id);
		employee.setSalary(employee.getSalary().multiply(new BigDecimal(110)).divide(new BigDecimal(100)));
		entityManager.getTransaction().begin();
		entityManager.merge(employee);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public void deleteEmployee(BigDecimal id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Employee employee = entityManager.find(Employee.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(employee);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Override
	public void finalize() {
		entityManagerFactory.close();
	}
}
