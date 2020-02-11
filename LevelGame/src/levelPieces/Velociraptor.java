/**
 * 
 * @author Emma Ingram
 * @author Braedon O'Callaghan
 *
 * This class creates the Velociraptor piece
 * that does not move but hits the player
 * if he gets within one space of it.
 * Two hits kills the player
 *
 */

package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Velociraptor extends GamePiece{
	//constructor
	public Velociraptor(int location) {
		super('V', location);
	}
	
	//prints symbol
	@Override
	public void draw() {
		System.out.print(super.getSymbol());
	}

	// hits the player if within one space
	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if(Math.abs(playerLocation - super.getLocation()) < 2) {
			return InteractionResult.HIT;
		}
		
		return InteractionResult.NONE;
	}
	
}