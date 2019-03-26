package com.janaldous.mastermind.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.janaldous.mastermind.core.Board;
import com.janaldous.mastermind.core.Game;
import com.janaldous.mastermind.core.GuessResult;

public class BoardFrame extends JFrame implements ActionListener {

	/**
	 *  
	 */
	private static final long serialVersionUID = 6198815571510192882L;
	
	private static final int FRAME_WIDTH    = 450;
    private static final int FRAME_HEIGHT   = 690;
    private static final int FRAME_X_ORIGIN = 450;
    private static final int FRAME_Y_ORIGIN = 100;
    private static final int PEG_WIDTH = 30;
    private static final int PEG_HEIGHT = 30;
    private static final int BUTTON_WIDTH = 70;
    private static final int BUTTON_HEIGHT = 30;
    
    private JLabel jlRedPegs[];
    private JLabel jlWhitePegs[];
    private JLabel jlBoardColumn[][];
    private JLabel jlAnswer[];
    private JLabel jlCorrect;
    
    private JButton jbHelp;
    private JButton jbQuit;
    private JButton jbGuess;
    private JButton jbColumn1;
    private JButton jbColumn2;
    private JButton jbColumn3;
    private JButton jbColumn4;
    
    private int row[];
    private int curRowIndex;

	private Game game;
	private Board board;

	public BoardFrame(Game game, Board board) {
		this.game = game;
		this.board = board;
		
		setTitle ("Mastermind");
        setSize  (FRAME_WIDTH, FRAME_HEIGHT);
        setLocation  (FRAME_X_ORIGIN, FRAME_Y_ORIGIN);
        setResizable(false);
        
        jlRedPegs = new JLabel[Board.MAX_GUESSES];
        jlWhitePegs = new JLabel[Board.MAX_GUESSES];
        jlBoardColumn = new JLabel[Board.MAX_GUESSES][4];
        jlAnswer = new JLabel[4];
        
        String emptyPeg = getFilePath("peg0.png");
    	
        // Set guess grid
        int yPosition = 50;
        for (int i = 0; i < Board.MAX_GUESSES; i++) {
        	jlBoardColumn[i][0] = new JLabel(new ImageIcon(emptyPeg)); 
        	jlBoardColumn[i][0].setBounds(50+(70*0), yPosition, PEG_WIDTH, PEG_HEIGHT);
            add(jlBoardColumn[i][0]);

            jlBoardColumn[i][1]= new JLabel(new ImageIcon(emptyPeg));
            jlBoardColumn[i][1].setBounds(50+(70*1), yPosition, PEG_WIDTH, PEG_HEIGHT);
            add(jlBoardColumn[i][1]);

            jlBoardColumn[i][2] = new JLabel(new ImageIcon(emptyPeg));
            jlBoardColumn[i][2].setBounds(50+(70*2), yPosition, PEG_WIDTH, PEG_HEIGHT);
            add(jlBoardColumn[i][2]);

            jlBoardColumn[i][3] = new JLabel(new ImageIcon(emptyPeg));
            jlBoardColumn[i][3].setBounds(50+(70*3), yPosition, PEG_WIDTH, PEG_HEIGHT);
            add(jlBoardColumn[i][3]);
        	
        	jlRedPegs[i] = new JLabel();
        	jlRedPegs[i].setText(0 + "");
        	jlRedPegs[i].setForeground(Color.RED);
        	jlRedPegs[i].setBounds(330, yPosition, 40, 25);
        	jlRedPegs[i].setVisible(false);
        	add(jlRedPegs[i]);
            
        	jlWhitePegs[i] = new JLabel();
        	jlWhitePegs[i].setText(0 + "");
        	jlWhitePegs[i].setBounds(370, yPosition, 40, 25);
        	jlWhitePegs[i].setVisible(false);
        	add(jlWhitePegs[i]);

            yPosition += 50;
        }
        
        // Answer row
        int xPosition = 50;
        for (int i = 0; i < 4; i++) {
            jlAnswer[i] = new JLabel(new ImageIcon(getFilePath("peg" + board.getAnswer().getRow()[i] + ".png"))); 
            jlAnswer[i].setBounds(xPosition, yPosition, PEG_WIDTH, PEG_HEIGHT);
            jlAnswer[i].setVisible(false);
            add(jlAnswer[i]);

            xPosition += 70;
        }
        
        jlCorrect = new JLabel();
        jlCorrect.setText("< Correct code");
        jlCorrect.setBounds(330, yPosition, 150, 25);
        jlCorrect.setVisible(false);
        add(jlCorrect);
        
        // Buttons
        jbGuess = new JButton("Guess");
        jbGuess.setBounds(310, 590, BUTTON_WIDTH, BUTTON_HEIGHT);
        add(jbGuess);

        jbQuit = new JButton("Quit");
        jbQuit.setBounds(170, 630, BUTTON_WIDTH, BUTTON_HEIGHT);
        add(jbQuit);

        jbHelp = new JButton("Help");
        jbHelp.setBounds(240, 630, BUTTON_WIDTH, BUTTON_HEIGHT);
        add(jbHelp);

        jbColumn1 = new JButton("1");
        jbColumn1.setBounds(30, 590, BUTTON_WIDTH, BUTTON_HEIGHT);
        add(jbColumn1);

        jbColumn2 = new JButton("2");
        jbColumn2.setBounds(100, 590, BUTTON_WIDTH, BUTTON_HEIGHT);
        add(jbColumn2);

        jbColumn3 = new JButton("3");
        jbColumn3.setBounds(170, 590, BUTTON_WIDTH, BUTTON_HEIGHT);
        add(jbColumn3);

        jbColumn4 = new JButton("4");
        jbColumn4.setBounds(240, 590, BUTTON_WIDTH, BUTTON_HEIGHT);
        add(jbColumn4);
        
        add(new JLabel(""));

        jbQuit.addActionListener(this);
        jbGuess.addActionListener(this);
        jbHelp.addActionListener(this);
        jbColumn1.addActionListener(this);
        jbColumn2.addActionListener(this);
        jbColumn3.addActionListener(this);
        jbColumn4.addActionListener(this);
        
        startNewGame();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void clearRowData() {
		row = new int[4];
        for (int i = 0; i < row.length; i++) {
			row[i] = 0;
		}
	}

	private String getFilePath(String fileName) {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResource(fileName).getPath();
	}

	public void actionPerformed(ActionEvent event) {
		JButton clickedButton = (JButton) event.getSource();
		if (clickedButton == jbColumn1 || clickedButton == jbColumn2 
				|| clickedButton == jbColumn3 || clickedButton == jbColumn4) {

			int col = 3;
			if (clickedButton == jbColumn1) {
				col = 0;
			} else if (clickedButton == jbColumn2) {
				col = 1;
			} else if (clickedButton == jbColumn3) {
				col = 2;
			} else {
				col = 3;
			}
			
			row[col]++;

            if (row[col] == Board.NO_OF_COLORS+1) {
            	row[col] = 1;
            }

            String pegName = getFilePath("peg"+row[col]+".png"); 
            ImageIcon img = new ImageIcon(pegName);                    
            jlBoardColumn[curRowIndex][col].setIcon(img);                                       
		} else if (clickedButton == jbGuess) {
			makeGuess();
		}
	}
	
	private void showMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}

	private void makeGuess() {
		for (int i = 0; i < row.length; i++) {
			if (row[i] <= 0 || row[i] > Board.NO_OF_COLORS) {
				showMessage("Invalid guess.");
				return;
			}
		}
		
		GuessResult result = game.guess(row);
		jlRedPegs[curRowIndex].setText(result.getRedPegs()+"");
		jlRedPegs[curRowIndex].setVisible(true);
		jlWhitePegs[curRowIndex].setText(result.getWhitePegs()+"");
		jlWhitePegs[curRowIndex].setVisible(true);
		
		if (result.hasWon()) {
			showMessage("Congratulations!\nYou have guessed the correct color combination.");
			showAnswer();
			askPlayAgain();
		} else if (game.hasNextGuess()) {
			curRowIndex++;
			clearRowData();
		} else  {
			showMessage("Incorrect\nYou have not guessed the correct color combination.");
			showAnswer();
			askPlayAgain();
		}
	}

	private void askPlayAgain() {
		int selection = JOptionPane.showConfirmDialog(this,
                "Do you want to play again?",
                "Play again?",
                JOptionPane.YES_NO_OPTION);

        if (selection == JOptionPane.YES_OPTION) {
            startNewGame();
        } else if (selection == JOptionPane.NO_OPTION) {
            System.exit(0);
        }   
	}

	private void startNewGame() {
		String emptyPeg = getFilePath("peg0.png");
		// Set guess grid
        for (int i = 0; i < Board.MAX_GUESSES; i++) {
        	jlBoardColumn[i][0].setIcon(new ImageIcon(emptyPeg));
            jlBoardColumn[i][1].setIcon(new ImageIcon(emptyPeg));
            jlBoardColumn[i][2].setIcon(new ImageIcon(emptyPeg));
            jlBoardColumn[i][3].setIcon(new ImageIcon(emptyPeg));
        	
        	jlRedPegs[i].setText(0 + "");
        	jlRedPegs[i].setVisible(false);
            
        	jlWhitePegs[i].setText(0 + "");
        	jlWhitePegs[i].setVisible(false);
        }
        
        // Answer row
        for (int i = 0; i < 4; i++) {
            jlAnswer[i].setIcon(new ImageIcon(getFilePath("peg" + board.getAnswer().getRow()[i] + ".png"))); 
            jlAnswer[i].setVisible(false);
        }
        
        jlCorrect.setVisible(false);
        
        clearRowData();

        curRowIndex = 0;
	}

	private void showAnswer() {
		for (int i = 0; i < 4; i++) {
            jlAnswer[i].setVisible(true);
        }

        jlCorrect.setVisible(true);
	}
}
