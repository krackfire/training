package com.gcit.training.lws.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.gcit.training.lws.dao.AuthorDAO;
import com.gcit.training.lws.domain.Author;

public class AuthorDAOTest {

	@Test
	public void testAddAuthor() {
		Author a = new Author();
		a.setAuthorName("Test");
		try {
			new AuthorDAO().addAuthor(a);
		} catch(Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testUpdateAuthor() {
		Author a = new Author();
		a.setAuthorId(2);
		a.setAuthorName("Tony Blair");

		try {
			new AuthorDAO().updateAuthor(a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}

	@Test
	public void testRemoveAuthor() {
		Author a = new Author();
		a.setAuthorId(11);

		try {
			new AuthorDAO().removeAuthor(a);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}

	@Test
	public void testReadAll() {
		Author a = new Author();
		List<Author> authors = new ArrayList<Author>();
		a.getAuthorId();
		a.getAuthorName();
		authors.add(a);

		try {
			AuthorDAO authdao= new AuthorDAO();
			authdao.readAll();
			System.out.println(authdao);
		} catch (SQLException e) {
			fail(e.getMessage());
		}
	}
}
