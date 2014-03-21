package view;

import model.GenericCardGameModel;

public abstract class GenericCardGameView extends GenericMVCView
{
	private static final long serialVersionUID = 1L;

	protected enum State
	{
		WAITING, READY;
	}
	
	protected State state;
	
	public GenericCardGameView(GenericCardGameModel model) 
	{
		super(model);
		this.state = GenericCardGameView.State.WAITING;
	}
}
