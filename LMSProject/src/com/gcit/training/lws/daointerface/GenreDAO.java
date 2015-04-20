/**
 * GenreDAO.java
 * @author Bernard Udu <bernard_udu@gcitsolutions.com>
 * Created on Apr 20, 2015
 */
package com.gcit.training.lws.daointerface;

import com.gcit.training.lws.domain.Genre;

/**
 * @author bernardudu
 *
 */
public interface GenreDAO {
	public void addGenre(Genre genres) throws Exception;
	public void updateGenre(Genre genres) throws Exception;
	public void remeoveGenre(Genre genres) throws Exception;

}
