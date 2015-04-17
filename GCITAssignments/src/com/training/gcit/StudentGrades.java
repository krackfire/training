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
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;



/**
 * @author bernardudu
 *
 */
public class StudentGrades {

	public static int getAverage() {
		Map<String, Student> map = new HashMap<String, Student>();
		int total = 0;
		for (String word : map.keySet()){
			total += map.get(word).getGrades() / map.get(word).getNum();
		}
		int val = total/map.keySet().size();
		return val;
	}

	public static void main(String[] args) throws IOException {	
		Map<String, Student> map = new TreeMap<String, Student>();

		String str;
		String[] key;
		BufferedReader inputStream = null;

		try {
			inputStream = new BufferedReader(new FileReader("studentGrades.txt"));
			inputStream.readLine();

			while ((str = inputStream.readLine()) != null) {
				key = str.split(" ");
				Student student = new Student();
				//check if map has key
				if (map.containsKey(key[0])) {
					//associate the key[name] with a grade(make sure its an integer)
					student.setGrades(map.get(key[0]).getGrades() + Integer.parseInt(key[1]));
					//number of times a name exits in file
					student.setNum(map.get(key[0]).getNum() + 1); 
					map.put(key[0], student); // associate specified value with specified key
				}
				else {
					student.setGrades(Integer.parseInt(key[1]));
					student.setNum(1);
					map.put(key[0], student);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		inputStream.close();

		System.out.println("Alpha Order");
		for (String word : map.keySet()) {
			System.out.println(word + " " + map.get(word).getNum() + " " 
					+ (double) map.get(word).getGrades()
					/ map.get(word).getNum());
		}
		
		Comparator<Map.Entry<String, Student>> entriesSortedByValues = new Comparator<Map.Entry<String, Student>>()  {
			@Override 
			public int compare(Map.Entry<String, Student> e1, Map.Entry<String, Student> e2) {
				return (e2.getValue().getGrades() / e2.getValue().getNum())
						- (e1.getValue().getGrades() / e1.getValue().getNum());
			}
		};
		ArrayList<Map.Entry<String, Student>> list = new ArrayList<Map.Entry<String, Student>>();
		list.addAll(map.entrySet());
		Collections.sort(list, entriesSortedByValues);
		
		System.out.println();
		System.out.println("Merit Order");
		for (Entry<String, Student> st : list) {
			System.out.println(st.getKey() + " " + st.getValue().getNum()
					+ " " + (double) st.getValue().getGrades()
					/ st.getValue().getNum());
		}
		int average = getAverage();
		System.out.println("Average student mark is: " + average);
	}
}

