package com.janaldous.mastermind.core;

public class Board {
	
	public int maxGuesses;
	public int noOfColors;
	private Row answer;
	private Row[] rows;
	
	public Board(int[] code, int maxGuesses, int noOfColors) {
		this.answer = new Row(code);
		this.maxGuesses = maxGuesses;
		this.noOfColors = noOfColors;
		rows = new Row[maxGuesses];
		for (int i = 0; i < rows.length; i++) {
			rows[i] = new Row();
		}
	}
	
	public Row getRow(int index) {
		return rows[index];
	}
	
	/**
	 * @return the answer
	 */
	public Row getAnswer() {
		return answer;
	}

	public void setColor(int row, int col, int color) {
		rows[row].setColor(col, color);
	}

	public void setGuessResult(int row, GuessResult result) {
		rows[row].setResult(result);
	}

	/**
	 * @return the maxGuesses
	 */
	public int getMaxGuesses() {
		return maxGuesses;
	}

	/**
	 * @return the noOfColors
	 */
	public int getNoOfColors() {
		return noOfColors;
	}

	public boolean isValidColor(int color) {
		return color <= noOfColors && color > 0;
	}
}
