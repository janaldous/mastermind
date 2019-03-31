package com.janaldous.mastermind;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.janaldous.mastermind.core.BoardTest;
import com.janaldous.mastermind.core.GameSettingsTest;
import com.janaldous.mastermind.core.GameTest;
import com.janaldous.mastermind.gui.ControllerTest;
import com.janaldous.mastermind.gui.ModelTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
   GameTest.class,
   GameSettingsTest.class,
   ModelTest.class,
   ControllerTest.class,
   BoardTest.class
})
public class MastermindTestSuite {

}
