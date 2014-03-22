package view;

import javax.swing.*;

import java.awt.*;

import model.WarCardGameModel;

public class WarCardGameClientAppletView extends GenericCardGameView
{
	private static final long serialVersionUID = 1L;

	public WarCardGameClientAppletView(WarCardGameModel model) 
    {
		super(model, 0);
	}
    
	@Override
	protected void buildPanel() 
	{			
		this.setBackground(Color.YELLOW);
		this.setPreferredSize(new Dimension(500,500));
		this.setMaximumSize(getPreferredSize());
		this.setMinimumSize(getPreferredSize());
		
		this.playerStatus = new JLabel("Waiting for " + (((WarCardGameModel)this.model).requiredNumberOfPlayers - ((WarCardGameModel)model).getPlayers().size()) + " more players...");
		this.add(playerStatus);
	}


	@Override
	public void modelChanged() 
	{
		System.out.println("MODEL CHANGED");
		
		if(this.state.equals(GenericCardGameView.State.WAITING))
		{
			if(((WarCardGameModel)model).getPlayers().size() < ((WarCardGameModel)this.model).requiredNumberOfPlayers)
			{				
				//Display waiting text
				this.playerStatus.setText("Waiting for " + (((WarCardGameModel)this.model).requiredNumberOfPlayers - ((WarCardGameModel)model).getPlayers().size()) + " more players...");
			}
			else if(((WarCardGameModel)model).getPlayers().size() == ((WarCardGameModel)this.model).requiredNumberOfPlayers)
			{
				this.state = GenericCardGameView.State.READY;
				
				//Remove waiting label
				this.removeAll();
				
				//Green pepper from http://www.december.com/html/spec/color2.html
				this.setBackground(new Color(0x39, 0x7D, 0x02));
				
				//Add the game board view
				this.add(new WarCardGameBoardView((WarCardGameModel)this.model, playerNumber));
								
				this.revalidate();
				
			}
			else
			{
				new Exception("Impossible state, more players than required").printStackTrace();
			}
		}

		if(this.state.equals(GenericCardGameView.State.READY))
		{
			if(((WarCardGameModel)model).getPlayers().size() < ((WarCardGameModel)this.model).requiredNumberOfPlayers)
			{				
				this.state = GenericCardGameView.State.WAITING;
				
				this.removeAll();
				
				this.setBackground(Color.YELLOW);
				
				//Display waiting text
				playerStatus.setText("Waiting for " + (((WarCardGameModel)this.model).requiredNumberOfPlayers - ((WarCardGameModel)model).getPlayers().size()) + " more players...");
				this.add(playerStatus);
				
				this.revalidate();
			}
			else
			{
				this.repaint();
			}
		}
	}
}
