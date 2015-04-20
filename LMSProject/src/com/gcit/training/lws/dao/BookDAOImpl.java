/**
 * BookDAO.java
 * @author Bernard Udu <bernard_udu@gcitsolutions.com>
 * Created on Apr 18, 2015
 */
package com.gcit.training.lws.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.training.lws.domain.Book;

/**
 * @author bernardudu
 *
 */
public class BookDAOImpl implements Serializable, com.gcit.training.lws.daointerface.BookDAO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6719507660324203801L;

	private Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "root", "bernard");
		return conn;
	}
	
	/* (non-Javadoc)
	 * @see com.gcit.training.lws.daointerface.BookDAO#getAllBooks()
	 */
	@Override
	public List<Book> getAllBooks() throws SQLException {
		Connection conn = getConnection();
		
		String allBooks = "select * from tbl_book";
		PreparedStatement pstmt = conn.prepareStatement(allBooks);
		ResultSet resultset = pstmt.executeQuery();
		
		List<Book> books = new ArrayList<Book>();
		while(resultset.next()) {
			Book b = new Book();
			b.setBookId(resultset.getInt("bookId"));
			b.setTitle(resultset.getString("title"));
			books.add(b);
		}
		return books;
	}

	/* (non-Javadoc)
	 * @see com.gcit.training.lws.daointerface.BookDAO#getBook(int)
	 */
	@Override
	public void addBook(Book book) throws SQLException {
		Connection conn = getConnection();

		String insertBook = "insert into tbl_book (title, pubId) values (?, ?)";
		PreparedStatement bookPstmt = conn.prepareStatement(insertBook);		
		bookPstmt.setString(1, book.getTitle());
		bookPstmt.setInt(2, book.getPubId());
		bookPstmt.executeUpdate();
		
	}

	/* (non-Javadoc)
	 * @see com.gcit.training.lws.daointerface.BookDAO#updateBook(com.gcit.training.lws.domain.Book)
	 */
	@Override
	public void updateBook(Book book) throws SQLException {
		Connection conn = getConnection();
		
		String updateQuery = "update tbl_book set title = ? where bookId = ? and pubId = ?";
		PreparedStatement pstmt = conn.prepareStatement(updateQuery);
		pstmt.setString(1, book.getTitle());
		pstmt.setInt(2, book.getBookId());
		pstmt.setInt(3, book.getPubId());
		pstmt.executeUpdate();
		
	}

	/* (non-Javadoc)
	 * @see com.gcit.training.lws.daointerface.BookDAO#deleteBook(com.gcit.training.lws.domain.Book)
	 */
	@Override
	public void deleteBook(Book book) throws SQLException {
		Connection conn = getConnection();
		
		String deleteQuery = "delete from tbl_book where bookId = ?";
		
		PreparedStatement psmt = conn.prepareStatement(deleteQuery);
		psmt.setInt(1, book.getBookId());
		psmt.executeUpdate();
		
	}
	

}
