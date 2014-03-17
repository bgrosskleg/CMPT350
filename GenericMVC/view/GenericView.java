package view;

import interfaces.ModelSubscriber;

import javax.swing.JPanel;

import model.GenericModel;

public abstract class GenericView extends JPanel implements ModelSubscriber
{
	private static final long serialVersionUID = 1L;

	protected GenericModel model;

	protected GenericView(GenericModel model)
	{
		this.model = model;
		this.model.addModelSubscriber(this);
		this.add(generatePanel());
	}

	protected abstract JPanel generatePanel();
}

