/**
 * PublisherDAO.java
 * @author Bernard Udu <bernard_udu@gcitsolutions.com>
 * Created on Apr 19, 2015
 */
package com.gcit.training.lws.daointerface;

import java.util.List;

import com.gcit.training.lws.domain.Publisher;

/**
 * @author bernardudu
 *
 */
public interface PublisherDAO {
	public void addPublisher(Publisher pub) throws Exception;
	
	public void updatePublisher(Publisher pub) throws Exception;
	
	public void removePublisher(Publisher pub) throws Exception;
	
	public List<Publisher> readAll() throws Exception;
}
