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
		this.shuffleCards();
	}
	
	public void shuffleCards()
	{
		//http://stackoverflow.com/questions/4228975/how-to-randomize-arraylist
		//shuffle is a static function inside java which takes a list and shuffles it randomly
		//Collections is a data type inside of java
		Collections.shuffle(cards);
	}
	
	public void sortCards()
	{
		//TODO  SORT CARDS SMALLEST TO LARGEST, ALTERNATING RED BLACK SUITS
	}
	
	public void showAllCards()
	{
		//TODO Flip all cards face up
	}
	
	public void hideAllCards()
	{
		//TODO Flip all cards face down
	}
	
	public boolean addCard(GenericCardGameCard card)
	{
		return cards.add(card);
	}
	
	public GenericCardGameCard removeCard(int index)
	{
		return cards.remove(index);
	}
	
	public boolean isEmpty()
	{
		return cards.isEmpty();
	}
	
	public int getListSize()
	{
		return cards.size();
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
