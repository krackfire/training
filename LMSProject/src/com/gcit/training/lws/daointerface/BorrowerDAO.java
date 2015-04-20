/**
 * BorrowerDAO.java
 * @author Bernard Udu <bernard_udu@gcitsolutions.com>
 * Created on Apr 20, 2015
 */
package com.gcit.training.lws.daointerface;

import com.gcit.training.lws.domain.Borrower;

/**
 * @author bernardudu
 *
 */
public interface BorrowerDAO {
	public void addBorrower(Borrower borrower) throws Exception;
	public void updateBorrower(Borrower borrower) throws Exception;
	public void removeBorrower(Borrower borrower) throws Exception;

}
