/**
 * GameEngine.java
 * @author Bernard Udu <bernard_udu@gcitsolutions.com>
 * Created on Apr 13, 2015
 */
package com.example.gcit;

import java.util.Scanner;

/**
 * @author bernardudu
 *
 */
public class GameEngine {
	private int chipsLeft;
	private int chipsLimit; //available limit allowed
	private int turn;
	Player player1, player2;

	Scanner input = new Scanner(System.in);
	/**
	 * @param chipsLeft
	 * @param chipsLimit
	 * @param player1
	 * @param secondPlayer
	 */
	public GameEngine(int chips, String firstPlayer,
			String secondPlayer) {
		super();
		this.chipsLeft = chips;
		this.chipsLimit = (chipsLeft) / 2;
		player1 = new Player(firstPlayer);
		player2 = new Player(secondPlayer);
		turn = 0;
	}
	
	//inform player of his/her pile state
	public void givePlayerState() {
		System.out.println(player1.getName() + " has " + player1.getNumberOfChips()
				+ " chip" + ((player1.getNumberOfChips() == 1) ? "" : "s."));
		
		System.out.println(player2.getName() + " has " + player2.getNumberOfChips()
				+ " chip" + ((player2.getNumberOfChips() == 1) ? "" : "s."));
		
		System.out.println("It is your turn, " + turnToPlay().getName());
		
		System.out.println("There " + ((chipsLeft == 1) ? "is " : "are ") 
				+ chipsLeft + " chips remaining.");
	}
	
	//turnToPlay() method determines whose turn it is to play.
	private Player turnToPlay() {
		if (turn == 0)
			return player1;
		else
			return player2;
	}
	
	public int maxChipsPerDraw() {
		System.out.println("You may take " + ((chipsLimit == 1) 
				? (chipsLimit + " chip.") : ("between 1 and " + chipsLeft/2 + " chips.")));
		System.out.println("How many will you take " + turnToPlay().getName() + "?");
		return input.nextInt();
	}
	
	//Make sure a player takes at least one chip and not more than what's allowed
	public boolean isMoveLegal(int numberOfChips) {
		return numberOfChips > 0 && numberOfChips <= chipsLimit;
	}
	
	
	public String illegalMovesPrompt(int numberOfChips) {
		String message = "";

		if (numberOfChips <= 0) {
			message = "Illegal move: you must take at least one chip.";
		}
		else {
			message = "Illegal move: you may not take more than " + chipsLimit
					+ " chip" + ((chipsLimit == 1) ? "" : "s.");
		}

		return message;
		
	}
	
	//game is updated based on last move
	public void updateMove(int numChips) {
		chipsLeft -= numChips;
		turnToPlay().addChips(numChips);
		
		//alternate players
		if (turn == 0) 
			turn = 1;
		else
			turn = 0;
		
		//update pile
		chipsLimit = numChips * 2;
		if(chipsLimit > chipsLeft)
			chipsLimit = chipsLeft; //

	}
	
	public void displayWinner() {
		System.out.println(player1.getName() + " has " + player1.getNumberOfChips()
				+ " chip" + ((player1.getNumberOfChips() == 1) ? ""  : "s."));
		System.out.println(player2.getName() + " has " + player2.getNumberOfChips()
				+ " chip" + ((player2.getNumberOfChips() == 1) ? "" : "s."));
		
		if (chipsLeft == 0) {
			if (player1.getNumberOfChips() % 2 == 0) {
				System.out.println(player1.getName() + " wins!");
			}
			else
				System.out.println(player2.getName() + " wins!");
		}
	}
	
	public boolean isGameUp() {
		return chipsLeft == 0;
	}
	
	public boolean playAgain() {
		System.out.print("Would you like to play again? (y/n): ");
		String answer = input.next();
		System.out.println();
		return answer.startsWith("y") || answer.startsWith("Y");
	}
}
