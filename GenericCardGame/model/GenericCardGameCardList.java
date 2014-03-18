package model;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;

public class GenericCardGameCardList extends JPanel implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private ArrayList<GenericCardGameCard> cards;

	public GenericCardGameCardList()
	{
		super();
		cards = new ArrayList<GenericCardGameCard>();
		this.shuffle();
	}
	
	public void shuffle()
	{
		//http://stackoverflow.com/questions/4228975/how-to-randomize-arraylist
		//shuffle is a static function inside java which takes a list and shuffles it randomly
		//Collections is a data type inside of java
		Collections.shuffle(cards);
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
	
	public boolean add(GenericCardGameCard card)
	{
		return cards.add(card);
	}
	
	public boolean remove(GenericCardGameCard card)
	{
		return cards.remove(card);
	}
	
	public boolean isEmpty()
	{
		return cards.isEmpty();
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
			
		if(cards.size() > 0)
		{
			//Paint top card
			cards.get(0).paint(g2);
		}
		
		g2.drawString(String.valueOf(cards.size()), 30, 100);
	}
}
