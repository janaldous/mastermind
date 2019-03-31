package com.janaldous.mastermind.gui;

import java.util.Arrays;

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
		view.getChangePeg1UpButton().addActionListener(e -> changePeg(true, 0));
		view.getChangePeg2UpButton().addActionListener(e -> changePeg(true, 1));
		view.getChangePeg3UpButton().addActionListener(e -> changePeg(true, 2));
		view.getChangePeg4UpButton().addActionListener(e -> changePeg(true, 3));
		view.getChangePeg1DownButton().addActionListener(e -> changePeg(false, 0));
		view.getChangePeg2DownButton().addActionListener(e -> changePeg(false, 1));
		view.getChangePeg3DownButton().addActionListener(e -> changePeg(false, 2));
		view.getChangePeg4DownButton().addActionListener(e -> changePeg(false, 3));
	}

	void changePeg(boolean up, int i) {
		if (!model.hasNextGuess()) {
			return;
		}
		
		int color = up ? model.incrementColor(i) : model.decrementColor(i);
		view.changePeg(model.getCurrentRowIndex(), i, color);
	}

	void makeGuess() {
		if (!model.hasNextGuess()) {
			return;
		}

		try {
			int curIndex = model.getCurrentRowIndex();
			System.out.println(Arrays.toString(model.getRowGuess(curIndex)));
			System.out.println("ans" + Arrays.toString(model.getAnswer()));
			GuessResult result = model.makeGuess();
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
		case "":
			return "ORIG";
		default:
			throw new IllegalArgumentException();
		}
	}
}
