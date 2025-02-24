package com.entity;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.*;

public class DBUtil {
	
	private static SessionFactory sessionFactory;
	private static StandardServiceRegistry standardServiceRegistry;
		
	public static SessionFactory getSessionFactory() {
		
		standardServiceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		MetadataSources mds = new MetadataSources(standardServiceRegistry);
		Metadata md = mds.getMetadataBuilder().build();
		sessionFactory = md.buildSessionFactory();
		
		//sessionFactory = new MetadataSources(standardServiceRegistry).buildMetadata().buildSessionFactory();
		
		
		return sessionFactory;
	}
}
