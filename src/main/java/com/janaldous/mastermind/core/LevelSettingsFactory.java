package com.janaldous.mastermind.core;

public class LevelSettingsFactory {
	
	public LevelSettings getLevelSettings(String level) {
		if ("EASY".equals(level)) {
			return new LevelSettings(5, 10);
		} else if ("MED".equals(level)) {
			return new LevelSettings(6, 7);
		} else if ("HARD".equals(level)) {
			return new LevelSettings(8, 5);
		}
		
		return null;
	}
}
