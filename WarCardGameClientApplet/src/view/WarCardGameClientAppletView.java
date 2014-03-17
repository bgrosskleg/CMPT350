package view;

import javax.swing.JPanel;

import model.WarPlayer;
/**
 * parameters:	serialVersionUID
 * methods:		none
 * 
 * to be explained..? 
 * the view the player can see in the browser window?
 */
public class WarCardGameClientAppletView extends GenericCardGameClientAppletView
{
	private static final long serialVersionUID = 1L;


	public WarCardGameClientAppletView(WarPlayer model) 
    {
		super(model);
		// TODO Auto-generated constructor stub
	}


	@Override
	protected JPanel generatePanel() 
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void modelChanged() 
	{
		// TODO Auto-generated method stub
		
	}

}
