package com.janaldous.mastermind.gui;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.janaldous.mastermind.core.Game;
import com.janaldous.mastermind.core.Row;

public class ModelTest {

	@Test
	public void testNewRowToggleColor() {
		Model model = new Model();
		int color = model.toggleColor(0);
		assertEquals(1, color);
		
		color = model.toggleColor(0);
		assertEquals(2, color);
		
		color = model.toggleColor(0);
		assertEquals(3, color);
		
		int ans[] = model.getRowGuess(0);
		assertArrayEquals(new int[] {3, 0, 0, 0}, ans);
	}
	
	@Test
	public void testChangedRowToggleColor() {
		Game game = mock(Game.class);
		Model model = new Model();
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

}
