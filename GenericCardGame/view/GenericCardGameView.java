package view;

import javax.swing.JLabel;

import model.GenericCardGameModel;

public abstract class GenericCardGameView extends GenericMVCView
{
	private static final long serialVersionUID = 1L;
			
	public int playerNumber;
	protected JLabel playerStatus;
	
	public GenericCardGameView(GenericCardGameModel model, int playerNumber) 
	{
		super(model);
		this.playerNumber = playerNumber;
	}
}
