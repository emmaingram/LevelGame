/**
 * 
 * @author Emma Ingram
 * @author Braedon O'Callaghan
 *
 * This class creates the Brachiosaurus piece
 * which advances the player to the next level
 * when he lands on it.
 *
 */

package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Brachiosaurus extends GamePiece{
	
	// contructor
	public Brachiosaurus(int location) {
		super('B', location);
	}
	
	//prints out symbol
	@Override
	public void draw() {
		System.out.print(super.getSymbol());
	}

	//advances player to next level if on same space as Brachiosaurus
	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if(super.getLocation() == playerLocation) {
			return InteractionResult.ADVANCE;
		}
		
		return InteractionResult.NONE;
	}
	
}