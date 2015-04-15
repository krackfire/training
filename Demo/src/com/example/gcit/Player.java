/**
 * Player.java
 * @author Bernard Udu <bernard_udu@gcitsolutions.com>
 * Created on Apr 13, 2015
 */
package com.example.gcit;

/**
 * @author bernardudu
 *
 */
public class Player {
	private String name;
	private int numberOfChips;
	/**
	 * @param name
	 * @param numberOfChips
	 */
	/*
	 * Constructor to instantiate player's name and number of 
	 * chips*/
	public Player(String playerName) {
		name = playerName;
		numberOfChips = 0;
	}
	
	//Get the player's name
	public String getName() {
		return name;
	}
	
	//Returns a player's current number of chips
	public int getNumberOfChips() {
		return numberOfChips;
	}
	
	//Adds chips to a players current pile
	public void addChips(int numChips) {
		numberOfChips += numChips;
	}
}
