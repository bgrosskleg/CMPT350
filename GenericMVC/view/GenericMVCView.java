package view;

import interfaces.GenericMVCModelSubscriber;

import javax.swing.JPanel;

import model.GenericMVCModel;
/**
 * contains:
 * 
 * protected methods:
 * GenericMVCView(GenericMVCModel)
 * 
 */
public abstract class GenericMVCView extends JPanel implements GenericMVCModelSubscriber
{
	private static final long serialVersionUID = 1L;

	protected final GenericMVCModel model;
	
/**
 * takes a model and adds the view created in buildPanel()
 * 
 * @param modelthe model to be added
 * @param model.addModelSubscriber(this) 
 */
	protected GenericMVCView(GenericMVCModel model)
	{
		this.model = model;
		this.model.addModelSubscriber(this);

		buildPanel();
	}

	protected abstract void buildPanel();
}

