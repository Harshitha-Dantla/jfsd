package com.klef.jfsd.Hiberante;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CRUD
{
	public static void main (String args[])
	{
		CRUD operations = new CRUD();
        operations.addfaculty();
		//operations.displayfacultybyid();
		//operations.updatefaculty();
	//operations.deletefaculty();
	}
	
	public void addfaculty()
	{
		Scanner sr = new Scanner(System.in);
		
		int id = sr.nextInt();
		sr.nextLine();
		String name = sr.nextLine();
		String gender = sr.nextLine();
		String dept = sr.nextLine();
		double salary = sr.nextDouble();
		sr.nextLine();
		String contact = sr.nextLine();
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory sf = configuration.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction t = session.beginTransaction();
		
		Faculty faculty = new Faculty();
		faculty.setId(id);
		faculty.setName(name);
		faculty.setGender(gender);
		faculty.setDepartment(dept);
		faculty.setSalary(salary);
		faculty.setContactno(contact);
		
		session.persist(faculty);
		t.commit();
		
		System.out.println("Faculty Added Successfully");
		
		session.close();
		sf.close();
		sr.close();
	}
	
	//display or find faculty based on ID Column
	public void displayfacultybyid()
	{
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory sf = configuration.buildSessionFactory();
		Session session = sf.openSession();
		
		//there is no need to create transaction object because there is no DML operation
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Faculty ID : ");
		int fid = sc.nextInt();
		
		Faculty faculty = (Faculty) session.find(Faculty.class, fid);
		
		if(faculty != null)
		{
			System.out.println(" Faculty ID : "+faculty.getId());
			System.out.println(" Faculty Name : "+faculty.getName());
			System.out.println(" Faculty Gender : "+faculty.getGender());
			System.out.println(" Faculty Department : "+faculty.getDepartment());
			System.out.println(" Faculty Salary : "+faculty.getSalary());
			System.out.println(" Faculty ID : "+faculty.getContactno());
			
		}
		else
		{
			System.out.println("Faculty ID Not found");
		}
		
		sc.close();
		session.close();
		sf.close();
		
	}
	
	public void updatefaculty()
	{

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory sf = configuration.buildSessionFactory();
		Session session = sf.openSession();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Faculty ID : ");
		int fid = sc.nextInt();
		
		Transaction t = session.beginTransaction();
		
		Faculty faculty = (Faculty) session.find(Faculty.class, fid);
		
		if(faculty != null)
		{
			System.out.println("Enter Faculty Name : ");
			String fname = sc.next();
			System.out.println("Enter Faculty salary : ");
			double fsal = sc.nextDouble();
			System.out.println("Enter Faulty ContactNo. : ");
			String contact = sc.next();
			
			faculty.setName(fname);
			faculty.setSalary(fsal);
			faculty.setContactno(contact);
			
			t.commit();
			System.out.println("Faculty Updated Succcessfully");
		}
		else
		{
			System.out.println("FAculty ID not found");
		}
		
		sc.close();
		session.close();
		sf.close();
		
	}
	
	public void deletefaculty()
	{
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory sf = configuration.buildSessionFactory();
		Session session = sf.openSession();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Faculty ID : ");
		int fid = sc.nextInt();
		
		Transaction t = session.beginTransaction();
		
		Faculty faculty = (Faculty) session.find(Faculty.class, fid);
		
		if(faculty != null)
		{
			session.remove(faculty);
			t.commit();
			System.out.println("Faculty Deleted Successfully");
		}
		else
		{
			System.out.println("FAculty ID not found");
		}
		
		sc.close();
		session.close();
		sf.close();
		
		
		
	}
}