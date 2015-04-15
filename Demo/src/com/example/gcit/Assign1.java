/**
 * Assign1.java
 * @author Bernard Udu <bernard_udu@gcitsolutions.com>
 * Created on Apr 13, 2015
 */
package com.example.gcit;

import java.util.Scanner;

/**
 * @author bernardudu
 *
 */
public class Assign1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.print("What number am I thinking of? ");
		Scanner input = new Scanner(System.in);
		int guess = input.nextInt();
		int answer = 30;

		if ((guess <= (answer + 10)) && (guess >= (answer - 10))) {
			System.out.print(answer);
		}else {
			for (int count = 1; count < 5; count++) {
				System.out.print("Keep trying: ");
				input.nextInt();
				continue;		
			}
			System.out.println("Sorry! You have no more tries.");
		}

	}
}
