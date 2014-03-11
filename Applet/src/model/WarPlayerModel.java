package model;


public class WarPlayerModel extends Player{

	protected WarPlayerModel(String name) {
		super(name);
	}

	public static enum Dest
	 {
		HAND, WINPILE 
	 }
}
