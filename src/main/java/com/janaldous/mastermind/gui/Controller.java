package com.janaldous.mastermind.gui;

import javax.swing.JOptionPane;

import com.janaldous.mastermind.core.GuessResult;

public class Controller {

	private Model model;
	private View view;

	public Controller(Model m, View v) {
		model = m;
		view = v;
		String level = askGameLevel();
		model.setLevelSettings(level);
		initView();
	}

	public void initView() {
		view.startNewGame(model.getNoOfGuesses(), model.getAnswer());
	}

	public void initController() {
		view.getGuessButton().addActionListener(e -> makeGuess());
		view.getChangePeg1Button().addActionListener(e -> changePeg(0));
		view.getChangePeg2Button().addActionListener(e -> changePeg(1));
		view.getChangePeg3Button().addActionListener(e -> changePeg(2));
		view.getChangePeg4Button().addActionListener(e -> changePeg(3));
	}

	private void changePeg(int i) {
		if (!model.hasNextGuess()) {
			return;
		}
		int color = model.toggleColor(i);
		view.changePeg(model.getCurrentRowIndex(), i, color);
	}

	private void makeGuess() {
		if (!model.hasNextGuess()) {
			return;
		}

		int curIndex = model.getCurrentRowIndex();
		int row[] = model.getRowGuess(curIndex);
		for (int i = 0; i < row.length; i++) {
			if (!model.isValidColor(row[i])) {
				view.showMessage("Invalid guess.");
				return;
			}
		}

		GuessResult result = model.makeGuess(row);
		view.setGuessResult(curIndex, result.getRedPegs(), result.getWhitePegs());

		if (!model.hasNextGuess()) {
			if (result.hasWon()) {
				view.showMessage("Congratulations!\nYou have guessed the correct color combination.");
			} else  {
				view.showMessage("Incorrect\nYou have not guessed the correct color combination.");
			}
			view.showAnswer();
			if (askPlayAgain()) {
				String level = askGameLevel();
				model = new Model();
				model.setLevelSettings(level);
				view.startNewGame(model.getNoOfGuesses(), model.getAnswer());
			}
		}
	}

	private boolean askPlayAgain() {
		int selection = JOptionPane.showConfirmDialog(view.getView(),
				"Do you want to play again?",
				"New game?",
				JOptionPane.YES_NO_OPTION);

		return selection == JOptionPane.YES_OPTION;
	}

	private String askGameLevel() {
		String code = JOptionPane.showInputDialog(
				view.getView(), 
				"Enter your level: { EASY, MED, HARD }", 
				"Level settings", 
				JOptionPane.INFORMATION_MESSAGE
				);
		return code;
	}
}
