package model;

/**
 * parameters: 
 * methods:		WarPlayerModel(String) //constructor
 * 				Dest 
 *
 */
public class WarPlayerModel extends Player{

	/**
	 * @param name:	the username the player has chosen
	 * 
	 */
	protected WarPlayerModel(String name) {
		super(name);
	}
	
	/**
	 * contains a CardList of cards the player has in their hand
	 * contains a CardList of cards the player has won that are not in their hand 
	 */
	public static enum Dest
	 {
		HAND, WINPILE 
	 }
}
