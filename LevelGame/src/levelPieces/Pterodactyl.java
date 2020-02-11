/**
 * 
 * @author Emma Ingram
 * @author Braedon O'Callaghan
 *
 * This class creates the Pterodactyl piece which flies
 * away from the player but if the player catches up to
 * the Pterodactyl he wins a point.
 *
 * Pterodactyl is a moveable piece.
 *
 */

package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;


public class Pterodactyl extends GamePiece implements Moveable{
	// keep track of what piece pterodactyl is standing on
	private Drawable standingOn = null;
	// keep track of if player has won prize from pterodactyl already
	private boolean havePrize = true;
	
	//constructor
	public Pterodactyl(int location) {
		super('p', location);
	}

	// moves piece away from player
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		gameBoard[getLocation()] = standingOn;
		if(getLocation() > playerLocation) {
			setLocation(getLocation()+1);
		} else {
			setLocation(getLocation()-1);
		}
		if (!(gameBoard[getLocation()] instanceof Moveable)) {
			standingOn = gameBoard[getLocation()];
		} else {
			standingOn = null;
		}
		gameBoard[getLocation()] = this;
	}
	
	//prints symbol
	@Override
	public void draw() {
		System.out.print(super.getSymbol());
	}

	// gives player a point if comes within one space of pterodactyl
	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if((Math.abs(getLocation() - playerLocation) < 2) && havePrize){
			havePrize = false;
			return InteractionResult.GET_POINT;
		}
		
		return InteractionResult.NONE;
	}
	
}
