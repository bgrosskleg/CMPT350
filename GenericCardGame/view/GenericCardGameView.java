package view;

import javax.swing.JLabel;

import model.GenericCardGameModel;

public abstract class GenericCardGameView extends GenericMVCView
{
	private static final long serialVersionUID = 1L;
			
	public int playerNumber;
	protected JLabel playerStatus;
	
	/**
	 * generate the view from the GenericMVCView and add playerNumbers
	 * 
	 * @param model this model
	 * @param playerNumber this playerNumber
	 */
	public GenericCardGameView(GenericCardGameModel model, int playerNumber) 
	{
		super(model);
		this.playerNumber = playerNumber;
	}
}
