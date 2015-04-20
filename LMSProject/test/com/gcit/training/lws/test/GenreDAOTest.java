/**
 * GenreDAOTest.java
 * @author Bernard Udu <bernard_udu@gcitsolutions.com>
 * Created on Apr 20, 2015
 */
package com.gcit.training.lws.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.gcit.training.lws.dao.GenreDAOImpl;
import com.gcit.training.lws.domain.Genre;

/**
 * @author bernardudu
 *
 */
public class GenreDAOTest {

	/**
	 * Test method for {@link com.gcit.training.lws.dao.GenreDAOImpl#addGenre()}.
	 */
	@Test
	public void testAddGenre() {
		Genre g = new Genre();
		
		g.setName("Comedy");
		g.setGenreId(7);
		
		try {
			new GenreDAOImpl().addGenre(g);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.gcit.training.lws.dao.GenreDAOImpl#updateGenre()}.
	 */
	@Test
	public void testUpdateGenre() {
		Genre g = new Genre();
		g.setGenreId(3);
		g.setName("Drama");
		
		try {
			new GenreDAOImpl().updateGenre(g);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.gcit.training.lws.dao.GenreDAOImpl#remeoveGenre()}.
	 */
	@Test
	public void testRemeoveGenre() {
		Genre g = new Genre();
		
		g.setGenreId(8);
		
		try {
			new GenreDAOImpl().remeoveGenre(g);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
