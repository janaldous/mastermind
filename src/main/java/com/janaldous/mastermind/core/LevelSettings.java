package com.janaldous.mastermind.core;

public final class LevelSettings {
	
	private int noOfColors;
	private int noOfGuesses;
	
	public LevelSettings(int noOfColors, int noOfGuesses) {
		this.noOfColors = noOfColors;
		this.noOfGuesses = noOfGuesses;
	}

	/**
	 * @return the noOfColors
	 */
	public int getNoOfColors() {
		return noOfColors;
	}

	/**
	 * @param noOfColors the noOfColors to set
	 */
	public void setNoOfColors(int noOfColors) {
		this.noOfColors = noOfColors;
	}

	/**
	 * @return the noOfGuesses
	 */
	public int getNoOfGuesses() {
		return noOfGuesses;
	}

	/**
	 * @param noOfGuesses the noOfGuesses to set
	 */
	public void setNoOfGuesses(int noOfGuesses) {
		this.noOfGuesses = noOfGuesses;
	}
}
