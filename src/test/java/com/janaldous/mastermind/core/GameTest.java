package com.janaldous.mastermind.core;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {
	
	@Test
	public void testCorrectCurIndex() throws InvalidColorException {
		int[] answer = {1,2,3,4};
		Board board = new Board(answer, 3, 8);
		Game game = new Game(board);
		int[] guess = {1,2,3,6};
		game.guess(guess);
		
		assertEquals(1, game.getCurrentRowIndex());
	}
	
	@Test
	public void testCorrectPosition() throws InvalidColorException {
		int[] answer = {1,2,3,4};
		Board board = new Board(answer, 3, 8);
		Game game = new Game(board);
		int[] guess = {1,2,3,4};
		GuessResult result = game.guess(guess);
		
		assertEquals(4, result.getRedPegs());
		assertEquals(0, result.getWhitePegs());
		assertEquals(true, result.hasWon());
	}
	
	@Test
	public void testCorrectColor() throws InvalidColorException {
		int[] answer = {1,2,3,4};
		Board board = new Board(answer, 3, 8);
		Game game = new Game(board);
		int[] guess = {4,3,2,1};
		GuessResult result = game.guess(guess);
		
		assertEquals(0, result.getRedPegs());
		assertEquals(4, result.getWhitePegs());
	}
	
	@Test
	public void testCorrectColorDuplicate() throws InvalidColorException {
		int[] answer = {1,2,3,4};
		Board board = new Board(answer, 3, 8);
		Game game = new Game(board);
		int[] guess = {4,4,2,1};
		GuessResult result = game.guess(guess);
		
		assertEquals(0, result.getRedPegs());
		assertEquals(3, result.getWhitePegs());
	}
	
	@Test
	public void testCorrectColorDuplicate2() throws InvalidColorException {
		int[] answer = {1,2,3,4};
		Board board = new Board(answer, 3, 8);
		Game game = new Game(board);
		int[] guess = {7,5,6,7};
		GuessResult result = game.guess(guess);
		
		assertEquals(0, result.getRedPegs());
		assertEquals(0, result.getWhitePegs());
	}
	
	@Test
	public void testCorrectColorDuplicate3() throws InvalidColorException {
		int[] answer = {1,2,3,4};
		Board board = new Board(answer, 3, 8);
		Game game = new Game(board);
		int[] guess = {1,3,6,4};
		GuessResult result = game.guess(guess);
		
		assertEquals(2, result.getRedPegs());
		assertEquals(1, result.getWhitePegs());
	}
	
	@Test
	public void testCorrectColorDuplicate4() throws InvalidColorException {
		int[] answer = {1,2,4,4};
		Board board = new Board(answer, 3, 8);
		Game game = new Game(board);
		int[] guess = {4,2,2,1};
		GuessResult result = game.guess(guess);
		
		assertEquals(1, result.getRedPegs());
		assertEquals(2, result.getWhitePegs());
	}
	
	@Test
	public void testCorrectColorDuplicate5() throws InvalidColorException {
		int[] answer = {1,2,5,4};
		Board board = new Board(answer, 3, 8);
		Game game = new Game(board);
		int[] guess = {4,4,2,1};
		GuessResult result = game.guess(guess);
		
		assertEquals(0, result.getRedPegs());
		assertEquals(3, result.getWhitePegs());
		assertEquals(false, result.hasWon());
	}
	
	@Test
	public void testCorrectColor6() throws InvalidColorException {
		int[] answer = {3, 1, 5, 2};
		Board board = new Board(answer, 3, 8);
		Game game = new Game(board);
		int[] guess2 = {5, 3, 4, 2};
		GuessResult result = game.guess(guess2);
		
		assertEquals(1, result.getRedPegs());
		assertEquals(2, result.getWhitePegs());
		assertEquals(false, result.hasWon());
	}
	
	@Test(expected = NoMoreGuessesException.class)
	public void testGuessCorrectComboThenGuessAgain() throws InvalidColorException {
		int[] answer = {1,2,4,4};
		Board board = new Board(answer, 3, 8);
		Game game = new Game(board);
		int[] guess = {1,2,4,4};
		game.guess(guess);
		game.guess(guess);
	}
	
	@Test(expected = NoMoreGuessesException.class)
	public void testNoMoreGuesses() throws InvalidColorException {
		Board board = mock(Board.class);
		Game game = new Game(board);
		int[] guess = {4,3,2,1};
		when(board.getMaxGuesses()).thenReturn(0);
		game.guess(guess);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGiven3PegGuess() throws InvalidColorException {
		Board board = mock(Board.class);
		Game game = new Game(board);
		int[] guess = {4,3,2};
		when(board.getMaxGuesses()).thenReturn(1);
		game.guess(guess);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGivenNullPegGuess() throws InvalidColorException {
		Board board = mock(Board.class);
		Game game = new Game(board);
		when(board.getMaxGuesses()).thenReturn(1);
		game.guess(null);
	}
	
	@Test(expected = InvalidColorException.class)
	public void testGivenInvalidColorPegGuess() throws InvalidColorException {
		Board board = mock(Board.class);
		Game game = new Game(board);
		when(board.getMaxGuesses()).thenReturn(1);
		when(board.isValidColor(5)).thenReturn(false);
		int[] guess = {4,3,2,5};
		game.guess(guess);
	}
}
