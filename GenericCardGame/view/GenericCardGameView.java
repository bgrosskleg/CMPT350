package view;

import model.GenericCardGameModel;

public abstract class GenericCardGameView extends GenericMVCView
{
	private static final long serialVersionUID = 1L;

	public GenericCardGameView(GenericCardGameModel model) 
	{
		super(model);
	}
}
