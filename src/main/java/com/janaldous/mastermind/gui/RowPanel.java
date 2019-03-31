package com.janaldous.mastermind.gui;

import java.awt.Color;

import javax.swing.JLabel;

public class RowPanel extends AbstractRowPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel jlRedPegs;
	private JLabel jlWhitePegs;

	public RowPanel() {
		jlRedPegs = new JLabel();
		jlRedPegs.setText(0 + "");
		jlRedPegs.setForeground(Color.RED);

		jlWhitePegs = new JLabel();
		jlWhitePegs.setText(0 + "");
		
		add(jlRedPegs);
		add(jlRow[0]);
		add(jlRow[1]);
		add(jlRow[2]);
		add(jlRow[3]);
		add(jlWhitePegs);
	}

	public void setGuessResult(int redPegs, int whitePegs) {
		jlRedPegs.setText(redPegs + "");
		jlWhitePegs.setText(whitePegs + "");
	}
	
	@Override
	public void reset() {
		super.reset();
		setGuessResult(0, 0);
	}
}
