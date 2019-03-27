package com.janaldous.mastermind.gui;

import javax.swing.JOptionPane;

import com.janaldous.mastermind.core.Board;
import com.janaldous.mastermind.core.GuessResult;
import com.janaldous.mastermind.core.NoMoreGuessesException;

public class Controller {

	private Model model;
	private View view;

	public Controller(Model m, View v) {
		model = m;
		view = v;
		initView();
	}
	
	public void initView() {
		view.startNewGame(model.getAnswer());
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
			throw new NoMoreGuessesException();
		}
		int color = model.getNextColor(i);
		model.setColor(i, color);
		view.changePeg(model.getCurrentRowIndex(), i, color);
	}

	private void makeGuess() {
		int curIndex = model.getCurrentRowIndex();
		if (!model.hasNextGuess()) {
			throw new NoMoreGuessesException();
		}
		int row[] = model.getRowGuess(curIndex);
		for (int i = 0; i < row.length; i++) {
			if (row[i] <= 0 || row[i] > Board.NO_OF_COLORS) {
				view.showMessage("Invalid guess.");
				return;
			}
		}
		
		GuessResult result = model.makeGuess(row);
		view.setGuessResult(curIndex, result.getRedPegs(), result.getWhitePegs());
		
		if (result.hasWon()) {
			view.showMessage("Congratulations!\nYou have guessed the correct color combination.");
			view.showAnswer();
			if (askPlayAgain()) {
				model = new Model();
				view.startNewGame(model.getAnswer());
			}
		} else if (model.hasNextGuess()) {
			model.clearRowData();
		} else  {
			view.showMessage("Incorrect\nYou have not guessed the correct color combination.");
			view.showAnswer();
			if (askPlayAgain()) {
				model = new Model();
				view.startNewGame(model.getAnswer());
			}
		}
	}
	
	private boolean askPlayAgain() {
		int selection = JOptionPane.showConfirmDialog(view.getView(),
                "Do you want to play again?",
                "New game?",
                JOptionPane.YES_NO_OPTION);

        if (selection == JOptionPane.YES_OPTION) {
            return true;
        }
        return false;
	}
}
