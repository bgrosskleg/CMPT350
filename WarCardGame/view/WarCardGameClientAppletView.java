package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import model.WarCardGameModel;
/**
 * parameters:	serialVersionUID
 * methods:		none
 * 
 * to be explained..? 
 * the view the player can see in the browser window?
 */
public class WarCardGameClientAppletView extends GenericCardGameView
{
	private static final long serialVersionUID = 1L;


	public WarCardGameClientAppletView(WarCardGameModel model) 
    {
		super(model);
		// TODO Auto-generated constructor stub
	}


	@Override
	protected JPanel generatePanel() 
	{
		JPanel result = new JPanel();
		
		result.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		result.setBackground(Color.BLUE);
		result.setPreferredSize(new Dimension(500,500));
		result.setMaximumSize(getPreferredSize());
		result.setMinimumSize(getPreferredSize());
		
		return result;
	}


	@Override
	public void modelChanged() 
	{
		// TODO Auto-generated method stub
		
	}

}
