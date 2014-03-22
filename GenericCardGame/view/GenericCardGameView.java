package view;

import javax.swing.JLabel;

import model.GenericCardGameModel;

public abstract class GenericCardGameView extends GenericMVCView
{
	private static final long serialVersionUID = 1L;

	protected enum State
	{
		WAITING, READY;
	}
		
	protected State state;
	protected JLabel playerStatus;
	
	public int playerNumber;
	
	public GenericCardGameView(GenericCardGameModel model, int playerNumber) 
	{
		super(model);
		this.playerNumber = playerNumber;
		this.state = GenericCardGameView.State.WAITING;
	}
}
