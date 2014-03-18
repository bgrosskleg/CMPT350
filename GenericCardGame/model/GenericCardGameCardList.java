package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class GenericCardGameCardList extends ArrayList<GenericCardGameCard> implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	public GenericCardGameCardList()
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
	
	public void sort()
	{
		//TODO  SORT CARDS SMALLEST TO LARGEST, ALTERNATING RED BLACK SUITS
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
