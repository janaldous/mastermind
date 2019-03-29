package com.janaldous.mastermind.gui;

import java.util.HashSet;
import java.util.Set;

import com.janaldous.mastermind.core.Board;
import com.janaldous.mastermind.core.Game;
import com.janaldous.mastermind.core.GuessResult;
import com.janaldous.mastermind.game.GameSettings;
import com.janaldous.mastermind.game.LevelSettings;
import com.janaldous.mastermind.game.LevelSettingsFactory;

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
		if (noOfColors != 0 || maxGuesses != 0) {
			throw new IllegalStateException("Settings has already been set");
		}
		this.noOfColors = settings.getNoOfColors();
		this.maxGuesses = settings.getNoOfGuesses();
		initModel(createRandomCode(settings.hasDuplicateColor()));
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

	public int[] createRandomCode(boolean duplicate) {
		int ans[] = new int[4];
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < 4; i++) {
            ans[i]  = (int) Math.floor(Math.random() * noOfColors) + 1;
            if (!duplicate && !set.add(ans[i])) {
            	i--;
            }
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
		LevelSettings settings = new LevelSettingsFactory().createLevelSettings(level);
		setLevelSettings(settings);
	}

	/**
	 * @return the noOfColors
	 */
	public int getNoOfColors() {
		return noOfColors;
	}

	/**
	 * @param noOfColors the noOfColors to set
	 */
	public void setNoOfColors(int noOfColors) {
		this.noOfColors = noOfColors;
	}
}
