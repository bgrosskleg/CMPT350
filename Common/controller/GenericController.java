package controller;

import model.GenericModel;

public class GenericController 
{
	public final boolean VERBOSE = false;
	
	/**
	 * A barebones controller needs a comThread and systemModel
	 */
	protected GenericCommunicationThread comThread;
	protected GenericModel model;
}
