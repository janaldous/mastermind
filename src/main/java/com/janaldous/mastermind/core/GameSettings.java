package com.janaldous.mastermind.core;

public class GameSettings {
	
	private LevelSettings levelSettings;
	private int[] answer;
	
	public GameSettings(LevelSettings levelSettings, int[] answer) {
		this.levelSettings = levelSettings;
		this.answer = answer;
		for (int i = 0; i < 4; i++) {
			if (answer[i] < 1 || answer[i] > levelSettings.getNoOfColors()) {
				throw new IllegalArgumentException("Answer has invalid colors");
			}
		}
	}

	/**
	 * @return the levelSettings
	 */
	public LevelSettings getLevelSettings() {
		return levelSettings;
	}

	/**
	 * @param levelSettings the levelSettings to set
	 */
	public void setLevelSettings(LevelSettings levelSettings) {
		this.levelSettings = levelSettings;
	}

	/**
	 * @return the answer
	 */
	public int[] getAnswer() {
		return answer;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(int[] answer) {
		this.answer = answer;
	}
}
