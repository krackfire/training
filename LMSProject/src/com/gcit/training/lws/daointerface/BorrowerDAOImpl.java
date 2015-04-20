/**
 * BorrowerDAOImpl.java
 * @author Bernard Udu <bernard_udu@gcitsolutions.com>
 * Created on Apr 20, 2015
 */
package com.gcit.training.lws.daointerface;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.gcit.training.lws.domain.Borrower;

/**
 * @author bernardudu
 *
 */
public class BorrowerDAOImpl implements Serializable, BorrowerDAO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4963501408066191989L;
	
	private Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "root", "bernard");
		return conn;
	}
	

	/* (non-Javadoc)
	 * @see com.gcit.training.lws.daointerface.BorrowerDAO#addBorrower(com.gcit.training.lws.domain.Borrower)
	 */
	@Override
	public void addBorrower(Borrower borrower) throws Exception {
		Connection conn = getConnection();
		
		String insertQuery = "insert into tbl_borrower (name, address, phone) values (?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(insertQuery);
		
		pstmt.setString(1, borrower.getBorrowerName());
		pstmt.setString(2, borrower.getBorrowerAddress());
		pstmt.setString(3, borrower.getBorrowerPhone());
		
		pstmt.executeUpdate();
		
	}

	/* (non-Javadoc)
	 * @see com.gcit.training.lws.daointerface.BorrowerDAO#updateBorrower(com.gcit.training.lws.domain.Borrower)
	 */
	@Override
	public void updateBorrower(Borrower borrower) throws Exception {
		Connection conn = getConnection();
		
		String updateQuery = "update tbl_borrower set cardNo = ? where name = ? and address = ?";
		PreparedStatement pstmt = conn.prepareStatement(updateQuery);
		pstmt.setInt(1, borrower.getCardNo());
		pstmt.setString(2, borrower.getBorrowerName());
		pstmt.setString(3, borrower.getBorrowerAddress());

		pstmt.executeUpdate();
		
	}

	/* (non-Javadoc)
	 * @see com.gcit.training.lws.daointerface.BorrowerDAO#removeBorrower(com.gcit.training.lws.domain.Borrower)
	 */
	@Override
	public void removeBorrower(Borrower borrower) throws Exception {
		Connection conn = getConnection();
		
		String deleteQuery = "delete from tbl_borrower where cardNo = ?";
		PreparedStatement pstmt = conn.prepareStatement(deleteQuery);
		
		pstmt.setInt(1, borrower.getCardNo());
		pstmt.executeUpdate();
				
		
	}

}
