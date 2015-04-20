/**
 * LibraryBranchDAO.java
 * @author Bernard Udu <bernard_udu@gcitsolutions.com>
 * Created on Apr 20, 2015
 */
package com.gcit.training.lws.daointerface;

import com.gcit.training.lws.domain.LibraryBranch;

/**
 * @author bernardudu
 *
 */
public interface LibraryBranchDAO {
	public void addBranch(LibraryBranch libBranch) throws Exception;
	public void updateBranch(LibraryBranch libBranch) throws Exception;
	public void removeBranch(LibraryBranch libBranch) throws Exception;

}
