package com.janaldous.mastermind.core;

import static org.junit.Assert.*;

import org.junit.Test;

import com.janaldous.mastermind.game.GameSettings;
import com.janaldous.mastermind.game.LevelSettings;
import com.janaldous.mastermind.game.LevelSettingsFactory;

public class GameSettingsTest {

	@Test(expected = IllegalArgumentException.class)
	public void testGivenAnswerWithInvalidColors() {
		LevelSettings settings = new LevelSettingsFactory().createLevelSettings("EASY");
		new GameSettings(settings, new int[] {1,2,3,8});
	}
	
	@Test()
	public void testGivenAnswerWithValidColors() {
		LevelSettings settings = new LevelSettingsFactory().createLevelSettings("EASY");
		GameSettings gameSettings = new GameSettings(settings, new int[] {1,2,3,4});
		assertNotNull(gameSettings);
	}

}
