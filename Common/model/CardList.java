package model;

import java.util.ArrayList;
import java.util.Collections;

public class CardList extends ArrayList<Card>
{
	private static final long serialVersionUID = 1L;

	public CardList()
	{
		super();
		this.shuffle();
	}
	
	public void shuffle()
	{
		//http://stackoverflow.com/questions/4228975/how-to-randomize-arraylist
		//shuffle is a static function inside java which takes a list and shuffles it randomly
		//Collections is a data type inside of java
		Collections.shuffle(this);
	}
	
	public void organize()
	{
		//TODO  ORDER CARDS SMALLEST TO LARGEST, ALTERNATING RED BLACK SUITS
	}
	
	public void showAll()
	{
		//TODO Flip all cards face up
	}
	
	public void hideAll()
	{
		//TODO Flip all cards face down
	}
}
