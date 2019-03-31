package com.janaldous.mastermind.gui;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class BoardPanel extends JPanel implements IBoardPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private final static int ROWS = 12;
	
    private RowPanel rows[];
    private AnswerRowPanel answerRow;
    
	public BoardPanel() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		rows = new RowPanel[ROWS];
		
        for (int i = 0; i < ROWS; i++) {
        	rows[i] = new RowPanel();
        	add(rows[i]);
        }
        
        answerRow = new AnswerRowPanel();
        add(answerRow);    
	}
	
	
	/* (non-Javadoc)
	 * @see com.janaldous.mastermind.gui.IBoardPanel#startNewGame(int, int[])
	 */
	@Override
	public void startNewGame(int noOfRows, int[] answer) {
        for (int i = 0; i < rows.length; i++) {
        	rows[i].reset();
        	
            if (i < noOfRows) {
            	rows[i].setVisible(true);
            } else {
            	rows[i].setVisible(false);
            }
        }
        
        // Answer row
        setAnswer(answer);
        answerRow.setVisible(false);
	}
	
	/* (non-Javadoc)
	 * @see com.janaldous.mastermind.gui.IBoardPanel#showAnswer()
	 */
	@Override
	public void showAnswer() {
		answerRow.setVisible(true);
	}

	/* (non-Javadoc)
	 * @see com.janaldous.mastermind.gui.IBoardPanel#setAnswer(int[])
	 */
	@Override
	public void setAnswer(int[] answer) {
		for (int i = 0; i < 4; i++) {
            answerRow.setColor(i, answer[i]); 
        }
	}

	/* (non-Javadoc)
	 * @see com.janaldous.mastermind.gui.IBoardPanel#setGuessResult(int, int, int)
	 */
	@Override
	public void setGuessResult(int rowIndex, int redPegs, int whitePegs) {
		rows[rowIndex].setGuessResult(redPegs, whitePegs);
	}
	
	/* (non-Javadoc)
	 * @see com.janaldous.mastermind.gui.IBoardPanel#changePeg(int, int, int)
	 */
	@Override
	public void changePeg(int rowIndex, int columnIndex, int color) {
		rows[rowIndex].setColor(columnIndex, color);
	}
}
