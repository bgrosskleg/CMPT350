package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

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
	protected JPanel generatePanel() 
	{
		JPanel result = new JPanel();
		
		result.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		result.setBackground(Color.RED);
		result.setPreferredSize(new Dimension(500,500));
		result.setMaximumSize(getPreferredSize());
		result.setMinimumSize(getPreferredSize());
		
		playerStatus = new JLabel("Waiting for " + (((WarCardGameModel)this.model).requiredNumberOfPlayers-((WarCardGameModel)model).getPlayers().size()) + " more players...");
		result.add(playerStatus);
				
		return result;
	}

	@Override
	public void modelChanged() 
	{
		if(((WarCardGameModel)model).getPlayers().size() < ((WarCardGameModel)this.model).requiredNumberOfPlayers)
		{
			playerStatus.setText("Waiting for " + (((WarCardGameModel)this.model).requiredNumberOfPlayers-((WarCardGameModel)model).getPlayers().size()) + " more players...");
		}
		else
		{
			this.panel.remove(playerStatus);
			this.panel.setBackground(Color.GREEN);
		}
	}
}
