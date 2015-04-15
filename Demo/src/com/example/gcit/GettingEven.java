/**
 * GettingEven.java
 * @author Bernard Udu <bernard_udu@gcitsolutions.com>
 * Created on Apr 13, 2015
 */
package com.example.gcit;

import java.util.Scanner;

/**
 * @author bernardudu
 *
 */
public class GettingEven {

	public static void main(String[] args) {
		Scanner response = new Scanner(System.in);
		GameEngine engine;

		//For the purposes of playing again
		do {
			System.out.print("What is the name of the first player? ");
			String player1Name = response.next();
			System.out.print("What is the name of the second player? ");
			String player2Name = response.next();

			//make sure names are not the same
			while(player1Name.equalsIgnoreCase(player2Name)) {
				System.out.println("Both players can't be named " + player1Name +
						". Enter a different name");
				player2Name = response.next();

			}
			System.out.println("How many chips does the initial pile contains? ");

			int totalChipsInPile;
			boolean chipsCheck = true;
			do {
				totalChipsInPile = response.nextInt();
				if (totalChipsInPile < 3){
					System.out.println("You have to start with at least 3 chips."
							+ " Choose another number: ");
				}
				else if (totalChipsInPile % 2 == 0){
					System.out.println("You have to start with an odd number of chips. "
							+ "Choose another number: ");
				}else {
					chipsCheck = false;
				}
			}
			while (chipsCheck);

			// Start creating game using GameEngine constructor

			engine = new GameEngine(totalChipsInPile, player1Name, player2Name);

			//This variable holds sum of chips drawn by player
			int numChipsDrawn;


			while (!engine.isGameUp()) {
				engine.givePlayerState(); //player is informed of game state

				numChipsDrawn = engine.maxChipsPerDraw();

				//Re-prompt for legal move
				while (!engine.isMoveLegal(numChipsDrawn)) {
					System.out.println(engine.illegalMovesPrompt(numChipsDrawn));
					numChipsDrawn = engine.maxChipsPerDraw();
					totalChipsInPile = response.nextInt();
				}
				engine.updateMove(numChipsDrawn);
			}
			engine.displayWinner();
		}
		while (engine.playAgain());
	}

}
