/**
 * PublisherDAOImpl.java
 * @author Bernard Udu <bernard_udu@gcitsolutions.com>
 * Created on Apr 19, 2015
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

import com.gcit.training.lws.daointerface.PublisherDAO;
import com.gcit.training.lws.domain.Publisher;

/**
 * @author bernardudu
 *
 */
public class PublisherDAOImpl implements PublisherDAO, Serializable{
	
	private Connection getConnection() throws SQLException {
		Connection conn;
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "root", "bernard");
		return conn;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 5173360736316267648L;

	/* (non-Javadoc)
	 * @see com.gcit.training.lws.daointerface.PublisherDAO#addPublisher(com.gcit.training.lws.domain.Publisher)
	 */
	@Override
	public void addPublisher(Publisher pub) throws Exception {
		Connection conn = getConnection();
		
		String insertQuery = "insert into tbl_publisher (publisherName, publisherAddress,"
				+ "publisherPhone) values (?, ?, ?)";
		PreparedStatement pubPstmt = conn.prepareStatement(insertQuery);

		pubPstmt.setString(1, pub.getName());
		pubPstmt.setString(2, pub.getAddress());
		pubPstmt.setString(3, pub.getPhoneNumber());
		pubPstmt.executeUpdate();
	}

	/* (non-Javadoc)
	 * @see com.gcit.training.lws.daointerface.PublisherDAO#updatePublisher(com.gcit.training.lws.domain.Publisher)
	 */
	@Override
	public void updatePublisher(Publisher pub) throws Exception {
		Connection conn = getConnection();

		String updateQuery = "update tbl_publisher set publisherName = ? where publisherId = ?";
		PreparedStatement pstmt = conn.prepareStatement(updateQuery);
		pstmt.setString(1, pub.getName());
		pstmt.setInt(2, pub.getId());
		pstmt.executeUpdate();
		
	}

	/* (non-Javadoc)
	 * @see com.gcit.training.lws.daointerface.PublisherDAO#removePublisher(com.gcit.training.lws.domain.Publisher)
	 */
	@Override
	public void removePublisher(Publisher pub) throws Exception {
		Connection conn = getConnection();
		
		String removeQuery = "delete from tbl_publisher where publisherId = ?";
		PreparedStatement pstmt = conn.prepareStatement(removeQuery);
		pstmt.setInt(1, pub.getId());
		pstmt.executeUpdate();
	}

	/* (non-Javadoc)
	 * @see com.gcit.training.lws.daointerface.PublisherDAO#readAll()
	 */
	@Override
	public List<Publisher> readAll() throws Exception {
		Connection conn = getConnection();
		
		String listPublishers = "select * from tbl_publisher";
		PreparedStatement pstmt = conn.prepareStatement(listPublishers);
		ResultSet rs = pstmt.executeQuery();
		
		List<Publisher> publishers = new ArrayList<Publisher>();
		
		while(rs.next()) {
			Publisher pub = new Publisher();
			pub.setId(rs.getInt("publisherId"));
			pub.setName(rs.getString("publisherName"));
			pub.setAddress(rs.getString("publisherAddress"));
			pub.setPhoneNumber(rs.getString("publisherPhone"));
			
			publishers.add(pub);
		}
		return publishers;
	}

}
