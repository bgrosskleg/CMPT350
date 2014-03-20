 package model;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import controller.GenericCardGameSocketWorker;
import model.GenericCardGameCard;
import model.GenericCardGameCardList;

public abstract class GenericCardGamePlayer extends GenericMVCModel
{
	private static final long serialVersionUID = 1L;

	//private GenericCardGameCardList hand;
	 
	protected transient GenericCardGameSocketWorker socketWorker;

	protected GenericCardGamePlayer(GenericCardGameSocketWorker socketWorker)
	{
		super();
		
		this.socketWorker = socketWorker;

		//this.hand = new GenericCardGameCardList(); 
	}

	public GenericCardGameCardList getHand() 
	{
		return null;
	}

	public GenericCardGameSocketWorker getSocketWorker() 
	{
		return socketWorker;
	}

	/*public JPanel generateHandView()
	{
		JPanel result = new JPanel();

		result.setLayout(new BoxLayout(result, BoxLayout.LINE_AXIS));

		hand.sort();

		for(GenericCardGameCard card : hand)
		{
			result.add(card);
		}

		return result;
	}*/
}