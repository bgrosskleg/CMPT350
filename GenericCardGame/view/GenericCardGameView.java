package view;

import javax.swing.JLabel;

import controller.GenericCardGameSocketWorker;
import model.GenericCardGameModel;

public abstract class GenericCardGameView extends GenericMVCView
{
	private static final long serialVersionUID = 1L;
			
	public final GenericCardGameSocketWorker socketWorker;
	protected JLabel playerStatus;
	
	/**
	 * generate the view from the GenericMVCView and add playerNumbers
	 * 
	 * @param model this model
	 * @param playerNumber this playerNumber
	 */
	public GenericCardGameView(GenericCardGameModel model, GenericCardGameSocketWorker socketWorker) 
	{
		super(model);
		this.socketWorker = socketWorker;
	}
}
