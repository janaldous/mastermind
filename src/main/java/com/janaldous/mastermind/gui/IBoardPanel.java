package com.janaldous.mastermind.gui;

public interface IBoardPanel {

	public abstract void startNewGame(int noOfRows, int[] answer);

	public abstract void showAnswer();

	public abstract void setAnswer(int[] answer);

	public abstract void setGuessResult(int curIndex, int redPegs, int whitePegs);

	public abstract void changePeg(int rowIndex, int columnIndex, int color);

}