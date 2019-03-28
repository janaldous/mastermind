package com.janaldous.mastermind.core;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTest {

	@Test
	public void testValidColorInsideLowerBoundary() {
		Board board = new Board(new int[] {1,2,3,4}, 3, 8);
		assertTrue(board.isValidColor(1));
	}
	
	@Test
	public void testValidColorInsideUpperBoundary() {
		Board board = new Board(new int[] {1,2,3,4}, 3, 8);
		assertTrue(board.isValidColor(8));
	}
	
	@Test
	public void testValidColorLowerOutsideBoundary() {
		Board board = new Board(new int[] {1,2,3,4}, 3, 8);
		assertFalse(board.isValidColor(0));
	}
	
	@Test
	public void testValidColorUpperOutsideBoundary() {
		Board board = new Board(new int[] {1,2,3,4}, 3, 8);
		assertFalse(board.isValidColor(9));
	}

}
