package com.janaldous.mastermind.gui;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class View {
	private BoardFrame jfBoard;
	
	public View(String title) {
		jfBoard = new BoardFrame(title);
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

	public void startNewGame(int rows, int[] answer) {
		jfBoard.startNewGame(rows, answer);
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

	public String askGameLevel() {
		return JOptionPane.showInputDialog(
				jfBoard, 
				"Enter your level: { [1] EASY, [2] MED, [3] HARD }", 
				"Level settings", 
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	public boolean askPlayAgain() {
		int selection =  JOptionPane.showConfirmDialog(
				jfBoard,
				"Do you want to play again?",
				"New game?",
				JOptionPane.YES_NO_OPTION);
		return selection == JOptionPane.YES_OPTION;
	}
}
