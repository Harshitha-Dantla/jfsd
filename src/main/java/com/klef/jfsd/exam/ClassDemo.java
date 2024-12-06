package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClassDemo 
{
	public static  void main(String args[])
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		 
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		 
		Transaction transaction = session.beginTransaction();
		
		Vehical v = new Vehical();
		
		v.setName("audi");
		v.setType("manual");
		v.setMaxspeed(100);
		v.setColor("black");
		
		Truck t = new Truck();
		
		t.setLoadcapacity(84728);
		t.setColor("white");
		t.setMaxspeed(95);
		t.setName("lorry");
		t.setType("long");
		
		Car c = new Car();
		
		c.setColor("red");
		c.setCtype("fiveseater");
		c.setNumberofdoors(4);
		c.setName("kia");
		c.setMaxspeed(90);
		
		session.persist(v);
		session.persist(c);
		session.persist(t);
		
		System.out.println("SUCCESS....!!!");
		
		transaction.commit();
		session.close();
		sf.close();
	}
}