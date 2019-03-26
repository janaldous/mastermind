package com.janaldous.mastermind.core;

public class GuessResult {

	private int redPegs;
	private int whitePegs;
	private boolean hasWon;
	
	public GuessResult(int redPegs, int whitePegs, boolean hasWon) {
		this.redPegs = redPegs;
		this.whitePegs = whitePegs;
		this.hasWon = hasWon;
	}
 	
	/**
	 * @return the redPegs
	 */
	public int getRedPegs() {
		return redPegs;
	}

	/**
	 * @return the whitePegs
	 */
	public int getWhitePegs() {
		return whitePegs;
	}

	/**
	 * @return the hasWon
	 */
	public boolean hasWon() {
		return hasWon;
	}
}
