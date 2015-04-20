/**
 * JDBCConnectionTest.java
 * @author Bernard Udu <bernard_udu@gcitsolutions.com>
 * Created on Apr 16, 2015
 */
package com.training.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.html.parser.Entity;


/**
 * @author bernardudu
 *
 */
public class JDBCConnectionTest {

	//Do INSERT INTO Publisher
	//if (str.equals("admin")) {

	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/library", "root", "bernard");

			String pubInsert = "INSERT INTO tbl_publisher (publisherId, publisherName, publisherAddress, publisherPhone) VALUES (?, ?, ?, ?)";
			String authorInsert = "INSERT INTO tbl_author (authorId, authorName) VALUES (?, ?)";
			String bookInsert = "INSERT INTO tbl_book (bookId, "+ "title, pubId) VALUES (?, ?, ?)";
			PreparedStatement pubInsertPstmt = conn.prepareStatement(pubInsert);
			

			List<Publisher> publishers = new ArrayList<Publisher>();
			for (Publisher pub : publishers) {
				pubInsertPstmt.setInt(1, pub.publisherId);
				pubInsertPstmt.setString(2, pub.getPublisherName());
				pubInsertPstmt.setString(3, pub.getPublisherAddress());
				pubInsertPstmt.setString(4, pub.getPublisherPhone());
			}
			pubInsertPstmt.addBatch();

			//				//Do Update Publisher
			//				try (PreparedStatement bookUpdatePstmt = conn.prepareStatement("UPDATE tbl_publisher SET publisherName = ?"
			//						+ " where publisherId = ?")){
			//					bookUpdatePstmt.setString(1, "Naija Prints");
			//					bookUpdatePstmt.setInt(2, 5);
			//					int rowsUpdated = bookUpdatePstmt.executeUpdate();
			//					if (rowsUpdated > 0) {
			//						System.out.println(rowsUpdated + " row(s) successfully updated");
			//					}
			//				}
			//
			//			}
			//			else {
			//				System.out.println("Invalid input: " + str);
			//				in.next();
			//			}
			//
			//			conn.close();
			//		} catch (SQLException e) {
			//			e.printStackTrace();
			//		}
			//			
			//			
			//			

			/**************************************************
			 * Insert, update and delete into tbl_author table*/

			//						try (PreparedStatement insertPstmt = conn.prepareStatement("INSERT INTO tbl_author (authorId, authorName) VALUES (?, ?)")){
			//							insertPstmt.setInt(1, 10);
			//							insertPstmt.setString(2, "King K");
			//							int insertedRows = insertPstmt.executeUpdate();
			//							if (insertedRows > 0) {
			//								System.out.println(insertedRows + " row(s) inserted");
			//							}
			//						}
			//			
			//						try (PreparedStatement updatePstmt = conn.prepareStatement("UPDATE tbl_author SET authorName = ? where authorId = ?")){
			//							updatePstmt.setString(1, "Michael R");
			//							updatePstmt.setInt(2, 1);
			//							int rowsUpdated = updatePstmt.executeUpdate();
			//							if (rowsUpdated > 0) {
			//								System.out.println(rowsUpdated + " row(s) successfully updated");
			//							}
			//						};
			//			
			//			
			//									String alterQuery = "ALTER TABLE tbl_author ADD CONSTRAINT fk_tbl_book_authors_tbl_author1"
			//											+ "FOREIGN KEY (authorId) REFERENCES (tbl_book_authors) ON DELETE CASCADE";
			//									PreparedStatement alterPstmt = conn.prepareStatement(alterQuery);
			//									alterPstmt.executeUpdate();
			//			
			//			
			//						try (PreparedStatement deletePstmt = conn.prepareStatement("DELETE FROM tbl_author WHERE authorId = ? AND authorName = ?")) {
			//							deletePstmt.setInt(1, 2);
			//							deletePstmt.setString(2, "John K");
			//							int rowsDeleted = deletePstmt.executeUpdate();
			//							if (rowsDeleted > 0) {
			//								System.out.println(rowsDeleted + " row(s) deleted");
			//							}
			//						}
			//
			//			/**************************************************
			//			 * Insert, update and delete into TBL_PUBLISHER table
			//			 * ***********************************************/


			System.out.println("Please enter admin name to continue: ");
			Scanner in = new Scanner(System.in);
			String str = in.next();

			//Do INSERT INTO Publisher
			if (str.equals("admin")) {
				try (PreparedStatement bookInsertPstmt = conn.prepareStatement("INSERT INTO tbl_publisher (publisherId, publisherName, publisherAddress, publisherPhone) VALUES (?, ?, ?, ?)")){
					bookInsertPstmt.setInt(1, 10);
					bookInsertPstmt.setString(2, "Radiant Ink Publishers");
					bookInsertPstmt.setString(3, "74 Gold Str Abuja Nigeria");
					bookInsertPstmt.setString(4, "209-897-0061");

					int insertedRows = bookInsertPstmt.executeUpdate();
					if (insertedRows > 0) {
						System.out.println(insertedRows + " row(s) inserted");
					}
				}

				//Do Update Publisher
				try (PreparedStatement bookUpdatePstmt = conn.prepareStatement("UPDATE tbl_publisher SET publisherName = ?"
						+ " where publisherId = ?")){
					bookUpdatePstmt.setString(1, "Naija Prints");
					bookUpdatePstmt.setInt(2, 5);
					int rowsUpdated = bookUpdatePstmt.executeUpdate();
					if (rowsUpdated > 0) {
						System.out.println(rowsUpdated + " row(s) successfully updated");
					}
				}

			}
			else {
				System.out.println("Invalid input: " + str);
				in.next();
			}
			in.close();



			/**************************************************
			 * Insert, update and delete into TBL_BOOK table
			 * ***********************************************/

			try (PreparedStatement bookInsertPstmt = conn.prepareStatement("INSERT INTO tbl_book (bookId, "
					+ "title, pubId) VALUES (?, ?, ?)")){
				bookInsertPstmt.setInt(1, 31);
				bookInsertPstmt.setString(2, "Desert Hidden Rivers");
				bookInsertPstmt.setInt(3, 10);
				int insertedRows = bookInsertPstmt.executeUpdate();
				if (insertedRows > 0) {
					System.out.println(insertedRows + " row(s) inserted");
				}
			}
			
			try (PreparedStatement bookUpdatePstmt = conn.prepareStatement("UPDATE tbl_book SET title = ? "
					+ "where bookId = ? AND pubId = ?")){
				bookUpdatePstmt.setString(1, "Rocky Mountains");
				bookUpdatePstmt.setInt(2, 24);
				bookUpdatePstmt.setInt(3, 3);
				int rowsUpdated = bookUpdatePstmt.executeUpdate();
				if (rowsUpdated > 0) {
					System.out.println(rowsUpdated + " row(s) successfully updated");
				}
			}

			//Do Delete Publisher 
			try (PreparedStatement bookDeletePstmt = conn.prepareStatement("DELETE FROM tbl_publisher WHERE publisherId = ? AND publisherName = ?")) {
				bookDeletePstmt.setInt(1, 10);
				bookDeletePstmt.setString(2, "Radiant Ink Publishers");
				int rowsDeleted = bookDeletePstmt.executeUpdate();
				if (rowsDeleted > 0) {
					System.out.println(rowsDeleted + " row(s) deleted");
				}
			}
			//Delete from BookAuthors table
			try (PreparedStatement bookAuthorsDeletePstmt = conn.prepareStatement("DELETE FROM tbl_book_authors WHERE bookId = ? AND authorId = ?")) {
				bookAuthorsDeletePstmt.setInt(1, 25);
				bookAuthorsDeletePstmt.setInt(2, 4);
				int rowsDeleted = bookAuthorsDeletePstmt.executeUpdate();
				if (rowsDeleted > 0) {
					System.out.println(rowsDeleted + " row(s) deleted");
				}
			}

			//Delete from Book table
			try (PreparedStatement bookDeletePstmt = conn.prepareStatement("DELETE FROM tbl_book "
					+ "WHERE bookId = ? AND title = ? AND pubId = ?")) {
				bookDeletePstmt.setInt(1, 25);
				bookDeletePstmt.setString(2, "Running Hell");
				bookDeletePstmt.setInt(3, 4);
				int rowsDeleted = bookDeletePstmt.executeUpdate();
				if (rowsDeleted > 0) {
					System.out.println(rowsDeleted + " row(s) deleted");
				}
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
