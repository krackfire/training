/**
 * PublisherDAOTest.java
 * @author Bernard Udu <bernard_udu@gcitsolutions.com>
 * Created on Apr 19, 2015
 */
package com.gcit.training.lws.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.gcit.training.lws.dao.PublisherDAOImpl;
import com.gcit.training.lws.domain.Publisher;

/**
 * @author bernardudu
 *
 */
public class PublisherDAOTest {

	/**
	 * Test method for {@link com.gcit.training.lws.dao.PublisherDAOImpl#addPublisher(com.gcit.training.lws.domain.Publisher)}.
	 */
		@Test
		public void testAddPublisher() {
			Publisher pub = new Publisher();
			
			pub.setId(10);
			pub.setName("Write A Book Publishers");
			pub.setAddress("111 Udu Ln Showerhead NY");
			pub.setPhoneNumber("800-838-2888");
			
			try {
				new PublisherDAOImpl().addPublisher(pub);
			} catch (Exception e) {
				fail(e.getMessage());
			}
		}

	/**
	 * Test method for {@link com.gcit.training.lws.dao.PublisherDAOImpl#updatePublisher(com.gcit.training.lws.domain.Publisher)}.
	 */
	@Test
	public void testUpdatePublisher() {
		Publisher pub = new Publisher();
		pub.setId(5);
		pub.setName("Silent But Deadly (SBD)");
		try {
			new PublisherDAOImpl().updatePublisher(pub);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.gcit.training.lws.dao.PublisherDAOImpl#removePublisher(com.gcit.training.lws.domain.Publisher)}.
	 */
	@Test
	public void testRemovePublisher() {
		Publisher pub = new Publisher();
		pub.setId(4);
		try {
			new PublisherDAOImpl().removePublisher(pub);
		} catch (Exception e) {
			fail(e.getMessage());
		}

	}

	/**
	 * Test method for {@link com.gcit.training.lws.dao.PublisherDAOImpl#readAll()}.
	 */
	@Test
	public void testReadAll() {
		Publisher pub = new Publisher();
		List<Publisher> publishers = new ArrayList<Publisher>();
		
		pub.setAddress("publisherAddress");
		pub.setName("publisherName");
		pub.setPhoneNumber("publisherPhone");
		
		publishers.add(pub);
		
		try {
			new PublisherDAOImpl().readAll();
		} catch (Exception e) {
			fail(e.getMessage());
		}
		//fail("Not yet implemented");
	}

}
