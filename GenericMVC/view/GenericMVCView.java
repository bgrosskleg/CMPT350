package view;

import interfaces.GenericMVCModelSubscriber;

import javax.swing.JPanel;

import model.GenericMVCModel;

public abstract class GenericMVCView extends JPanel implements GenericMVCModelSubscriber
{
	private static final long serialVersionUID = 1L;

	protected GenericMVCModel model;
	protected JPanel panel;

	protected GenericMVCView(GenericMVCModel model)
	{
		this.model = model;
		this.model.addModelSubscriber(this);
		this.panel = generatePanel();
		this.add(panel);
	}

	protected abstract JPanel generatePanel();
}

