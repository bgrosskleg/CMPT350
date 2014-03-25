package view;

import java.awt.Color;

import javax.swing.JLabel;

import model.GenericMVCModel;
import model.WarCardGameModel;

public class GenericCardGameWaitingForPlayersView extends GenericMVCView
{
	private static final long serialVersionUID = 1L;
	
	private JLabel waitingStatus;
	
	protected GenericCardGameWaitingForPlayersView(GenericMVCModel model) 
	{
		super(model);
		this.waitingStatus = new JLabel("Waiting for " + (((WarCardGameModel)this.model).getRequiredNumberOfPlayers() - ((WarCardGameModel)model).getPlayers().size()) + " more players...");
	}

	@Override
	public void modelChanged() 
	{
		this.waitingStatus.setText("Waiting for " + (((WarCardGameModel)this.model).getRequiredNumberOfPlayers() - ((WarCardGameModel)model).getPlayers().size()) + " more players...");		
	}

	@Override
	public void buildPanel() 
	{
		this.setBackground(Color.RED);
		
		this.add(waitingStatus);
	}

}
