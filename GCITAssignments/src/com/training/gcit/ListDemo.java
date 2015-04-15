/**
 * ListDemo.java
 * @author Bernard Udu <bernard_udu@gcitsolutions.com>
 * Created on Apr 15, 2015
 */
package com.training.gcit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author bernardudu
 *
 */
public class ListDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> fruit = new ArrayList<String>();
		
		fruit.add("pear");
		fruit.add("banana");
		fruit.add("tangerine");
		fruit.add("strawberry");
		fruit.add("blackberry");
		
		Iterator<String> iter = fruit.iterator();
		
		while (iter.hasNext()) {
			Object element = iter.next();
			System.out.println(element);
		}
		System.out.println();
		System.out.println("Reverse display using ListIterator");
		
		ListIterator<String> liter = fruit.listIterator(fruit.size());
		while(liter.hasPrevious()) {
			System.out.println(liter.previous());
		}
		
		fruit.add(3, "banana");
		System.out.println(fruit);

	}

}
