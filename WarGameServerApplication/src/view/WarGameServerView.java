package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import model.GenericModel;

public class WarGameServerView extends GenericView
{
	private static final long serialVersionUID = 1L;

	public WarGameServerView(GenericModel model)
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
		
		
		
		return result;
	}
}
