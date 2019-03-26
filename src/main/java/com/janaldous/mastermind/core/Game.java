package com.janaldous.mastermind.core;

public class Game {

	private Board board;
	private int curIndex;
	
	public Game(Board board) {
		this.board = board;
		curIndex = 0;
	}

	public boolean hasNextGuess() {
		return curIndex < Board.MAX_GUESSES;
	}
	
	public GuessResult guess(int[] pegs) throws NoMoreGuessesException {
		if (pegs.length != 4) {
			throw new IllegalArgumentException("Invalid number of pegs");
		}
		
		for (int peg: pegs) {
			if (peg > Board.NO_OF_COLORS || peg <= 0) {
				throw new IllegalArgumentException("Invalid peg input");
			}
		}
		
		if (!hasNextGuess()) {
			throw new NoMoreGuessesException();
		}
		
		int redPegs = getCorrectPosition(pegs, board.getAnswer().getRow());
		int whitePegs = getCorrectColors(pegs, board.getAnswer().getRow());
		
		GuessResult result = new GuessResult(redPegs, whitePegs, redPegs == 4);
		Row row = new Row(pegs);
		row.setResult(result);
		board.guess(row, curIndex++);
		
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
}
