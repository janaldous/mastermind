package com.janaldous.mastermind.gui;

import com.janaldous.mastermind.core.GuessResult;
import com.janaldous.mastermind.core.InvalidColorException;

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

	void changePeg(int i) {
		if (!model.hasNextGuess()) {
			return;
		}
		int color = model.toggleColor(i);
		view.changePeg(model.getCurrentRowIndex(), i, color);
	}

	void makeGuess() {
		if (!model.hasNextGuess()) {
			return;
		}

		try {
			GuessResult result = model.makeGuess();
			int curIndex = model.getCurrentRowIndex();
			view.setGuessResult(curIndex, result.getRedPegs(), result.getWhitePegs());
			
			if (!model.hasNextGuess()) {
				if (result.hasWon()) {
					view.showMessage("Congratulations!\nYou have guessed the correct color combination.");
				} else  {
					view.showMessage("Incorrect\nYou have not guessed the correct color combination.");
				}
				view.showAnswer();
				askPlayAgain();
			}
		} catch (InvalidColorException e) {
			view.showMessage("Invalid guess.");
		}
	}

	private void askPlayAgain() {
		if (view.askPlayAgain()) {
			String level = askGameLevel();
			model = new Model();
			model.setLevelSettings(level);
			view.startNewGame(model.getNoOfGuesses(), model.getAnswer());
		}
	}

	String askGameLevel() {
		String code = view.askGameLevel();
		switch(code) {
		case "1":
			return "EASY";
		case "2":
			return "MED";
		case "3":
			return "HARD";
		default:
			throw new IllegalArgumentException();
		}
	}
}
