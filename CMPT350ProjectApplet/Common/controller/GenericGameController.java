package controller;

public abstract class GenericGameController
{
	public abstract void evaluateHand();

	public abstract void initializeGame();

	public abstract void gameOver();
	
	public abstract void dealRandomCards();
}