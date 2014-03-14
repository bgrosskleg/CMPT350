package controller;

import controller.GenericCommunicationThread;

public abstract class GenericGameController
{			
	public final boolean VERBOSE = false;
	
	/**
	 * A barebones controller needs a comThread and systemModel
	 */
	protected GenericCommunicationThread comThread;
}
