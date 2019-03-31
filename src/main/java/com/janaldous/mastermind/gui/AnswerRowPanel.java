package com.janaldous.mastermind.gui;

import javax.swing.JLabel;

public class AnswerRowPanel extends AbstractRowPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel jlCorrect;

	public AnswerRowPanel() {
		super();

		jlCorrect = new JLabel();
		jlCorrect.setText("< Correct code");
		
		for (int i = 0; i < jlRow.length; i++) {
			add(jlRow[i]);
		}
		add(jlCorrect);
	}

}
