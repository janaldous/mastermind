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
    
    private JLabel jlCorrectPosition[];
    private JLabel jlCorrectColor[];
	
	public BoardFrame(Game game, Board board) {
		setTitle ("Mastermind");
        setSize  (FRAME_WIDTH, FRAME_HEIGHT);
        setLocation  (FRAME_X_ORIGIN, FRAME_Y_ORIGIN);
        setResizable(false);
        
        jlCorrectPosition = new JLabel[Board.MAX_GUESSES];
        jlCorrectColor = new JLabel[Board.MAX_GUESSES];
        
        //correct color and position
        int guessR = 50;
        for (int i = 0; i < Board.MAX_GUESSES; i++) {
        	jlCorrectPosition[i] = new JLabel();
        	jlCorrectPosition[i].setText(0 + "");
        	jlCorrectPosition[i].setForeground(Color.RED);
        	jlCorrectPosition[i].setBounds(330, guessR, 40, 25);
            
        	jlCorrectColor[i] = new JLabel();
        	jlCorrectColor[i].setText(0 + "");
        	jlCorrectColor[i].setBounds(370, guessR, 40, 25);

        	add(jlCorrectPosition[i]);
        	add(jlCorrectColor[i]);

            guessR += 50;
        }
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
