/**
 * BorrowerDAOTest.java
 * @author Bernard Udu <bernard_udu@gcitsolutions.com>
 * Created on Apr 20, 2015
 */
package com.gcit.training.lws.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.gcit.training.lws.daointerface.BorrowerDAOImpl;
import com.gcit.training.lws.domain.Borrower;

/**
 * @author bernardudu
 *
 */
public class BorrowerDAOTest {

	/**
	 * Test method for {@link com.gcit.training.lws.daointerface.BorrowerDAOImpl#addBorrower(com.gcit.training.lws.domain.Borrower)}.
	 */
	@Test
	public void testAddBorrower() {
		Borrower bruh = new Borrower();
		
		bruh.setBorrowerName("Flora B");
		bruh.setBorrowerAddress("231 Florence Ave Lancaster CA");
		bruh.setBorrowerPhone("245-098-7685");
		
		try {
			new BorrowerDAOImpl().addBorrower(bruh);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.gcit.training.lws.daointerface.BorrowerDAOImpl#updateBorrower(com.gcit.training.lws.domain.Borrower)}.
	 */
	@Test
	public void testUpdateBorrower() {
		Borrower b = new Borrower();
		
		b.setCardNo(1);
		b.setBorrowerName("Pearl N");
		b.setBorrowerAddress("12 King Str Ikot Abasi NY");
		try {
			new BorrowerDAOImpl().updateBorrower(b);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.gcit.training.lws.daointerface.BorrowerDAOImpl#removeBorrower(com.gcit.training.lws.domain.Borrower)}.
	 */
	@Test
	public void testRemoveBorrower() {
		Borrower b = new Borrower();
		
		b.setCardNo(5);
		try {
			new BorrowerDAOImpl().removeBorrower(b);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
