package controller;

import model.GenericModel;

public abstract class GenericController
{			
	public final boolean VERBOSE = false;
	
	/**
	 * A barebones controller needs a comThread and systemModel
	 */
	protected GenericModel systemModel;
	protected GenericCommunicationThread comThread;
}
