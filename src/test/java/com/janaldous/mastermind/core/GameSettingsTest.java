package com.janaldous.mastermind.core;

import org.junit.Test;

public class GameSettingsTest {

	@Test(expected = IllegalArgumentException.class)
	public void test() {
		LevelSettings settings = new LevelSettingsFactory().getLevelSettings("EASY");
		new GameSettings(settings, new int[] {1,2,3,8});
	}

}
