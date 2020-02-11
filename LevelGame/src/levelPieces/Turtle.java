/**
 * 
 * @author Emma Ingram
 * @author Braedon O'Callaghan
 *
 * This class creates the Turtle piece
 * which implements Drawable. He does not
 * move and gets scared and hides in his shell
 * when too many dinosaurs come out.
 *
 */

package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Turtle implements Drawable {
	private char symbol;
	
	// constructor
	public Turtle() {
		this.symbol = 'T';
	}

	// prints symbol
	@Override
	public void draw() {
		System.out.print(symbol);
	}

}
