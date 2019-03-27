package com.janaldous.mastermind.gui;

import com.janaldous.mastermind.core.Board;
import com.janaldous.mastermind.core.Game;
import com.janaldous.mastermind.core.GuessResult;

public class Model {
	
	private Board board;
	private Game game;
	private int row[];

	public Model() {
		board = new Board(createRandomCode());
		game = new Game(board);
		clearRowData();
	}
	
	public int[] getAnswer() {
		return board.getAnswer().getRow();
	}

	private int[] createRandomCode() {
		int ans[] = new int[4];
		for (int j = 0; j < 4; j++)
        {
            ans[j]  = (int) Math.floor(Math.random() * Board.NO_OF_COLORS) +1;
        }
		return ans;
	}

	public int getCurrentRowIndex() {
		return game.getCurrentRowIndex();
	}

	public GuessResult makeGuess(int[] row) {
		return game.guess(row);
	}

	public boolean hasNextGuess() {
		return game.hasNextGuess();
	}
	
	public void setColor(int col, int color) {
		board.setColor(game.getCurrentRowIndex(), col, color);
	}

	public int getNextColor(int col) {
		row[col]++;

        if (row[col] == Board.NO_OF_COLORS+1) {
        	row[col] = 1;
        }
        
		return row[col];
	}
	
	public void clearRowData() {
		row = new int[4];
        for (int i = 0; i < row.length; i++) {
			row[i] = 0;
		}
	}

	public int[] getRowGuess(int curIndex) {
		return board.getRow(curIndex).getRow();
	}
}
