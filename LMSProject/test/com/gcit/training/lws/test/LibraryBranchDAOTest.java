/**
 * LibraryBranchDAOTest.java
 * @author Bernard Udu <bernard_udu@gcitsolutions.com>
 * Created on Apr 20, 2015
 */
package com.gcit.training.lws.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.gcit.training.lws.dao.LibraryBranchDAOImpl;
import com.gcit.training.lws.domain.LibraryBranch;

/**
 * @author bernardudu
 *
 */
public class LibraryBranchDAOTest {

	/**
	 * Test method for {@link com.gcit.training.lws.dao.LibraryBranchDAOImpl#addBranch(com.gcit.training.lws.domain.LibraryBranch)}.
	 */
	@Test
	public void testAddBranch() {
		LibraryBranch lb = new LibraryBranch();
		lb.setBranchAddress("120 Basement way, Rockland NY");
		lb.setBranchName("Basement Rocks Library");
		
		try {
			new LibraryBranchDAOImpl().addBranch(lb);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.gcit.training.lws.dao.LibraryBranchDAOImpl#updateBranch(com.gcit.training.lws.domain.LibraryBranch)}.
	 */
	@Test
	public void testUpdateBranch() {
		LibraryBranch lb = new LibraryBranch();
		lb.setBranchId(4);
		lb.setBranchName("Arcade Books");
		
		try {
			new LibraryBranchDAOImpl().updateBranch(lb);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.gcit.training.lws.dao.LibraryBranchDAOImpl#removeBranch(com.gcit.training.lws.domain.LibraryBranch)}.
	 */
	@Test
	public void testRemoveBranch() {
		LibraryBranch lb = new LibraryBranch();
		lb.setBranchId(5);
		
		try {
			new LibraryBranchDAOImpl().removeBranch(lb);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
