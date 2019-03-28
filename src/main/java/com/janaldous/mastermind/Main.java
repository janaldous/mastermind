package com.janaldous.mastermind;

import com.janaldous.mastermind.gui.Controller;
import com.janaldous.mastermind.gui.Model;
import com.janaldous.mastermind.gui.View;

public class Main {
	
	public static void main(String[] args) {
//		GameSettings settings = new GameSettings(new LevelSettingsFactory().getLevelSettings("EASY"), new int[] {1,2,3,4});
		Model m = new Model();
		View v = new View("Mastermind");
		Controller c = new Controller(m, v);
		c.initController();
	}
}
