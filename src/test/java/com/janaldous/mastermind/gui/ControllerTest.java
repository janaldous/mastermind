package com.janaldous.mastermind.gui;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import com.janaldous.mastermind.core.GuessResult;
import com.janaldous.mastermind.core.InvalidColorException;

public class ControllerTest {

	@Test
	public void testAskGameLevel() {
		View view = mock(View.class);
		Model model = mock(Model.class);
		when(view.askGameLevel()).thenReturn("3");
		Controller controller = new Controller(model, view);
		String level = controller.askGameLevel();
		assertEquals("HARD", level);
	}
	
	@Test
	public void testAskGameLevelEmptyString() {
		View view = mock(View.class);
		Model model = mock(Model.class);
		when(view.askGameLevel()).thenReturn("");
		Controller controller = new Controller(model, view);
		String level = controller.askGameLevel();
		assertEquals("ORIG", level);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAskGameLevelInvalidInput() {
		View view = mock(View.class);
		Model model = mock(Model.class);
		when(view.askGameLevel()).thenReturn("-");
		Controller controller = new Controller(model, view);
		controller.askGameLevel();
	}
	
	@Test
	public void testMakeInvalidGuess() throws InvalidColorException {
		View view = mock(View.class);
		when(view.askGameLevel()).thenReturn("1");
		Model model = mock(Model.class);
		when(model.hasNextGuess()).thenReturn(true);
		when(model.makeGuess()).thenThrow(new InvalidColorException("Invalid color"));
		Controller controller = new Controller(model, view);
		controller.makeGuess();
		verify(view, times(1)).showMessage("Invalid guess.");
	}
	
	@Test
	public void testMakeCorrectGuessThenShowMessage() throws InvalidColorException {
		View view = mock(View.class);
		when(view.askGameLevel()).thenReturn("1");
		Model model = mock(Model.class);
		when(model.hasNextGuess()).thenReturn(true)
			.thenReturn(false);
		when(model.makeGuess()).thenReturn(new GuessResult(1, 1, true));
		Controller controller = new Controller(model, view);
		controller.makeGuess();
		verify(view, times(1)).showMessage("Congratulations!\nYou have guessed the correct color combination.");
		verify(view, times(1)).showAnswer();
	}
	
	@Test
	public void testMakeIncorrectLastGuessThenShowMessage() throws InvalidColorException {
		View view = mock(View.class);
		when(view.askGameLevel()).thenReturn("1");
		Model model = mock(Model.class);
		when(model.hasNextGuess()).thenReturn(true)
			.thenReturn(false);
		when(model.makeGuess()).thenReturn(new GuessResult(1, 1, false));
		Controller controller = new Controller(model, view);
		controller.makeGuess();
		verify(view, times(1)).showMessage("Incorrect\nYou have not guessed the correct color combination.");
		verify(view, times(1)).showAnswer();
	}
}
