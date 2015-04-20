/**
 * LibraryBranchDAOImpl.java
 * @author Bernard Udu <bernard_udu@gcitsolutions.com>
 * Created on Apr 20, 2015
 */
package com.gcit.training.lws.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.gcit.training.lws.daointerface.LibraryBranchDAO;
import com.gcit.training.lws.domain.LibraryBranch;

/**
 * @author bernardudu
 *
 */
public class LibraryBranchDAOImpl implements Serializable, LibraryBranchDAO{

	/**
	 * 
	 */
	private static final long serialVersionUID = -34199580981541256L;
	
	private Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "bernard");
		return conn;
	}
	

	/* (non-Javadoc)
	 * @see com.gcit.training.lws.daointerface.LibraryBranchDAO#addBranch(com.gcit.training.lws.domain.LibraryBranch)
	 */
	@Override
	public void addBranch(LibraryBranch libBranch) throws Exception {
		Connection conn = getConnection();
		String insertQuery = "insert into tbl_library_branch (branchName, branchAddress) values (?,?)";
		
		PreparedStatement pstmt = conn.prepareStatement(insertQuery);
		pstmt.setString(1, libBranch.getBranchName());
		pstmt.setString(2, libBranch.getBranchAddress());
		
		pstmt.executeUpdate();
		
	}

	/* (non-Javadoc)
	 * @see com.gcit.training.lws.daointerface.LibraryBranchDAO#updateBranch(com.gcit.training.lws.domain.LibraryBranch)
	 */
	@Override
	public void updateBranch(LibraryBranch libBranch) throws Exception {
		Connection conn = getConnection();
		
		String updateQuery = "update tbl_library_branch set branchName = ? where branchId =?";
		PreparedStatement pstmt = conn.prepareStatement(updateQuery);
		pstmt.setString(1, libBranch.getBranchName());
		pstmt.setInt(2, libBranch.getBranchId());
		
		pstmt.executeUpdate();
		
	}

	/* (non-Javadoc)
	 * @see com.gcit.training.lws.daointerface.LibraryBranchDAO#removeBranch(com.gcit.training.lws.domain.LibraryBranch)
	 */
	@Override
	public void removeBranch(LibraryBranch libBranch) throws Exception {
		Connection conn = getConnection();
		
		String deleteQuery = "delete from tbl_library_branch where branchId =?";
		PreparedStatement pstmt = conn.prepareStatement(deleteQuery);
		pstmt.setInt(1, libBranch.getBranchId());
		pstmt.executeUpdate();
		
	}

}
