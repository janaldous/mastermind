package com.janaldous.mastermind;

import com.janaldous.mastermind.core.Board;
import com.janaldous.mastermind.core.Game;
import com.janaldous.mastermind.gui.BoardFrame;

public class Main {
	public static void main(String[] args) {
		Board board = new Board(createRandomCode());
		Game game = new Game(board);
		BoardFrame jfBoard = new BoardFrame(game, board);
		jfBoard.setVisible(true);
	}
	
	private static int[] createRandomCode() {
		int ans[] = new int[4];
		for (int j = 0; j < 4; j++)
        {
            ans[j]  = (int) Math.floor(Math.random() * Board.NO_OF_COLORS) +1;
        }
		return ans;
	}
}
