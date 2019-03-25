package com.janaldous.mastermind.core;

public class Board {
	private final static int MAX_GUESS = 3;
	public final static int NO_OF_COLORS = 8;
	private Row answer;
	private Row[] rows;
	private int curIndex;
	
	public Board(int[] code) {
		this.answer = new Row(code);
		rows = new Row[MAX_GUESS];
		curIndex = 0;
	}
	
	public void guess(int[] guessRow) {
		rows[curIndex] = new Row(guessRow);
		curIndex++;
	}
	
	/**
	 * @return the answer
	 */
	public Row getAnswer() {
		return answer;
	}
}
