CMPT 350 Project - War Card Game - README

March 28, 2014

Brian Grosskleg 	bwg771@mail.usask.ca
Paul Thomson		pat964@mail.usask.ca
John Mason			jrm120@mail.usask.ca


1) Server Setup

1.1) Install Apache Tomcat web server on host (host must have port 65000 available)
1.2) Install latest Java JRE (JRE 7 preferred) on host
1.3) Copy entire "CMPT350Project" folder into the Tomcat folder "pathToTomcat/webapps/ROOT"
1.4) Start the tomcat server
1.5) In command prompt or terminal, change working directory to "pathToTomcat/webapps/ROOT/CMPT350"
1.6) Start the server application by running the server application jar with
		java -jar WarCardGameServerApplication.jar
	
	This will open the server application on screen, initially when waiting for players the screen will be red.
	When enough players connect, the server will display an overview of the game in action.

	
2) Client Setup

2.1) Configure Java

	With the new Java security update, Java blocks all non-signed Applets from running.  
	To manually allow the applet to run, on Windows search for "Configure Java", 
	on Mac open System Preferences and click "Java"
	
	Once the Java window opens, select the "Security" tab at the top.
	
	Then click the "Edit Site List" button in the Exception Site List section.
	
	Click add and precisely type in:
	
	http://localhost:8080/CMPT350Project/WarCardGameClientApplet.html
	
	or if accessing it on Brian's webserver (server application will need to be running first, 
	Brian can be contacted at bwg771@mail.usask.ca if you wish to test this functionality)
	
	http://71.17.243.109:8080/CMPT350Project/WarCardGameClientApplet.html
	
	Click add or hit enter to confirm
	
	Accept warning
	
	Close Configure Java
	
	Close any open web browser
	
2.2) Open web browser of choice, navigate to either 

		LOCAL:   	http://localhost:8080/CMPT350Project/WarCardGameClientApplet.html
		WEB: 		http://71.17.243.109:8080/CMPT350Project/WarCardGameClientApplet.html
		
2.3) Allow the applet to run.

2.4) Applet will now connect to server and display a yellow waiting screen, or start the game, 
	depending on number of existing players.
	
	
3) Playing the Game

3.1) War card game is based on two players flipping unknown cards on the table.
	The higher card wins (suits not important) and the winning player collects both played cards.
	The goal is to run your opponent out of cards.
	
	When cards are won, they go into a win pile and when you deck is depleted, your win pile is 
	reshuffled for you to keep using when you run of cards to draw.
	
	In the event of a tie the game of war, each player flips three more cards on the table to "increase the bet"
	The next flip then decides the fate of all 2 original tied cards, 6 additional cards and the 2 latest flipped cards.
	This can continue if another tie occurs.
	
	We have decided to implement tie breaking by awarding player 1 the cards, since the game mechanics of flipping
	and displaying more cards is trivial to the Web Programming project.  A game mechanics class maybe.
	
	We focused out effort to provide reliable communication, handling connections and disconnections, regulating 
	game state and ensuring the play experience is smooth and bug free.
	
	One limitation we have discovered is our current method of modify game state, if both players do something at the
	exact same time, they run the risk of corrupting the game state due to delays in communication.  We have
	deemed this problem out-of-scope of this project and have accepted the limitation.  To ensure reliability,
	if the player is patient and does not try to send too many commands too quickly, we've tested for 30 minutes or
	more without errors.
	
	When one player wins, the next game is started automatically.
	
3.2) Chat feature

	Players can use the chat feature to talk to each other.  This makes the game more engaging and showcases
	another feature of web programming.  Again if both players try to talk too fast or simultaneously we've experience
	situations where the  game state becomes corrupted.  This can be avoided by slowing down typing/card flipping to 
	let all players receive the update before they make a new change.
	
3.3) If the Game Crashes or Is Closed

	If an applet loses connection to the server, the player is dropped from the game, the remaining player wins.
	The remaining player can continue to wait for a new player to join.  When a second player is found, a new
	game is created, and the players are re-initialized.
	
	If the server goes down, both clients are notified of loss of connection. 
	The WarCardGameServerApplication.jar (see 1.6) will need to be restarted, and the clients browsers will need to be
	refreshed.
	
4) Testing

	We started the server locally and played locally for development.  When there were not bugs and it was functional
	we deployed it on a webserver.  Once running on a webserver, we tested sending game states around.  Originally,
	we loaded card images server side and send the images with the game state as objects.  This caused immense
	latency, so we built the applet to load images on its end as it received cards.  This meant that the model state
	was "text" based and much smaller, this improved response time incredibly and made the game playable.
	
	We also iteratively tested the chat feature, implementing key listeners and the scrollable chat area.  This
	makes the chat useful and provides value added feature to the player.
	
	After multiple sessions of testing, with the exception of both players concurrently modifying the game state, we
	conclude that our program is stable and handles most game play scenarios properly.