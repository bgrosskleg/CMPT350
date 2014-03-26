package model;

import java.io.Serializable;
import java.util.ArrayList;
import interfaces.GenericMVCModelSubscriber;
/**
 * contains:
 * 
 * public methods:
 * 
 * 
 * protected methods:
 * protected GenericMVCModel()
 * synchronized addModelSubscriber(GenericMVCModelSubscriber)
 * 
 */
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
	 * adds a subscriber to the model, if more than one person is trying to be added at the same time it creates a queue
	 * 
	 * @param subscriber the subscriber to add
	 */
	public synchronized void addModelSubscriber(GenericMVCModelSubscriber subscriber) 
	{
		modelSubscriberList.add(subscriber);	
	}

	/**
	 * removes a subscriber from the model, if more than one person is trying to leave at the same time it creates a queue
	 * 
	 * @param subscriber the subscriber to remove
	 */
	public synchronized void removeModelSubscriber(GenericMVCModelSubscriber subscriber) 
	{
		modelSubscriberList.remove(subscriber);
	}
	
	/**
	 * notifies all subscribers of a change to the model
	 * 
	 * calls the modelChanged() function in all the modelSubscribers
	 */
	public synchronized void notifyModelSubscribers() 
	{
		//CANNOT USE FOR-EACH LOOP AS THE LIST CANNOT BE MODIFIED WHILE ITERATED
		for(GenericMVCModelSubscriber subscriber : modelSubscriberList)
		{
			subscriber.modelChanged();
		}		
	}
}
