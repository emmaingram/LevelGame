/**
 * 
 * @author Emma Ingram
 * @author Braedon O'Callaghan
 *
 * This class creates the T-Rex piece that kills
 * the player if he is one space away from the T-Rex.
 *
 * T-Rex is a moveable piece.
 *
 */

package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class TRex extends GamePiece implements Moveable{
	// keep track of what piece is under T-Rex
	private Drawable standingOn = null;
	
	// constructor
	public TRex(int location) {
		super('R', location);
	}

	// T-Rex moves closer to player as player moves
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		gameBoard[getLocation()] = standingOn;
		
		if(getLocation() < playerLocation) {
			setLocation(getLocation()+1);
		} else if (getLocation() > playerLocation) {
			setLocation(getLocation()-1);
		}
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

	// kills player if one space away from T-Rex (doesn't kill if on top)
	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if(Math.abs(getLocation() - playerLocation) == 1) {
			return InteractionResult.KILL;
		}
		
		return InteractionResult.NONE;
	}
	
}
