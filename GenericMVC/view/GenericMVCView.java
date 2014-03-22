package view;

import interfaces.GenericMVCModelSubscriber;

import javax.swing.JPanel;

import model.GenericMVCModel;

public abstract class GenericMVCView extends JPanel implements GenericMVCModelSubscriber
{
	private static final long serialVersionUID = 1L;

	protected final GenericMVCModel model;

	protected GenericMVCView(GenericMVCModel model)
	{
		this.model = model;
		this.model.addModelSubscriber(this);

		buildPanel();
	}

	protected abstract void buildPanel();
}

