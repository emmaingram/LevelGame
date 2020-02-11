/**
 * 
 * @author Emma Ingram
 * @author Braedon O'Callaghan
 *
 * Tests to make sure all dinos interact correctly 
 *
 */

package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import gameEngine.*;
import levelPieces.*;


public class TestInteractions {

	@Test
	public void testTRex() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		TRex trex = new TRex(10);
		gameBoard[10] = trex;
		// kills if player is one space away, but not on same space
		assertEquals(InteractionResult.KILL, trex.interact(gameBoard, 9));
		assertEquals(InteractionResult.NONE, trex.interact(gameBoard, 10));
		assertEquals(InteractionResult.KILL, trex.interact(gameBoard, 11));
		for (int i =0; i < GameEngine.BOARD_SIZE; i++) {
			if (i == 9 || i == 10 || i == 11) {
				continue;
			}
			assertEquals(InteractionResult.NONE, trex.interact(gameBoard, i));
		}
	}
	
	@Test
	public void testBrachiosaurus() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Brachiosaurus brach = new Brachiosaurus(10);
		gameBoard[10] = brach;
		// Advances player to next level if they are on the same square
		assertEquals(InteractionResult.ADVANCE, brach.interact(gameBoard, 10));
		for (int i =0; i < GameEngine.BOARD_SIZE; i++) {
			if (i == 10) {
				continue;
			}
			assertEquals(InteractionResult.NONE, brach.interact(gameBoard, i));
		}
	}
	@Test
	public void testPterodactyl() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Pterodactyl ptero = new Pterodactyl(10);
		gameBoard[10] = ptero;
		// gives player a prize if they are less than 2 spaces away, only gives prize once
		assertEquals(InteractionResult.GET_POINT, ptero.interact(gameBoard, 9));
		assertEquals(InteractionResult.NONE, ptero.interact(gameBoard, 9));
		ptero = new Pterodactyl(10);
		assertEquals(InteractionResult.GET_POINT, ptero.interact(gameBoard, 10));
		assertEquals(InteractionResult.NONE, ptero.interact(gameBoard, 10));
		ptero = new Pterodactyl(10);
		assertEquals(InteractionResult.GET_POINT, ptero.interact(gameBoard, 11));
		assertEquals(InteractionResult.NONE, ptero.interact(gameBoard, 11));
		for (int i =0; i < GameEngine.BOARD_SIZE; i++) {
			if (i == 9 || i == 10 || i == 11) {
				continue;
			}
			assertEquals(InteractionResult.NONE, ptero.interact(gameBoard, i));
		}
	}
	
	@Test
	public void testStegosaurus() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Stegosaurus stego = new Stegosaurus(10);
		gameBoard[10] = stego;
		// gives player a prize if they are less than 2 spaces away, only gives prize once
		assertEquals(InteractionResult.GET_POINT, stego.interact(gameBoard, 9));
		assertEquals(InteractionResult.NONE, stego.interact(gameBoard, 9));
		stego = new Stegosaurus(10);
		assertEquals(InteractionResult.GET_POINT, stego.interact(gameBoard, 10));
		assertEquals(InteractionResult.NONE, stego.interact(gameBoard, 10));
		stego = new Stegosaurus(10);
		assertEquals(InteractionResult.GET_POINT, stego.interact(gameBoard, 11));
		assertEquals(InteractionResult.NONE, stego.interact(gameBoard, 11));
		for (int i =0; i < GameEngine.BOARD_SIZE; i++) {
			if (i == 9 || i == 10 || i == 11) {
				continue;
			}
			assertEquals(InteractionResult.NONE, stego.interact(gameBoard, i));
		}
	}
	
	@Test
	public void testVelociraptor() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Velociraptor velo = new Velociraptor(10);
		gameBoard[10] = velo;
		// hits player if they are less than 2 spaces away
		assertEquals(InteractionResult.HIT, velo.interact(gameBoard, 9));
		assertEquals(InteractionResult.HIT, velo.interact(gameBoard, 10));
		assertEquals(InteractionResult.HIT, velo.interact(gameBoard, 11));
		for (int i =0; i < GameEngine.BOARD_SIZE; i++) {
			if (i == 9 || i == 10 || i == 11) {
				continue;
			}
			assertEquals(InteractionResult.NONE, velo.interact(gameBoard, i));
		}
	}

}
