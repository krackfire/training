/**
 * Publisher.java
 * @author Bernard Udu <bernard_udu@gcitsolutions.com>
 * Created on Apr 17, 2015
 */
package com.training.db;

/**
 * @author bernardudu
 *
 */
public class Publisher {
	int publisherId;
	String publisherName;
	String publisherAddress;
	String publisherPhone;
	
	public int getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public String getPublisherAddress() {
		return publisherAddress;
	}
	public void setPublisherAddress(String publisherAddress) {
		this.publisherAddress = publisherAddress;
	}
	public String getPublisherPhone() {
		return publisherPhone;
	}
	public void setPublisherPhone(String publisherPhone) {
		this.publisherPhone = publisherPhone;
	}

}
