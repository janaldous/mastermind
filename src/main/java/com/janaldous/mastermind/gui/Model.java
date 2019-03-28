package com.janaldous.mastermind.gui;

import com.janaldous.mastermind.core.Board;
import com.janaldous.mastermind.core.Game;
import com.janaldous.mastermind.core.GameSettings;
import com.janaldous.mastermind.core.GuessResult;
import com.janaldous.mastermind.core.LevelSettings;
import com.janaldous.mastermind.core.LevelSettingsFactory;

public class Model {
	
	private int noOfColors;
	private int maxGuesses;
	private Game game;
	
	public Model() {

	}
	
	public Model(GameSettings settings) {
		setLevelSettings(settings.getLevelSettings());
		initModel(settings.getAnswer());
	}
	
	public void setLevelSettings(LevelSettings settings) {
		this.noOfColors = settings.getNoOfColors();
		this.maxGuesses = settings.getNoOfGuesses();
		initModel(createRandomCode());
	}
	
	private void initModel(int answer[]) {
		Board board = new Board(answer, maxGuesses, noOfColors);
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
		for (int j = 0; j < 4; j++) {
            ans[j]  = (int) Math.floor(Math.random() * noOfColors) + 1;
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

        if (color > noOfColors) {
        	color = 1;
        }
        
        game.setColor(game.getCurrentRowIndex(), col, color);
        
		return color;
	}

	public int[] getRowGuess(int curIndex) {
		return game.getRow(curIndex).getRow();
	}

	public boolean isValidColor(int color) {
		return game.isValidColor(color);
	}

	public int getNoOfGuesses() {
		return maxGuesses;
	}

	public void setLevelSettings(String level) {
		LevelSettings settings = new LevelSettingsFactory().getLevelSettings(level);
		setLevelSettings(settings);
	}
}
