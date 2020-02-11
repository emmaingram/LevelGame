/**
 * 
 * @author Emma Ingram
 * @author Braedon O'Callaghan
 *
 * This class creates the levels and game board
 * for each level.
 *
 */

package levelPieces;
import java.util.ArrayList;

import gameEngine.Drawable;
import gameEngine.Moveable;

public class LevelEngine {
	// variables to keep track of game board, pieces that move, and pieces that interact with the player
	final private int BOARD_SIZE = 21;
	private Drawable [] currentBoard;
	private ArrayList<Moveable> moveablePieces;
	private ArrayList<GamePiece> interactingPieces;
	private int playerStartLoc;
	
	// constructor
	public LevelEngine () {
		currentBoard = new Drawable [BOARD_SIZE];
		moveablePieces = new ArrayList<Moveable>();
		interactingPieces = new ArrayList<GamePiece>();
	}
	
	// returns current game board
	public Drawable [] getBoard() {
		return currentBoard;
	}
	
	// returns moveable pieces on game board
	public ArrayList<Moveable> getMovingPieces () {
		return moveablePieces;
	}
	
	// returns interacting pieces on game board
	public ArrayList<GamePiece> getInteractingPieces () {
		return interactingPieces;
	}
	
	// get starting location of player
	public int getPlayerStartLoc() {
		return playerStartLoc;
	}
	
	// calls functions for levels 1 and 2
	public void createLevel(int levelNumber) {
		if (levelNumber == 1) {
			level1();
		} else if (levelNumber == 2) {
			level2();
		}
	}  
	
	// sets up level 1
	public void level1() {
		currentBoard = new Drawable [BOARD_SIZE];
		moveablePieces = new ArrayList<Moveable>();
		interactingPieces = new ArrayList<GamePiece>();
		
		//player starts in middle of the board
		playerStartLoc = BOARD_SIZE / 2;
		
		// board contains a turtle, trex, pterodactyl, velociraptor, stegosaurus, and brachiosaurus
		Turtle turtle = new Turtle();
		currentBoard[5] = turtle;
		TRex tRex = new TRex (3);
		Pterodactyl pterodac = new Pterodactyl(15);
		Velociraptor veloci = new Velociraptor(12);
		Stegosaurus stego = new Stegosaurus(7);
		Brachiosaurus brachio = new Brachiosaurus(1);
		
		// adds game game pieces to an array list to add to game board
		ArrayList<GamePiece> Dinos = new ArrayList<GamePiece>();
		Dinos.add(tRex);
		Dinos.add(pterodac);
		Dinos.add(veloci);
		Dinos.add(brachio);
		Dinos.add(stego);
		
		// adds game pieces to game board
		for (GamePiece dino : Dinos) {
			currentBoard[dino.getLocation()] = dino;
			interactingPieces.add((GamePiece)dino);
		}

		// adds moveable pieces to array list
		moveablePieces.add((Moveable) currentBoard[pterodac.getLocation()]);
		moveablePieces.add((Moveable) currentBoard[tRex.getLocation()]);
		moveablePieces.add((Moveable) currentBoard[stego.getLocation()]);
		
	}
	
	// sets up level 2
	public void level2() {
		currentBoard = new Drawable [BOARD_SIZE];
		moveablePieces = new ArrayList<Moveable>();
		interactingPieces = new ArrayList<GamePiece>();
		
		// player starts at index 1
		playerStartLoc = 1;
		
		// board contains a turtle, trex, pterodactyl, 2 velociraptors, stegosaurus, and brachiosaurus
		Turtle turtle = new Turtle();
		currentBoard[1] = turtle;
		TRex tRex1 = new TRex (10);
		TRex tRex2 = new TRex (16);
		Pterodactyl pterodac = new Pterodactyl(15);
		Velociraptor veloci1 = new Velociraptor(9);
		Stegosaurus stego = new Stegosaurus(13);
		Brachiosaurus brachio = new Brachiosaurus(BOARD_SIZE - 1);
		
		// adds game pieces to array list to add to game board
		ArrayList<GamePiece> Dinos = new ArrayList<GamePiece>();
		Dinos.add(tRex1);
		Dinos.add(tRex2);
		Dinos.add(pterodac);
		Dinos.add(veloci1);
		Dinos.add(brachio);
		Dinos.add(stego);
		
		// adds pieces to game board
		for (GamePiece dino : Dinos) {
			currentBoard[dino.getLocation()] = dino;
			interactingPieces.add((GamePiece)dino);
		}

		// adds pieces to moveable array list
		moveablePieces.add((Moveable) currentBoard[pterodac.getLocation()]);
		moveablePieces.add((Moveable) currentBoard[tRex1.getLocation()]);
		moveablePieces.add((Moveable) currentBoard[tRex2.getLocation()]);
		moveablePieces.add((Moveable) currentBoard[stego.getLocation()]);
		
		
	}
}
