/**
 * StudentGrades.java
 * @author Bernard Udu <bernard_udu@gcitsolutions.com>
 * Created on Apr 15, 2015
 */
package com.training.gcit;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * @author bernardudu
 *
 */
public class StudentGrades {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> lines = new ArrayList<String>();

		BufferedReader inputStream = null;
		try {
			inputStream = new BufferedReader(
					new FileReader("studentGrades.txt"));
			String str;
			inputStream.readLine(); //removes header from output by reading it first
			while ((str = inputStream.readLine()) != null) {
				lines.add(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		//sort list into alphabetical order
		Collections.sort(lines, String.CASE_INSENSITIVE_ORDER);
		Iterator<String> iter = lines.iterator();
		
		
		System.out.println("Alpha Order");
		while (iter.hasNext()) {
			Object element = iter.next();
			System.out.println(element);
		}
	}

}
