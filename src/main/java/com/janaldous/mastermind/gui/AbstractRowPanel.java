package com.janaldous.mastermind.gui;

import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AbstractRowPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected JLabel jlRow[];

	public AbstractRowPanel() {
		super();
		init();
	}

	public AbstractRowPanel(LayoutManager layout) {
		super(layout);
		init();
	}

	public AbstractRowPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		init();
	}

	public AbstractRowPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		init();
	}
	
	private void init() {
		jlRow = new JLabel[4];
		
		String emptyPeg = getPegFilename(0);
		for (int i = 0; i < jlRow.length; i++) {
			jlRow[i] = new JLabel(new ImageIcon(emptyPeg));
		}
	}

	protected String getPegFilename(int num) {
		return getFilePath("peg" + num + ".png");
	}

	private String getFilePath(String fileName) {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResource(fileName).getPath();
	}

	public void setColor(int columnIndex, int color) {
		String pegName = getPegFilename(color);
		ImageIcon img = new ImageIcon(pegName);
		jlRow[columnIndex].setIcon(img);
	}

	public void reset() {
		for (int i = 0; i < jlRow.length; i++) {
			setColor(i, 0);
		}
	}

}