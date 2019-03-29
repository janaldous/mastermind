package com.janaldous.mastermind.game;

public final class LevelSettings {
	
	private int noOfColors;
	private int noOfGuesses;
	private boolean hasDuplicateColor;
	
	public LevelSettings(int noOfColors, int noOfGuesses, boolean hasDuplicateColor) {
		this.noOfColors = noOfColors;
		this.noOfGuesses = noOfGuesses;
		this.hasDuplicateColor = hasDuplicateColor;
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

	/**
	 * @return the hasDuplicateColor
	 */
	public boolean hasDuplicateColor() {
		return hasDuplicateColor;
	}

	/**
	 * @param hasDuplicateColor the hasDuplicateColor to set
	 */
	public void setHasDuplicateColor(boolean hasDuplicateColor) {
		this.hasDuplicateColor = hasDuplicateColor;
	}
}
