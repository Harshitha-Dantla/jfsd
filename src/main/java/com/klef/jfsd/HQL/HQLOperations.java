package com.klef.jfsd.HQL;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;

public class HQLOperations
{
	public static void main(String args[])
	{
		HQLOperations operations = new HQLOperations();

		//operations.addStudent();
		// operations.displayallstucompleteobject();
		 //operations.displayallstupartialobject();
		// operations.aggregatefunctions();
		 //operations.updatepositionalparams();
		 //operations.updatenamedparams();
		// operations.deletepositionalparams();
		// operations.deletenamedparams();
		//operations.hqldemo();
		//operations.pagination();
	}

	public void addStudent()
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();

		Transaction transaction = session.beginTransaction();

		Student stu = new Student();
		stu.setName("Harshi");
		stu.setDepartment("ECE");
		stu.setFee(100000);

		session.persist(stu);
		transaction.commit();
		System.out.println("Student Added Successfully");

		session.close();
		sf.close();
	}

	public void displayallstucompleteobject()
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();

		String hql = "from Student";
		Query<Student> qry = session.createQuery(hql, Student.class);
		List<Student> stu = qry.getResultList();

		System.out.println("Total Students=" + stu.size());

		for (Student s : stu)
		{
			System.out.println("ID:" + s.getId());
			System.out.println("Name:" + s.getName());
			System.out.println("Designation:" + s.getDepartment());
			System.out.println("Salary:" + s.getFee());
		}
		session.close();
		sf.close();
	}

	public void displayallstupartialobject() 
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();

		String hql = "select s.id,s.name,s.fee from Student s";

		Query<Object[]> qry = session.createQuery(hql, Object[].class);
		List<Object[]> stu = qry.getResultList();

		System.out.println("Total Employees=" + stu.size());

		for (Object[] obj : stu) 
		{
			System.out.println("ID:" + obj[0]);
			System.out.println("Name:" + obj[1]);
			System.out.println("Fee:" + obj[2]);
		}
		session.close();
		sf.close();
	}

	public void aggregatefunctions() 
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();

		String hql1 = "select count(*) from Student";
		Query<Long> qry1 = session.createQuery(hql1, Long.class);
		long count = qry1.getSingleResult();
		System.out.println("Total Students=" + count);

		String hql2 = "select sum(fee) from Student";
		Query<Double> qry2 = session.createQuery(hql2, Double.class);
		double totalfee = qry2.getSingleResult();
		System.out.println("Total Fee=" + totalfee);

		session.close();
		sf.close();
	}

	public void updatepositionalparams() 
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();

		Transaction transaction = session.beginTransaction();

		String hql = "update Student set name=?1,fee=?2 where id=?3 ";

		MutationQuery qry = session.createMutationQuery(hql);
		qry.setParameter(1, "Sohi");
		qry.setParameter(2, 600000);
		qry.setParameter(3, 1);

		int n = qry.executeUpdate();

		if (n > 0)
		{
			System.out.println("Student Updated Successfully");
		}
		else 
		{
			System.out.println("Student ID Not Found");
		}
		transaction.commit();

		session.close();
		sf.close();
	}

	public void updatenamedparams()
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();

		Transaction transaction = session.beginTransaction();

		String hql = "update Student set name=:v1,fee=:v2 where id=:v3 ";

		MutationQuery qry = session.createMutationQuery(hql);
		qry.setParameter("v1", "Sohith");
		qry.setParameter("v2", 150000);
		qry.setParameter("v3", 1);

		int n = qry.executeUpdate();

		if (n > 0) 
		{
			System.out.println("Student Updated Successfully");
		} 
		else 
		{
			System.out.println("Student ID Not Found");
		}
		transaction.commit();

		session.close();
		sf.close();
	}

	public void deletepositionalparams() 
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();

		Transaction transaction = session.beginTransaction();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student ID:");
		int sid = sc.nextInt();

		String hql = "delete from Student where id=?1";

		MutationQuery qry = session.createMutationQuery(hql);
		qry.setParameter(1, sid);

		int n = qry.executeUpdate();

		if (n > 0) 
		{
			System.out.println("Student Deleted Successfully");
		} 
		else 
		{
			System.out.println("Student ID Not Found");
		}
		transaction.commit();

		session.close();
		sf.close();
	}

	public void deletenamedparams()
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();

		Transaction transaction = session.beginTransaction();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student ID:");
		int sid = sc.nextInt();

		String hql = "delete from Student where id=:v";

		MutationQuery qry = session.createMutationQuery(hql);
		qry.setParameter("v", sid);

		int n = qry.executeUpdate();

		if (n > 0) 
		{
			System.out.println("Student Deleted Successfully");
		} 
		else 
		{
			System.out.println("Student ID Not Found");
		}
		transaction.commit();

		session.close();
		sf.close();
	}

	public void hqldemo() 
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();

		String hql = "from Student where department=?1 and fee>=?2";

		Query<Student> qry = session.createQuery(hql, Student.class);

		qry.setParameter(1, "CSE");
		qry.setParameter(2, 10000);

		List<Student> stu = qry.getResultList();

		System.out.println("Total Students=" + stu.size());

		for (Student s : stu) 
		{
			System.out.println("ID:" + s.getId());
			System.out.println("Name:" + s.getName());
			System.out.println("Department:" + s.getDepartment());
			System.out.println("Fee:" + s.getFee());
		}
		session.close();
		sf.close();
	}

	public void pagination() 
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();

		String hql = "from Student";
		Query<Student> qry = session.createQuery(hql, Student.class);

		qry.setFirstResult(1);
		qry.setMaxResults(5);

		List<Student> stu = qry.getResultList();

		System.out.println("Total Students=" + stu.size());

		for (Student s : stu)
		{
			System.out.println("ID:" + s.getId());
			System.out.println("Name:" + s.getName());
			System.out.println("Designation:" + s.getDepartment());
			System.out.println("Salary:" + s.getFee());
		}
		session.close();
		sf.close();
	}

}