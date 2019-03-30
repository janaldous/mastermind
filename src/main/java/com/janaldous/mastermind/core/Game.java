package com.janaldous.mastermind.core;

public class Game {

	private Board board;
	private int curIndex;
	
	public Game(Board board) {
		this.board = board;
		curIndex = 0;
	}

	public boolean hasNextGuess() {
		return curIndex < board.getMaxGuesses();
	}
	
	public GuessResult guess(int[] pegs) throws InvalidColorException {
		if (pegs == null || pegs.length != 4) {
			throw new IllegalArgumentException("Invalid number of pegs");
		}
		
		if (!hasNextGuess()) {
			throw new NoMoreGuessesException();
		}

		for (int peg: pegs) {
			if (!board.isValidColor(peg)) {
				throw new InvalidColorException("Invalid peg input");
			}
		}
		
		int redPegs = getCorrectPosition(pegs, board.getAnswer().getRow());
		int whitePegs = getCorrectColors(pegs, board.getAnswer().getRow());
		boolean hasWon = (redPegs == 4);
		
		GuessResult result = new GuessResult(redPegs, whitePegs, hasWon);
		board.setGuessResult(curIndex, result);
		
		if (hasWon) {
			curIndex = board.getMaxGuesses();
		}
		
		curIndex++;
		
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
	
	private int getCorrectColors(int guess[], int answer[]) {
		int whitePegs = 0;
		int guessColors[] = new int[board.getNoOfColors()+1];
		int answerColors[] = new int[board.getNoOfColors()+1];
		
		for (int i = 0; i < 4; i++) {
			if (guess[i] != answer[i]) {
		        guessColors[guess[i]]++;
		        answerColors[answer[i]]++;
			}
        }
		
        for (int i = 0; i < board.getNoOfColors(); i++) {
        	if (guessColors[i] > 0 && answerColors[i] > 0) {
        		whitePegs += Math.min(answerColors[i], guessColors[i]);
        	}
        }
        
        return whitePegs;
    }

	public int getCurrentRowIndex() {
		return curIndex;
	}

	public int[] getAnswer() {
		return board.getAnswer().getRow();
	}

	public void setColor(int currentRowIndex, int col, int color) {
		board.setColor(currentRowIndex, col, color);
	}

	public Row getRow(int row) {
		return board.getRow(row);
	}

	public int getNoOfColors() {
		return board.getNoOfColors();
	}

	public boolean isValidColor(int color) {
		return board.isValidColor(color);
	}

	public int[] getCurRow() {
		return board.getRow(curIndex).getRow();
	}
}
