package com.janaldous.mastermind.core;

public class Board {
	public final static int MAX_GUESSES = 3;
	public final static int NO_OF_COLORS = 8;
	private Row answer;
	private Row[] rows;
	
	public Board(int[] code) {
		this.answer = new Row(code);
		rows = new Row[MAX_GUESSES];
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
}
