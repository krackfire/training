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
import java.util.Map;


/**
 * @author bernardudu
 *
 */
public class StudentGrades {

	/**
	 * @param args
	 */
	public static void main(String[] args) {	
		List<String> line = new ArrayList<String>();
		BufferedReader inputStream = null;
		try {
			inputStream = new BufferedReader(
					new FileReader("studentGrades.txt"));
			String str;
			inputStream.readLine(); //removes header from output by reading it first
			while ((str = inputStream.readLine()) != null) {
				line.add(str);
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
		Collections.sort(line, String.CASE_INSENSITIVE_ORDER);		
		
		Iterator<String> iter = line.iterator();
		
		System.out.println("Alpha Order");
		while (iter.hasNext()) {
			Object element = iter.next();
			System.out.println(element);
		}

		/*Map<String, Integer> map = new HashMap<String, Integer>();

		while (iter.hasNext()) {
			String word = iter.next().toLowerCase();
			if (word.contains(" ")) {
				String[] parts = word.split(" ");
				map.put(parts[0], Integer.parseInt(parts[1]));
			}
		}*/
		
		/*TreeMap<String, Integer> freq = new TreeMap<String, Integer>();
		Scanner in = null;
		String word;
		int count = 0;
		try {
			in = new Scanner(new FileReader("studentGrades.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (in.hasNext()) {
			word = in.next();
			if (freq.containsKey(word)) {
				freq.get(word);
				count++;
			}
			freq.put(word, count);
			for (String w : freq.keySet()) {
				System.out.println(word);
			}
		}*/
	}

}
