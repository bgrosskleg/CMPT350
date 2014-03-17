package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.WarCardGameModel;

public class WarCardGameServerView extends GenericCardGameServerView
{
	private static final long serialVersionUID = 1L;

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
		
		result.add(new JLabel("Number of Players: " + ((WarCardGameModel)model).getPlayers().size()));
		
		
		
		return result;
	}

	@Override
	public void modelChanged() 
	{
		if(((WarCardGameModel)model).getPlayers().size() > 0)
		{
			panel.setBackground(Color.GREEN);
		}
	}
}
