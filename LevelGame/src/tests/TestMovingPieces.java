/**
 * 
 * @author Emma Ingram
 * @author Braedon O'Callaghan
 *
 * Tests if each piece moves how it should.
 * Note: We did not test out of bounds because of setLocation in GamePiece class.
 */

package tests;

import static org.junit.Assert.*;
import gameEngine.*;
import levelPieces.*;

import org.junit.Test;

import gameEngine.GameEngine;

public class TestMovingPieces {

	@Test
	public void testTRexMovement() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		// Assume player is in location 13, move trex and it should get closer to player
		TRex trex = new TRex(10);
		trex.move(gameBoard, 13);
		assertEquals(gameBoard[11], trex);
		// test on other side
		trex = new TRex(15);
		trex.move(gameBoard, 13);
		assertEquals(gameBoard[14], trex);
		// test on top of player - shouldn't move
		trex = new TRex(13);
		trex.move(gameBoard, 13);
		assertEquals(gameBoard[13], trex);
	}
	
	@Test
	public void testPterodactylMovement() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		// Assume player is in location 13, move pterodactyl and it should get further away to player
		Pterodactyl ptero = new Pterodactyl(10);
		ptero.move(gameBoard, 13);
		assertEquals(gameBoard[9], ptero);
		// test on other side
		ptero = new Pterodactyl(15);
		ptero.move(gameBoard, 13);
		assertEquals(gameBoard[16], ptero);
		// test on top of player - moves to the left
		ptero = new Pterodactyl(13);
		ptero.move(gameBoard, 13);
		assertEquals(gameBoard[12], ptero);
	}
	
	@Test
	public void testStegosaurusMovement() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		// variable to keep track of how far stegosaurus randomly moves
		int countNegativeOne = 0;
		int count0 = 0;
		int count1 = 0;
		Stegosaurus stego = new Stegosaurus(10);
		gameBoard[10] = stego;		
		// move stegosaurus 500 times and check if it moved in each direction
		for(int i=0; i<500; i++) {
			stego.move(gameBoard, 15);
			if(stego.getLocation() == 10) {
				count0++;
			} else if(stego.getLocation() == 9) {
				countNegativeOne++;
			} else if(stego.getLocation() == 11) {
				count1++;
			}
			stego = new Stegosaurus(10);
		}
		
		// checks if stegosaurus moved in each direction
		assert(countNegativeOne > 0);
		assert(count0 > 0);
		assert(count1 > 0);
	}

}
