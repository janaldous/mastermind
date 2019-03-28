package com.janaldous.mastermind.gui;

import com.janaldous.mastermind.core.Board;
import com.janaldous.mastermind.core.Game;
import com.janaldous.mastermind.core.GuessResult;

public class Model {
	
	private Game game;

	public Model() {
		Board board = new Board(createRandomCode());
		game = new Game(board);
	}
	
	void setGame(Game game) {
		this.game = game;
	}
	
	public int[] getAnswer() {
		return game.getAnswer();
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

	public int toggleColor(int col) {
		int color = game.getRow(game.getCurrentRowIndex()).getRow()[col];
		
		color++;

        if (color > Board.NO_OF_COLORS) {
        	color = 1;
        }
        
        game.setColor(game.getCurrentRowIndex(), col, color);
        
		return color;
	}

	public int[] getRowGuess(int curIndex) {
		return game.getRow(curIndex).getRow();
	}
}
