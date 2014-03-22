package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

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
	public synchronized void addModelSubscriber(GenericMVCModelSubscriber subscriber) 
	{
		modelSubscriberList.add(subscriber);	
	}

	/**
	 * Remove modelSubscriber
	 * @param subscriber the subscriber to remove
	 */
	public synchronized void removeModelSubscriber(GenericMVCModelSubscriber subscriber) 
	{
		modelSubscriberList.remove(subscriber);
	}

	/**
	 * Calls the modelChanged() function in all the modelSubscribers
	 */
	public synchronized void notifyModelSubscribers() 
	{
		new Exception().printStackTrace();
		//CANNOT USE FOR-EACH LOOP AS THE LIST CANNOT BE MODIFIED WHILE ITERATED
		for(GenericMVCModelSubscriber subscriber : modelSubscriberList)
		{
			subscriber.modelChanged();
		}
		
		//MUST USE ITERATOR.REMOVE()
		//http://stackoverflow.com/questions/11177348/how-to-add-element-in-list-while-iterating-in-java
		//http://stackoverflow.com/questions/223918/efficient-equivalent-for-removing-elements-while-iterating-the-collection
		//http://stackoverflow.com/questions/6700717/how-to-iterate-through-an-array-list-arrayindexoutofboundsexception
		
		//Iterator<GenericMVCModelSubscriber> iter = modelSubscriberList.iterator();
		//while(iter.hasNext())
		//{
		//	GenericMVCModelSubscriber subscriber = iter.next();
		//	subscriber.modelChanged();
		//}
		
		
	}
}
