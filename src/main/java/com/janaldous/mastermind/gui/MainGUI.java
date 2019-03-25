package com.janaldous.mastermind.gui;

import com.janaldous.mastermind.core.Board;
import com.janaldous.mastermind.core.Game;

public class MainGUI {
	public static void main(String[] args) {
		int code[] = {1,2,3,4};
		Board board = new Board(code);
		Game game = new Game(board);
		BoardFrame jfBoard = new BoardFrame(game, board);
		jfBoard.setVisible(true);
	}
}
