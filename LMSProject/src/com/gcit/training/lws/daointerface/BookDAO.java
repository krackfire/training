/**
 * BookDAO.java
 * @author Bernard Udu <bernard_udu@gcitsolutions.com>
 * Created on Apr 18, 2015
 */
package com.gcit.training.lws.daointerface;

import java.sql.SQLException;
import java.util.List;

import com.gcit.training.lws.domain.Book;

/**
 * @author bernardudu
 *
 */
public interface BookDAO {
	public List<Book> getAllBooks() throws SQLException;
	public void addBook(Book book) throws SQLException;
	public void updateBook(Book book) throws SQLException;
	public void deleteBook(Book book) throws SQLException;
}
