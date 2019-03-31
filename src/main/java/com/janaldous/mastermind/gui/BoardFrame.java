package com.janaldous.mastermind.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class BoardFrame extends JFrame {

	/**
	 *  
	 */
	private static final long serialVersionUID = 6198815571510192882L;
	
	private static final int FRAME_WIDTH    = 450;
    private static final int FRAME_HEIGHT   = 740;
    
    private BoardPanel boardPanel;
    private ButtonPanel buttonPanel;
    
	public BoardFrame(String title, BoardPanel jpPanel, ButtonPanel jpButton) {
		this.boardPanel = jpPanel;
		this.buttonPanel = jpButton;
		setLayout(new BorderLayout());
		
		setTitle(title);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);

        add(boardPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.PAGE_END);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
