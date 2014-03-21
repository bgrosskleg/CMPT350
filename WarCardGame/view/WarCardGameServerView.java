package view;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import model.WarCardGameModel;

public class WarCardGameServerView extends GenericCardGameView
{
	private static final long serialVersionUID = 1L;
	
	private JLabel playerStatus;

	public WarCardGameServerView(WarCardGameModel model)
	{
		super(model);
	}

	@Override
	protected void buildPanel() 
	{	
		this.setBackground(Color.RED);
		this.setPreferredSize(new Dimension(500,500));
		this.setMaximumSize(getPreferredSize());
		this.setMinimumSize(getPreferredSize());
		
		playerStatus = new JLabel("Waiting for " + (((WarCardGameModel)this.model).requiredNumberOfPlayers-((WarCardGameModel)model).getPlayers().size()) + " more players...");
		this.add(playerStatus);
	}

	@Override
	public void modelChanged() 
	{
		if(((WarCardGameModel)model).getPlayers().size() < ((WarCardGameModel)this.model).requiredNumberOfPlayers)
		{
			//Display waiting text
			playerStatus.setText("Waiting for " + (((WarCardGameModel)this.model).requiredNumberOfPlayers-((WarCardGameModel)model).getPlayers().size()) + " more players...");
		}
		else
		{
			//Display card game
			this.removeAll();
			
			this.setBackground(Color.GREEN);
			
			//Add board game view
			this.add(new WarCardGameBoardView((WarCardGameModel)this.model));
			
			this.revalidate();
		}
	}
}
