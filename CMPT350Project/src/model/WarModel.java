package model;

import java.util.List;

import model.Card.Suit;
import model.Card.Value;

public class WarModel
{
	public Card[] deck;
	public PlayerModel p1, p2;
	public Card p1Card, p2Card;
	public List<Card> p1CardsWon, p2CardsWon,
	p1DrawDeck, p2DrawDeck;

	public WarModel()
	{
		/*
		 * Init deck
		 */
		deck = new Card[52];
		for(int i = 0; i<4; i++)
		{
			Suit suit = null;
			switch (i)
			{
			case 0 :
				suit = Suit.SPADE;
				break;
			case 1 :
				suit = Suit.HEART;
				break;
			case 2 :
				suit = Suit.CLUB;
				break;
			case 3 :
				suit = Suit.DIAMOND;
				break;
			}

			for(int j = 0; j<13; j++)
			{
				Value value = null;
				switch (j)
				{
				case 0 :
					value = Value.ONE;
					break;
				case 1 :
					value = Value.TWO;
					break;
				case 2 :
					value = Value.THREE;
					break;
				case 3 :
					value = Value.FOUR;
					break;
				case 4 :
					value = Value.FIVE;
					break;
				case 5 :
					value = Value.SIX;
					break;
				case 6 :
					value = Value.SEVEN;
					break;
				case 7 :
					value = Value.EIGHT;
					break;
				case 8 :
					value = Value.NINE;
					break;
				case 9 :
					value = Value.TEN;
					break;
				case 10 :
					value = Value.JACK;
					break;
				case 11 :
					value = Value.QUEEN;
					break;
				case 12 :
					value = Value.KING;
					break;
				}
				Card card = new Card(value,suit);
				deck[(13*i + j)] = card;

				/*
				 * Create Players
				 */
				p1 = new PlayerModel();
				p2 = new PlayerModel();
				
				/*
				 * Init all lists
				 */
				p1CardsWon = new LinkedList<Card>();
				p2CardsWon = new LinkedList<Card>();
				p1DrawDeck = new LinkedList<Card>();
				p2DrawDeck = new LinkedList<Card>();
			
			}
		}
	}
}

