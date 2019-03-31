package com.janaldous.mastermind.gui;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton jbHelp;
	private JButton jbQuit;
	private JButton jbGuess;
	private JButton jbColumn1Up;
	private JButton jbColumn2Up;
	private JButton jbColumn3Up;
	private JButton jbColumn4Up;
	private JButton jbColumn1Down;
	private JButton jbColumn2Down;
	private JButton jbColumn3Down;
	private JButton jbColumn4Down;

	public ButtonPanel() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		jbColumn1Up = new JButton("1+");
		jbColumn2Up = new JButton("2+");
		jbColumn3Up = new JButton("3+");
		jbColumn4Up = new JButton("4+");
		
		jbGuess = new JButton("Guess");
		jbColumn1Down = new JButton("1-");
		jbColumn2Down = new JButton("2-");
		jbColumn3Down = new JButton("3-");
		jbColumn4Down = new JButton("4-");
		
		jbQuit = new JButton("Quit");
		jbHelp = new JButton("Help");
		
		JPanel row1 = new JPanel();
		row1.add(jbColumn1Up);
		row1.add(jbColumn2Up);
		row1.add(jbColumn3Up);
		row1.add(jbColumn4Up);
		row1.add(jbGuess);
		
		JPanel row2 = new JPanel();
		row2.add(jbColumn1Down);
		row2.add(jbColumn2Down);
		row2.add(jbColumn3Down);
		row2.add(jbColumn4Down);
		
		JPanel row3 = new JPanel();
		row3.add(jbQuit);
		row3.add(jbHelp);
		
		add(row1);
		add(row2);
		add(row3);
	}

	public JButton getPeg1Button() {
		return jbColumn1Up;
	}
	
	public JButton getPeg2Button() {
		return jbColumn2Up;
	}
	
	public JButton getPeg3Button() {
		return jbColumn3Up;
	}
	
	public JButton getPeg4Button() {
		return jbColumn4Up;
	}

	/**
	 * @return the jbColumn1Down
	 */
	public JButton getJbColumn1Down() {
		return jbColumn1Down;
	}

	/**
	 * @return the jbColumn2Down
	 */
	public JButton getJbColumn2Down() {
		return jbColumn2Down;
	}

	/**
	 * @return the jbColumn3Down
	 */
	public JButton getJbColumn3Down() {
		return jbColumn3Down;
	}

	/**
	 * @return the jbColumn4Down
	 */
	public JButton getJbColumn4Down() {
		return jbColumn4Down;
	}

	public JButton getJbGuess() {
		return jbGuess;
	}
}
