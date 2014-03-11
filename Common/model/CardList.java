package model;

import java.util.ArrayList;
import java.util.Collections;

public class CardList extends ArrayList<Card>
{
	private static final long serialVersionUID = 1L;

	public void shuffle()
	{
		//http://stackoverflow.com/questions/4228975/how-to-randomize-arraylist
		Collections.shuffle(this);
	}
}