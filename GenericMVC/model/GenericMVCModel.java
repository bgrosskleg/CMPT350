package model;

import java.io.Serializable;
import java.util.ArrayList;

import interfaces.GenericMVCModelSubscriber;

public abstract class GenericMVCModel implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	/**
	 * List of model subscribers to be notified
	 */
	protected transient ArrayList<GenericMVCModelSubscriber> modelSubscriberList;

	protected GenericMVCModel()
	{
		modelSubscriberList = new ArrayList<GenericMVCModelSubscriber>();
	}
	
	//SUBSCRIBERS/OBSERVERS****************************************************************

	/**
	 * Add modelSubscriber
	 * @param subscriber the subscriber to add
	 */
	public void addModelSubscriber(GenericMVCModelSubscriber subscriber) 
	{
		modelSubscriberList.add(subscriber);		
	}

	/**
	 * Remove modelSubscriber
	 * @param subscriber the subscriber to remove
	 */
	public void removeModelSubscriber(GenericMVCModelSubscriber subscriber) 
	{
		modelSubscriberList.remove(subscriber);
	}

	/**
	 * Calls the modelChanged() function in all the modelSubscribers
	 */
	public void notifyModelSubscribers() 
	{
		for(GenericMVCModelSubscriber subscriber : modelSubscriberList)
		{
			subscriber.modelChanged();
		}
	}
}
