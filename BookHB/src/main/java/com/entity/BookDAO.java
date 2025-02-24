package com.entity;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class BookDAO {
	
	Transaction tr = null;
	
	public void addBook(Book b) {
		try(Session session = DBUtil.getSessionFactory().openSession()) {
			tr = session.beginTransaction();
					
			session.persist(b);
			
			tr.commit();
		}
	}
	
	public List<Book> retrieveBook() {
		try(Session session = DBUtil.getSessionFactory().openSession()) {
			tr = session.beginTransaction();
					
			Query<Book> qry = session.createQuery("from Book", Book.class);

			return qry.getResultList();
		}
		
	}
	
	public List<Book> retrieveBook(String name) {
		try(Session session = DBUtil.getSessionFactory().openSession()) {
			tr = session.beginTransaction();
			
			String hql = "from Book where bname = :name";
			Query<Book> qry = session.createQuery(hql, Book.class);
			qry.setParameter("name", name);

			return qry.getResultList();
		}
		
	}
	
	public void updateBook(Book b) {
        try(Session session = DBUtil.getSessionFactory().openSession()) {
            tr = session.beginTransaction();

            Book book = session.get(Book.class, b.getBid());
            
            if (book != null) {
            	book.setBname(b.getBname());
            	book.setPublisher_name(b.getPublisher_name());
            	book.setPublished_date(b.getPublished_date());
            	book.setAuthor(b.getAuthor());
            	book.setPrice(b.getPrice());
            	book.setEdition(b.getEdition());
                session.merge(book);
                System.out.println("\nBook updated successfully");
            } else {
            	System.out.println("\nBook is not available");
            }
            
            tr.commit();
        }
    }
	
	public void deleteBook(int id) {
        try(Session session = DBUtil.getSessionFactory().openSession()) {
            tr = session.beginTransaction();

            Book book = session.get(Book.class, id);
            
            if (book != null) {
                session.remove(book);
            }
            
            tr.commit();
        }
    }

}
