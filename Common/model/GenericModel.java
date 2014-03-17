package model;

import java.util.ArrayList;

import interfaces.ModelSubscriber;

public abstract class GenericModel 
{
	/**
	 * List of model subscribers to be notified
	 */
	protected ArrayList<ModelSubscriber> modelSubscriberList;

	protected GenericModel()
	{
		modelSubscriberList = new ArrayList<ModelSubscriber>();
	}
	
	//SUBSCRIBERS/OBSERVERS****************************************************************

	/**
	 * Add modelSubscriber
	 * @param subscriber the subscriber to add
	 */
	public void addModelSubscriber(ModelSubscriber subscriber) 
	{
		modelSubscriberList.add(subscriber);		
	}

	/**
	 * Remove modelSubscriber
	 * @param subscriber the subscriber to remove
	 */
	public void removeModelSubscriber(ModelSubscriber subscriber) 
	{
		modelSubscriberList.remove(subscriber);
	}

	/**
	 * Calls the modelChanged() function in all the modelSubscribers
	 */
	public void notifyModelSubscribers() 
	{
		for(ModelSubscriber subscriber : modelSubscriberList)
		{
			subscriber.modelChanged();
		}
	}
}
