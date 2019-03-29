package com.janaldous.mastermind.game;


public class LevelSettingsFactory {
	
	public LevelSettings createLevelSettings(String level) {
		if ("EASY".equals(level)) {
			return new LevelSettings(5, 10, false);
		} else if ("MED".equals(level)) {
			return new LevelSettings(6, 7, true);
		} else if ("HARD".equals(level)) {
			return new LevelSettings(8, 5, true);
		}
		
		return null;
	}
}
