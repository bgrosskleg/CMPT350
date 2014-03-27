package view;

import java.awt.Color;

import javax.swing.JLabel;

import model.GenericMVCModel;
import model.WarCardGameModel;
/**
 * contains:
 * 
 * public methods:
 * modelChanged()
 * buildPanel()
 * 
 * protected methods:
 * GenericCardGameWaitingForPlayersView(GenericMVCModel) 
 */
public class GenericCardGameWaitingForPlayersView extends GenericMVCView
{
	private static final long serialVersionUID = 1L;
	
	private JLabel waitingStatus;
	
	/**
	 * gets the waiting status, required number of players, and number of players from the model
	 * 
	 * @param model gets the model generated from the GenericMVCView class
	 */
	protected GenericCardGameWaitingForPlayersView(GenericMVCModel model) 
	{
		super(model);
		this.waitingStatus = new JLabel("Waiting for " + (((WarCardGameModel)this.model).getRequiredNumberOfPlayers() - ((WarCardGameModel)model).getPlayers().size()) + " more players...");
	}
	
	/**
	 * checks to see if the waitingStatus has changed
	 */
	@Override
	public void modelChanged() 
	{
		this.waitingStatus.setText("Waiting for " + (((WarCardGameModel)this.model).getRequiredNumberOfPlayers() - ((WarCardGameModel)model).getPlayers().size()) + " more players...");		
	}

	/**
	 * builds the basic background and adds the waiting status to the panel
	 */
	@Override
	public void buildPanel() 
	{
		this.setBackground(Color.RED);
		
		this.add(waitingStatus);
	}

}
