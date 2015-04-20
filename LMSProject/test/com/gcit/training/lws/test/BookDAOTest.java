/**
 * BookDAOTest.java
 * @author Bernard Udu <bernard_udu@gcitsolutions.com>
 * Created on Apr 18, 2015
 */
package com.gcit.training.lws.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.gcit.training.lws.dao.BookDAOImpl;
import com.gcit.training.lws.domain.Book;

/**
 * @author bernardudu
 *
 */
public class BookDAOTest {

	/**
	 * Test method for {@link com.gcit.training.lws.dao.BookDAOImpl#getAllBooks()}.
	 */
	@Test
	public void testGetAllBooks() {
		Book b = new Book();
		List<Book> books = new ArrayList<Book>();
		
		b.setBookId(b.getBookId());
		b.setTitle(b.getTitle());
		books.add(b);
		
		Iterator<Book> it = books.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		try {
			new BookDAOImpl().getAllBooks();
		} catch (SQLException e) {
			fail(e.getMessage());
		}
		
	}

	/**
	 * Test method for {@link com.gcit.training.lws.dao.BookDAOImpl#addBook(com.gcit.training.lws.domain.Book)}.
	 */
	@Test
	public void testAddBook() {
		Book book = new Book();
		book.setTitle("Romanian beginnings");
		book.setPubId(11);
		try {
			new BookDAOImpl().addBook(book);
		} catch(Exception e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.gcit.training.lws.dao.BookDAOImpl#updateBook(com.gcit.training.lws.domain.Book)}.
	 */
	@Test
	public void testUpdateBook() {
		
		Book b = new Book();
		
		b.setBookId(25);
		b.setTitle("The Rise and Fall of Wall Street");
		b.setPubId(4);
		try {
			new BookDAOImpl().updateBook(b);
		} catch (SQLException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.gcit.training.lws.dao.BookDAOImpl#deleteBook(com.gcit.training.lws.domain.Book)}.
	 */
	@Test
	public void testDeleteBook() {
		
		Book b = new Book();
		
		b.setBookId(34);
		try {
			new BookDAOImpl().deleteBook(b);
		} catch (SQLException e) {
			fail(e.getMessage());
		}
	}

}
