package com.janaldous.mastermind.core;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {

	@Test
	public void testCorrectPosition() {
		int[] answer = {1,2,3,4};
		Board board = new Board(answer);
		Game game = new Game(board);
		int[] guess = {1,2,3,4};
		GuessResult result = game.guess(guess);
		
		assertEquals(4, result.getRedPegs());
		assertEquals(0, result.getWhitePegs());
	}
	
	@Test
	public void testCorrectColor() {
		int[] answer = {1,2,3,4};
		Board board = new Board(answer);
		Game game = new Game(board);
		int[] guess = {4,3,2,1};
		GuessResult result = game.guess(guess);
		
		assertEquals(0, result.getRedPegs());
		assertEquals(4, result.getWhitePegs());
	}
	
	@Test
	public void testCorrectColorDuplicate() {
		int[] answer = {1,2,3,4};
		Board board = new Board(answer);
		Game game = new Game(board);
		int[] guess = {4,4,2,1};
		GuessResult result = game.guess(guess);
		
		assertEquals(0, result.getRedPegs());
		assertEquals(3, result.getWhitePegs());
	}
	
	@Test
	public void testCorrectColorDuplicate2() {
		int[] answer = {1,2,3,4};
		Board board = new Board(answer);
		Game game = new Game(board);
		int[] guess = {7,5,6,7};
		GuessResult result = game.guess(guess);
		
		assertEquals(0, result.getRedPegs());
		assertEquals(0, result.getWhitePegs());
	}
	
	@Test
	public void testCorrectColorDuplicate3() {
		int[] answer = {1,2,3,4};
		Board board = new Board(answer);
		Game game = new Game(board);
		int[] guess = {1,3,6,7};
		GuessResult result = game.guess(guess);
		
		assertEquals(1, result.getRedPegs());
		assertEquals(1, result.getWhitePegs());
	}
	
	@Test
	public void testCorrectColorDuplicate4() {
		int[] answer = {1,2,4,4};
		Board board = new Board(answer);
		Game game = new Game(board);
		int[] guess = {4,3,2,1};
		GuessResult result = game.guess(guess);
		
		assertEquals(0, result.getRedPegs());
		assertEquals(3, result.getWhitePegs());
	}

}
