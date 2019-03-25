package com.janaldous.mastermind.core;

public class GuessResult {

	private int redPegs;
	private int whitePegs;
	
	public GuessResult(int redPegs, int whitePegs) {
		this.redPegs = redPegs;
		this.whitePegs = whitePegs;
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
}
