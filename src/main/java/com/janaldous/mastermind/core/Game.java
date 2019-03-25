package com.janaldous.mastermind.core;

public class Game {

	private Board board;
	
	public Game() {
		int[] code = createRandomCode();
		board = new Board(code);
	}
	
	public Game(Board board) {
		this.board = board;
	}
	
	public GuessResult guess(int[] pegs) {
		// validate guess
		if (pegs.length != 4) {
			throw new IllegalArgumentException("Invalid peg input");
		}
		for (int peg: pegs) {
			if (peg > Board.NO_OF_COLORS && peg <= 0) {
				throw new IllegalArgumentException("Invalid peg input");
			}
		}
		
		int redPegs = getCorrectPosition(pegs, board.getAnswer().getRow());
		int whitePegs = getCorrectColors(pegs, board.getAnswer().getRow());
		GuessResult result = new GuessResult(redPegs, whitePegs);
		
		return result;
	}

	private int getCorrectPosition(int[] guess, int[] answer) {
        int redPegs = 0;

        for (int i = 0; i < 4; i++) {
            if (guess[i] == answer[i]) {
            	redPegs++;
            }
        }
        
        return redPegs;
	}
	
	private int getCorrectColors(int guess[], int answer[])
    {
		int whitePegs = 0;
		int guessColors[] = new int[Board.NO_OF_COLORS+1];
		int answerColors[] = new int[Board.NO_OF_COLORS+1];
		
		for (int i = 0; i < 4; i++) {
			if (guess[i] != answer[i]) {
		        guessColors[guess[i]]++;
		        answerColors[answer[i]]++;
			}
        }
		
        for (int i = 0; i < Board.NO_OF_COLORS; i++) {
        	if (guessColors[i] > 0 && answerColors[i] > 0) {
        		whitePegs += Math.min(answerColors[i], guessColors[i]);
        	}
        }
        
        return whitePegs;
    }

	private int[] createRandomCode() {
		int ans[] = new int[4];
		for (int j = 0; j < 4; j++)
        {
            ans[j]  = (int) Math.floor(Math.random() * Board.NO_OF_COLORS) +1;
        }
		return ans;
	}
	
}
