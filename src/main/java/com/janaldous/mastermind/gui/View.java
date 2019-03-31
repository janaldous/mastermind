package com.janaldous.mastermind.gui;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class View {
	private BoardFrame jfBoard;
	private BoardPanel jpPanel;
	private ButtonPanel jpButton;
	
	public View(String title) {
		jpPanel = new BoardPanel();
		jpButton = new ButtonPanel();
		jfBoard = new BoardFrame(title, jpPanel, jpButton);
		showView();
	}
	
	public void showView() {
		jfBoard.setVisible(true);
	}

	public JButton getGuessButton() {
		return jpButton.getJbGuess();
	}

	public void showMessage(String message) {
		JOptionPane.showMessageDialog(jfBoard, message);
	}

	public void setGuessResult(int curIndex, int redPegs, int whitePegs) {
		jpPanel.setGuessResult(curIndex, redPegs, whitePegs);
	}

	public void showAnswer() {
		jpPanel.showAnswer();
	}

	public void startNewGame(int rows, int[] answer) {
		jpPanel.startNewGame(rows, answer);
	}

	public JFrame getView() {
		return jfBoard;
	}

	public AbstractButton getChangePeg1UpButton() {
		return jpButton.getPeg1Button();
	}
	
	public AbstractButton getChangePeg2UpButton() {
		return jpButton.getPeg2Button();
	}
	
	public AbstractButton getChangePeg3UpButton() {
		return jpButton.getPeg3Button();
	}
	
	public AbstractButton getChangePeg4UpButton() {
		return jpButton.getPeg4Button();
	}
	
	public AbstractButton getChangePeg1DownButton() {
		return jpButton.getJbColumn1Down();
	}
	
	public AbstractButton getChangePeg2DownButton() {
		return jpButton.getJbColumn2Down();
	}
	
	public AbstractButton getChangePeg3DownButton() {
		return jpButton.getJbColumn3Down();
	}
	
	public AbstractButton getChangePeg4DownButton() {
		return jpButton.getJbColumn4Down();
	}

	public void changePeg(int rowIndex, int columnIndex, int color) {
		jpPanel.changePeg(rowIndex, columnIndex, color);
		jpPanel.repaint();
	}

	public String askGameLevel() {
		return JOptionPane.showInputDialog(
				jfBoard, 
				"Enter your level: { [\"\"] ORIG, [1] EASY, [2] MED, [3] HARD }", 
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
