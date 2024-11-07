package com.DAOClasses;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entityClasses.Book;

public class BookDAO {

	// Function for adding a new book
	public static void addBook(Book book) {
		try {
			
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			SessionFactory sf = cfg.buildSessionFactory();
			Session session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			
			session.save(book);
			
			transaction.commit();
			session.close();
			sf.close();
			
		} 
		catch (Exception e) {
			e.getMessage();
		}
	}

	// Function for getting the list of the books available in library
	public static List<Book> listBooks() {
		try (Session session = new Configuration().configure().buildSessionFactory().openSession()){
			return session.createQuery("from Book", Book.class).list();
		} 
	}
}