package test;

import static org.junit.Assert.*;
import main.TicTacToe;

import org.junit.Before;
import org.junit.Test;

public class TicTacToeTest {

	TicTacToe ticTacToe;

	@Before
	public void initializeTicTacToe()
	{
		ticTacToe=new TicTacToe();
	}

	@Test
	public void testGameStartsWithX()
	{
		assertEquals("{{-,-,-},{-,-,-},{-,-,X}}",ticTacToe.move(2, 2));	
	}

	@Test
	public void testXAndOPlayAlternately()
	{
		assertEquals("{{-,X,-},{-,-,-},{-,-,-}}",ticTacToe.move(0, 1));	
		assertEquals("{{-,X,O},{-,-,-},{-,-,-}}",ticTacToe.move(0, 2));
	}

	@Test
	public void testDuplicateMove()
	{
		assertEquals("{{-,X,-},{-,-,-},{-,-,-}}",ticTacToe.move(0, 1));	
		assertEquals("Position is already occupied.",ticTacToe.move(0, 1));
	}

	@Test
	public void testIsGameFinishedBeforeMove()
	{
		assertEquals("{{-,-,-},{X,-,-},{-,-,-}}",ticTacToe.move(1, 0));
		assertEquals("{{-,O,-},{X,-,-},{-,-,-}}",ticTacToe.move(0, 1));
		assertEquals("{{-,O,-},{X,X,-},{-,-,-}}",ticTacToe.move(1, 1));
		assertEquals("{{-,O,O},{X,X,-},{-,-,-}}",ticTacToe.move(0, 2));
		assertEquals("{{-,O,O},{X,X,X},{-,-,-}}",ticTacToe.move(1, 2));	
		assertEquals("Invalid move as game is already completed.",ticTacToe.move(0, 0));
	}

	@Test
	public void testReturnGameStatus()
	{
		assertEquals("{{-,-,-},{X,-,-},{-,-,-}}",ticTacToe.move(1, 0));
		assertEquals("{{-,-,O},{X,-,-},{-,-,-}}",ticTacToe.move(0, 2));
		assertEquals("{{-,-,O},{X,X,-},{-,-,-}}",ticTacToe.move(1, 1));
		assertEquals("Game is still in progress.",ticTacToe.returnGameStatus());
		assertEquals("{{-,-,O},{X,X,O},{-,-,-}}",ticTacToe.move(1, 2));
		assertEquals("{{X,-,O},{X,X,O},{-,-,-}}",ticTacToe.move(0, 0));	
		assertEquals("{{X,-,O},{X,X,O},{-,-,O}}",ticTacToe.move(2, 2));
		assertEquals("O is the winner.",ticTacToe.returnGameStatus());

		ticTacToe=new TicTacToe();
		assertEquals("{{X,-,-},{-,-,-},{-,-,-}}",ticTacToe.move(0, 0));
		assertEquals("{{X,-,-},{O,-,-},{-,-,-}}",ticTacToe.move(1, 0));
		assertEquals("{{X,X,-},{O,-,-},{-,-,-}}",ticTacToe.move(0, 1));
		assertEquals("{{X,X,-},{O,-,O},{-,-,-}}",ticTacToe.move(1, 2));
		assertEquals("{{X,X,X},{O,-,O},{-,-,-}}",ticTacToe.move(0, 2));
		assertEquals("X is the winner.",ticTacToe.returnGameStatus());

		ticTacToe=new TicTacToe();
		assertEquals("{{X,-,-},{-,-,-},{-,-,-}}",ticTacToe.move(0, 0));
		assertEquals("{{X,-,-},{O,-,-},{-,-,-}}",ticTacToe.move(1, 0));
		assertEquals("{{X,X,-},{O,-,-},{-,-,-}}",ticTacToe.move(0, 1));
		assertEquals("{{X,X,O},{O,-,-},{-,-,-}}",ticTacToe.move(0, 2));
		assertEquals("{{X,X,O},{O,-,-},{-,-,X}}",ticTacToe.move(2, 2));
		assertEquals("{{X,X,O},{O,O,-},{-,-,X}}",ticTacToe.move(1, 1));
		assertEquals("{{X,X,O},{O,O,X},{-,-,X}}",ticTacToe.move(1, 2));
		assertEquals("{{X,X,O},{O,O,X},{-,O,X}}",ticTacToe.move(2, 1));
		assertEquals("{{X,X,O},{O,O,X},{X,O,X}}",ticTacToe.move(2, 0));
		assertEquals("Drawn game.",ticTacToe.returnGameStatus());

		ticTacToe=new TicTacToe();
		assertEquals("{{X,-,-},{-,-,-},{-,-,-}}",ticTacToe.move(0, 0));
		assertEquals("{{X,-,-},{O,-,-},{-,-,-}}",ticTacToe.move(1, 0));
		assertEquals("{{X,X,-},{O,-,-},{-,-,-}}",ticTacToe.move(0, 1));
		assertEquals("{{X,X,O},{O,-,-},{-,-,-}}",ticTacToe.move(0, 2));
		assertEquals("{{X,X,O},{O,-,-},{-,-,X}}",ticTacToe.move(2, 2));
		assertEquals("{{X,X,O},{O,O,-},{-,-,X}}",ticTacToe.move(1, 1));
		assertEquals("{{X,X,O},{O,O,X},{-,-,X}}",ticTacToe.move(1, 2));
		assertEquals("{{X,X,O},{O,O,X},{O,-,X}}",ticTacToe.move(2, 0));
		assertEquals("O is the winner.",ticTacToe.returnGameStatus());
	}

}
