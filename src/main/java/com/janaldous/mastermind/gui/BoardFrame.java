package com.janaldous.mastermind.gui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.janaldous.mastermind.core.Board;
import com.janaldous.mastermind.core.Game;

public class BoardFrame extends JFrame {

	/**
	 *  
	 */
	private static final long serialVersionUID = 6198815571510192882L;
	
	private static final int FRAME_WIDTH    = 450;
    private static final int FRAME_HEIGHT   = 690;
    private static final int FRAME_X_ORIGIN = 450;
    private static final int FRAME_Y_ORIGIN = 100;
    
    private JLabel jlGuessResult[];
	
	public BoardFrame(Game game, Board board) {
		setTitle ("Mastermind");
        setSize  (FRAME_WIDTH, FRAME_HEIGHT);
        setLocation  (FRAME_X_ORIGIN, FRAME_Y_ORIGIN);
        setResizable(false);
        
        jlGuessResult = new JLabel[Board.MAX_GUESSES];
        
        //correct color and position
        int guessR = 50;
        for (int i = 0; i < Board.MAX_GUESSES; i++) {
        	jlGuessResult[i] = new JLabel();
        	jlGuessResult[i].setText(" " + 0);
        	jlGuessResult[i].setForeground(Color.RED);
        	jlGuessResult[i].setBounds(330, guessR, 40, 25);
            add(jlGuessResult[i]);

            guessR += 50;
        }
	}
}
