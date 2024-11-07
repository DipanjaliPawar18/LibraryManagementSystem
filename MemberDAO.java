package com.DAOClasses;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entityClasses.Member;

public class MemberDAO {

	// Function for adding a new member
	public static void registerMember(Member member) {
		
		try {
			
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			SessionFactory sf = cfg.buildSessionFactory();
			Session session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			
			session.save(member);
			
			transaction.commit();
			session.close();
			sf.close();
		} 
		catch (Exception e) {
			e.getMessage();
		}
	}

	// Function for getting the list of the members available in library
	public static List<Member> listMembers() {
		try (Session session = new Configuration().configure().buildSessionFactory().openSession()) {
			return session.createQuery("from Member", Member.class).list();
		}
	}
}