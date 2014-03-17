package view;

import interfaces.ModelSubscriber;

import javax.swing.JPanel;

import model.GenericModel;

public abstract class GenericView extends JPanel implements ModelSubscriber
{
	private static final long serialVersionUID = 1L;

	protected GenericModel model;
	protected JPanel panel;

	protected GenericView(GenericModel model)
	{
		this.model = model;
		this.model.addModelSubscriber(this);
		this.panel = generatePanel();
		this.add(panel);
	}

	protected abstract JPanel generatePanel();
}

