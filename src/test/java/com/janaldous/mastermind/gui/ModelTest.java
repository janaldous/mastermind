package com.janaldous.mastermind.gui;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.janaldous.mastermind.core.Game;
import com.janaldous.mastermind.core.Row;
import com.janaldous.mastermind.game.GameSettings;
import com.janaldous.mastermind.game.LevelSettings;
import com.janaldous.mastermind.game.LevelSettingsFactory;

public class ModelTest {

	@Test
	public void testNewRowToggleColor() {
		Model model = new Model();
		model.setLevelSettings("HARD");
		int color = model.toggleColor(0);
		assertEquals(1, color);
		
		color = model.toggleColor(0);
		color = model.toggleColor(0);
		
		int ans[] = model.getRowGuess(0);
		assertArrayEquals(new int[] {3, 0, 0, 0}, ans);
	}
	
	@Test
	public void testChangedRowToggleColor() {
		Game game = mock(Game.class);
		Model model = new Model();
		model.setLevelSettings("HARD");
		model.setGame(game);
		when(game.getCurrentRowIndex()).thenReturn(0);
		Row row = new Row();
		row.setColor(0, 1);
		row.setColor(1, 1);
		row.setColor(2, 1);
		row.setColor(3, 1);
		when(game.getRow(0)).thenReturn(row);
		
		int color = model.toggleColor(0);
		assertEquals(2, color);
	}
	
	@Test
	public void testChangedRowToggleColorBoundaryCase() {
		Game game = mock(Game.class);
		Model model = new Model();
		model.setGame(game);
		when(game.getCurrentRowIndex()).thenReturn(0);
		Row row = new Row();
		row.setColor(0, 8);
		row.setColor(1, 1);
		row.setColor(2, 1);
		row.setColor(3, 1);
		when(game.getRow(0)).thenReturn(row);
		
		int color = model.toggleColor(0);
		assertEquals(1, color);
	}
	
	@Test
	public void testSetLevelSettings() {
		Model model = new Model();
		model.setLevelSettings("HARD");
		assertEquals(5, model.getNoOfGuesses());
	}
	
	@Test(expected = IllegalStateException.class)
	public void testChangeLevelSettingsAfterSettingGameSetting() {
		LevelSettings levelSettings = new LevelSettingsFactory().createLevelSettings("HARD");
		GameSettings settings = new GameSettings(levelSettings, new int[] {1,2,3,4});
		Model model = new Model(settings);
		model.setLevelSettings("HARD");
	}
	
	@Test(expected = IllegalStateException.class)
	public void testChangeLevelSettingsAfterSettingGameSetting2() {
		LevelSettings levelSettings = new LevelSettingsFactory().createLevelSettings("HARD");
		GameSettings settings = new GameSettings(levelSettings, new int[] {1,2,3,4});
		Model model = new Model(settings);
		model.setLevelSettings(levelSettings);
	}
	
	@Test
	public void testGenerateRandomDuplicateColorCode() {
		int noOfColors = 4;
		Model model = new Model();
		model.setNoOfColors(noOfColors);
		int ans[] = model.createRandomCode(true);
		for (int i = 0; i < ans.length; i++) {
			assertTrue(ans[i] > 0 && ans[i] <= noOfColors);
		}
		assertEquals(4, ans.length);
	}
	
	@Test
	public void testGenerateRandomUniqueColorCode() {
		Model model = new Model();
		model.setLevelSettings("EASY");
		int ans[] = model.createRandomCode(false);
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < ans.length; i++) {
			assertTrue("Duplicate number: " + ans[i], set.add(ans[i]));
		}
	}
	
}
