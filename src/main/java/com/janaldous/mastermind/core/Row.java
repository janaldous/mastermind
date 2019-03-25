package com.janaldous.mastermind.core;

public class Row {
	private int[] row;
	private GuessResult result;
	
	public Row() {
		row = new int[4];
	}

	public Row(int[] guessRow) {
		row = guessRow;
	}

	/**
	 * @return the row
	 */
	public int[] getRow() {
		return row;
	}

	/**
	 * @return the result
	 */
	public GuessResult getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(GuessResult result) {
		this.result = result;
	}
}
