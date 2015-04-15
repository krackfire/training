package com.example.gcit;

import java.util.ArrayList;
import java.util.Scanner;
/*
 * TODO: This is how to make a to do list with a block comment
 * 
*/
public class Button extends Widget {
	
	@Override
	public void doAction() {
		ArrayList<String> list = new ArrayList<String>(1);
		Scanner scanner = new Scanner(System.in);
		while(true){
			list.add(scanner.next());
			System.out.println(list);
		}
	}

}