/**
 * SetDemo.java
 * @author Bernard Udu <bernard_udu@gcitsolutions.com>
 * Created on Apr 15, 2015
 */
package com.training.gcit;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bernardudu
 *
 */
public class SetDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<String> mySet = new HashSet<String>();

		
		mySet.add("pear");
		mySet.add("banana");
		mySet.add("tangerine");
		mySet.add("strawberry");
		mySet.add("blackberry");
		
		//Display content of mySet
		System.out.println("mySet now contains");
		System.out.println(mySet);
		System.out.println();
		
		//Display size of mySet
		System.out.println("The size of mySet is: " + mySet.size());
		System.out.println();
		
		//Remove Remove strawberry and blackberry from mySet
		System.out.println("Remove strawberry and blackberry from mySet");
		mySet.remove("strawberry");
		mySet.remove("blackberry");
		
		System.out.println("The new size of mySet is: " + mySet.size());
		System.out.println();
		
		
		System.out.println("Clear mySet");
		//Clear the entire set
		mySet.clear();
		
		System.out.println("The new size of mySet is: " + mySet.size());
		System.out.println();
		
		//Returns true if mySet is empty
		System.out.println(mySet.isEmpty());
		
		
		

	}

}
