package com.klef.jfsd.HCQL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class HCQLOperations
{
	public static void main(String args[])
	{
		HCQLOperations operations = new HCQLOperations();
		
		//operations.addStudent();
		operations.aggregatefunctions();
	}
	
	public void addStudent()
	{
		 Configuration cfg = new Configuration();
		 cfg.configure("hibernate.cfg.xml");
		 
		 SessionFactory sf = cfg.buildSessionFactory();
		 Session session = sf.openSession();
		 
		 Transaction transaction = session.beginTransaction();
		 
		 Student1 s = new Student1();
		 s.setId(101);
		 s.setName("Harshi");
		 s.setGender("FEMALE");
		 s.setDepartment("CSE");
		 s.setFee(50000);
		 s.setContactno("9898567890");
		 
	 	 session.persist(s);
	 	 transaction.commit();
	 	 System.out.println("Student Added Successfully");
	 	 
	 	 session.close();
	 	 sf.close();
	}
	
	public void aggregatefunctions() 
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();

       // CriteriaBuilder cb=session.getCriteriaBuilder();
       //CriteriaQuery<Long> cq=cb.createQuery(Long.class);
      // Root<Student1>  root=cq.from(Student1.class);
      // cq.select(cb.count(root.get("name")));
      // Long count=session.createQuery(cq).getSingleResult();
//        System.out.println("Student count="+count);
//        CriteriaBuilder cb=session.getCriteriaBuilder();
//        CriteriaQuery<Double> cq=cb.createQuery(Double.class);
//        Root<Student1>  root=cq.from(Student1.class);
//        cq.select(cb.sum(root.get("fee")));
//        Double sum=session.createQuery(cq).getSingleResult();
//        System.out.println("Student sum="+sum);
  
       CriteriaBuilder cb=session.getCriteriaBuilder();
       CriteriaQuery<Double> cq=cb.createQuery(Double.class);
       Root<Student1>  root=cq.from(Student1.class);
       cq.select(cb.max(root.get("fee")));
       Double max=session.createQuery(cq).getSingleResult();
       System.out.println("Maximum Student fee="+max);

//        CriteriaBuilder cb=session.getCriteriaBuilder();
//        CriteriaQuery<Double> cq=cb.createQuery(Double.class);
//        Root<Student1>  root=cq.from(Student1.class);
//        cq.select(cb.min(root.get("fee")));
//        Double min=session.createQuery(cq).getSingleResult();
//        System.out.println("Minimum Student fee="+min);

       // CriteriaBuilder cb=session.getCriteriaBuilder();
        //CriteriaQuery<Double> cq=cb.createQuery(Double.class);
       // Root<Student1>  root=cq.from(Student1.class);
       // cq.select(cb.avg(root.get("fee")));
       // Double avg=session.createQuery(cq).getSingleResult();
       //System.out.println("Total student average:="+avg);

//		CriteriaBuilder cb = session.getCriteriaBuilder();
//		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
//		Root<Student1> root = cq.from(Student1.class);
//		cq.select(cb.countDistinct(root.get("department")));
//		Long count = session.createQuery(cq).getSingleResult();
//		System.out.println("Faculty count:=" + count);

		session.close();
		sf.close();
	}


}