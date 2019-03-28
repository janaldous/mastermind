package com.janaldous.mastermind.gui;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;


public class View {
	private BoardFrame jfBoard;
	
	public View(String title, int rows) {
		jfBoard = new BoardFrame(title, rows);
		showView();
	}
	
	public void showView() {
		jfBoard.setVisible(true);
	}

	public JButton getGuessButton() {
		return jfBoard.getJbGuess();
	}

	public void showMessage(String message) {
		jfBoard.showMessage(message);
	}

	public void setGuessResult(int curIndex, int redPegs, int whitePegs) {
		jfBoard.setGuessResult(curIndex, redPegs, whitePegs);
	}

	public void showAnswer() {
		jfBoard.showAnswer();
	}

	public void startNewGame(int[] answer) {
		jfBoard.startNewGame(answer);
	}

	public JFrame getView() {
		return jfBoard;
	}

	public AbstractButton getChangePeg1Button() {
		return jfBoard.getPeg1Button();
	}
	
	public AbstractButton getChangePeg2Button() {
		return jfBoard.getPeg2Button();
	}
	
	public AbstractButton getChangePeg3Button() {
		return jfBoard.getPeg3Button();
	}
	
	public AbstractButton getChangePeg4Button() {
		return jfBoard.getPeg4Button();
	}

	public void changePeg(int rowIndex, int columnIndex, int color) {
		jfBoard.changePeg(rowIndex, columnIndex, color);
	}
}
