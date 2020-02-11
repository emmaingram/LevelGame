/**
 * 
 * @author Emma Ingram
 * @author Braedon O'Callaghan
 *
 * This class creates the Stegosaurus piece that randomly
 * moves about the board and gives the player a prize
 * when they get within one space of the Stegosaurus.
 *
 * Stegosaurus is a moveable piece.
 *
 */

package levelPieces;

import java.util.Random;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;


public class Stegosaurus extends GamePiece implements Moveable{
	// keeps track of piece already in space
	private Drawable standingOn = null;
	// keeps track of whether player has already gotten prize from stegosaurus
	private boolean havePrize = true;
	
	// constructor
	public Stegosaurus(int location) {
		super('S', location);
	}

	// stegosaurus moves randomly about the board
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		gameBoard[getLocation()] = standingOn;
		Random random = new Random();
		int temp = random.nextInt(3) - 1;
		setLocation(getLocation() + (temp));
		if (!(gameBoard[getLocation()] instanceof Moveable)) {
			standingOn = gameBoard[getLocation()];
		} else {
			standingOn = null;
		}
		gameBoard[getLocation()] = this;
	}
	
	// prints symbol
	@Override
	public void draw() {
		System.out.print(super.getSymbol());
	}

	// player gets prize if within one space of stegosaurus
	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if((Math.abs(getLocation() - playerLocation) < 2) && havePrize){
			havePrize = false;
			return InteractionResult.GET_POINT;
		}
		
		return InteractionResult.NONE;
	}
	
}
