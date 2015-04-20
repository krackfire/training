/**
 * GenreDAOImpl.java
 * @author Bernard Udu <bernard_udu@gcitsolutions.com>
 * Created on Apr 20, 2015
 */
package com.gcit.training.lws.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.gcit.training.lws.daointerface.GenreDAO;
import com.gcit.training.lws.domain.Genre;

/**
 * @author bernardudu
 *
 */
public class GenreDAOImpl implements Serializable, GenreDAO {

	/* (non-Javadoc)
	 * @see com.gcit.training.lws.daointerface.GenreDAO#addGenre()
	 */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5930250701413895231L;

	private Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "root", "bernard");
		return conn;
	}
	
	
	@Override
	public void addGenre(Genre genres) throws Exception {
		Connection conn = getConnection();
		
		String inserQuery = "insert into tbl_genre (genre_name) values (?)";
		
		PreparedStatement pstmt = conn.prepareStatement(inserQuery);
		pstmt.setString(1, genres.getName());
		pstmt.executeUpdate();
	}

	/* (non-Javadoc)
	 * @see com.gcit.training.lws.daointerface.GenreDAO#updateGenre()
	 */
	@Override
	public void updateGenre(Genre genres) throws Exception {
		Connection conn = getConnection();
		
		String updateQuery  = "update tbl_genre set genre_name = ? where genre_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(updateQuery);
		
		pstmt.setInt(2, genres.getGenreId());
		pstmt.setString(1, genres.getName());
		pstmt.executeUpdate();				
	}

	/* (non-Javadoc)
	 * @see com.gcit.training.lws.daointerface.GenreDAO#remeoveGenre()
	 */
	@Override
	public void remeoveGenre(Genre genres) throws Exception {
		Connection conn = getConnection();
		
		String deleteQuery = "delete from tbl_genre where genre_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(deleteQuery);
		pstmt.setInt(1, genres.getGenreId());
		pstmt.executeUpdate();
		
	}	
}
