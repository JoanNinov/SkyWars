package skyWars;

import java.io.Serializable;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SkyWars implements Observable, Serializable{
	
	//Declare instance variables
	private int MasterShipX;//so that we can easily get the square upon which the masterShip is placed
	private int MasterShipY;//so that we can get the row in which the masterShip is located.
	private Grid board;
	private Grid replacementBoard;
	private MasterShip masterShip;
	private EnemyShipFactory factory;
	private boolean gameOver = false; //gameOver is false by default
	
	//Constructor for SkyWars
	public SkyWars() {
		//Initialise();//calls method that initialises the game board/creates the first game pieces.
	}
	
	//method that initialises the game
	public void initialise() {
		setBoard();//set the board
		setMasterShip();//set the masterShip
		placeMasterShipOnGrid();//place the MasterShip on the grid
		setFactory();//set the factory
	}//end method that initialises the game
	
	//method that prints the details of the grid.
	public void printDetails() {
		getBoard().printDetails();//calls printDetails method in class grid
	}//end method that prints details
	
	//Create method for move sequence
	public void move() {
		//declare replacement board
		setReplacementBoard();
		//move MasterShip
		moveMasterShip();
		//move enemy ships
		moveAllEnemyShips();
		//spawn enemy ship
		checkIfNewShip();
		//update the board
		replaceBoard();
		//check for conflict
		checkConflict();	
	}//end method that defines the sequences of movement within the game
	
	//method for the end of the game
	public void endgame() {
		setGameOver(true);
	}//end method that defines the end of the game
			
	//create method that checks for conflicts
	public void checkConflict() {
		//declare local variables
		int shipStrength = getMasterShip().modeStrength();
		int currentX = getMasterShipX();
		int currentY = getMasterShipY();
		int numberOfEnemyShips;
		final int EMPTY = 0;
		//Find the size of the list of enemy ships on the square on which the MasterShip is also located. 
		numberOfEnemyShips = getBoard().getRow(currentY).getSquare(currentX).getNumberOfShips();
		//Compare MasterShip strength with size of list of enemy ships on said square
		if(numberOfEnemyShips != EMPTY && numberOfEnemyShips <= shipStrength){//if the size of the list is less than or equal to the ship strength...
			//...the MasterShip wins the battle and destroys all enemy ships. The list of enemy ships on said square should be emptied
			getBoard().getRow(currentY).getSquare(currentX).destroyEnemyShips();
			System.out.println("CONFLICT! MasterShip wins");
		}//end if statement
		if(numberOfEnemyShips > shipStrength) {//if the size of the list is more than the ship strength...
			//...the MasterShip loses the battle and gets destroyed.
			//call a method that runs the end of the game.
			endgame();
			System.out.println("Game Over");
		}//end if statement
	}//end method for checking for conflicts
	
	//method that changes the masterShip mode
	public void changeMode() {
		//declare local variables
		final int DEFENSIVE = 1;
		final int OFFENSIVE = 2;
		int shipStrength = getMasterShip().modeStrength();
		//switch statement that will check the ship strength and change the mode accordingly
		switch(shipStrength) {
		case(DEFENSIVE)://if current strength is the strength of defensive mode....
			//...change the ship's mode to offensive mode
			getMasterShip().setShipModeBehaviour(new OffensiveMode());
		break;
		case(OFFENSIVE)://if current strength is the strength of offensive mode....
			//...change the ship's mode to defensive mode
			getMasterShip().setShipModeBehaviour(new DefensiveMode());
		break;
		}//end switch statement
	}//end method that switches the ship mode.
		
	//method that moves enemy ship
	public void moveAllEnemyShips() {
		//declare local variable
		//Grid newBoard = getReplacementBoard(); 
		int currentY;//placeholder for current Y coordinate/Row in the grid
		int currentX;//placeholder for current X coordinate/Square in a row
		Grid tempBoard = getBoard();
		//enhanced for loop that iterates through each row in the grid
		for(Row tempRow : tempBoard.getGrid()) {
			//for each iteration of rows it saves the number of the row in the current Y coordinate variable
			currentY = tempRow.getNumber();
			//enhanced for loop that iterates through each square in the current iteration of the rows
			for(Square tempSquare : tempRow.getRow()) {
				//for each iteration of squares saves the number of the square in the current X coordinate variable
				currentX = tempSquare.getNumber();
				//enhanced for loop that iterates through each ship in the list of enemy ships on the current iteration of square
				for(EnemyShip tempShip : tempSquare.getEnemyShips()) {
					//for each ship in the list we call the method that moves the enemy ship and pass all the relevant parameters
						moveEnemyShip(tempShip, currentY, currentX);
				}//end enhanced for loop that iterates through each ship
			}//end enhanced for loop that iterates through each square
		}//end enhanced for loop that iterates through each row
	}//end method that moves all enemy ships
	
	//method that moves individual enemy ship
	public void moveEnemyShip(EnemyShip enemyShip, int currentY, int currentX) {
		//declare local variables
		final int LOWER_LIMIT = 1;//constant to be used to determine the RNG lower limit. Same constant to be used to define the lowest coordinate on the grid
		final int UPPER_LIMIT = 2;//constant to be used to determine the RNG upper limit. upper limit is exclusive thus we are adding by 2 and not just 1
		final int GRID_MAX = 4;//constant to be used to define the highest coordinate of the grid
		final int MIN_X = currentX - LOWER_LIMIT;//inclusive RNG min limit for new X coordinate 
		final int MAX_X = currentX + UPPER_LIMIT;//exclusive RNG max limit for new X coordinate
		final int MIN_Y = currentY - LOWER_LIMIT;//inclusive RNG min limit for new Y coordinate 
		final int MAX_Y = currentY + UPPER_LIMIT;//exclusive RNG max limit for new Y coordinate
		int newX;//new Y coordinate
		int newY;//new X coordinate
		ThreadLocalRandom random = ThreadLocalRandom.current();//local RNG//we do not create an object and instead we get the current object
		//I decided to start by creating a Y coordinate and then the X coordinate will be created based on the new Y coordinate
		//do while loop which will create at least 1 new Y coordinate and then create a new one if the conditions say so
		do {
			newY = random.nextInt(MIN_Y, MAX_Y);//new random Y coordinate where the limits for the RNG are based on the current Y coordinate
			System.out.println("newY: " + newY);//print statement for analysis
		} while(newY < LOWER_LIMIT || newY > GRID_MAX);//repeat the RNG if Y < 1 or Y > 4, which would mean the new coordinate would be outside of the grid.
		//if statement depending on the new Y coordinate.
		//If the new Y coordinate is less than or more than the current coordinate we can run the same do while loop top get a new X coordinate.
		if(newY < currentY || newY > currentY) {
			do {
				newX = random.nextInt(MIN_X, MAX_X);//new random X coordinate where the limits for the RNG are based on the current X coordinate
				System.out.println("newX: " + newX);//print statement for analysis
			} while(newX < LOWER_LIMIT || newX > GRID_MAX);//repeat the RNG if X < 1 or X > 4, which would mean the new coordinate would be outside of the grid.
		//Otherwise, the new Y coordinate is exactly the same as the current Y coordinate, which is fine...
		//...but it means that the new X coordinate cannot be the the same as the current X coordinate as the ship has to move to a new coordinate
		} else {
			do {
				newX = random.nextInt(MIN_X, MAX_X);
				System.out.println("newX: " + newX);
				//therefore the while condition says that the RNG will create a new X coordinate as long as X < 1 or X > 4, which would mean the new coordinate would be outside of the grid.
				//...and as long as the new X coordinate is the same as the current X coordinate
			} while(newX < LOWER_LIMIT || newX > GRID_MAX || newX == currentX);
		}//end else statement
		//add the ship to the new coordinate/square on the replacement board
		getReplacementBoard().getRow(newY).getSquare(newX).addEnemyShip(enemyShip);
		//No need to bother removing ships as the board is going to be updated with the replacement board
	}//end method that moves a specific enemy ship
	
	//method to moves masterShip
	public void moveMasterShip() {
		//declare local variables
		int currentX = getMasterShipX();
		int currentY = getMasterShipY();
		final int LOWER_LIMIT = 1;//constant to be used to determine the RNG lower limit. Same constant to be used to define the lowest coordinate on the grid
		final int UPPER_LIMIT = 2;//constant to be used to determine the RNG upper limit. upper limit is exclusive thus we are adding by 2 and not just 1
		final int GRID_MAX = 4;//constant to be used to define the highest coordinate of the grid
		final int MIN_X = currentX - LOWER_LIMIT;//inclusive RNG min limit for new X coordinate 
		final int MAX_X = currentX + UPPER_LIMIT;//exclusive RNG max limit for new X coordinate
		final int MIN_Y = currentY - LOWER_LIMIT;//inclusive RNG min limit for new Y coordinate 
		final int MAX_Y = currentY + UPPER_LIMIT;//exclusive RNG max limit for new Y coordinate
		int newX;//new Y coordinate
		int newY;//new X coordinate
		ThreadLocalRandom random = ThreadLocalRandom.current();//local RNG//we do not create an object and instead we get the current object
		//I decided to start by creating a Y coordinate and then the X coordinate will be created based on the new Y coordinate
		//do while loop which will create at least 1 new Y coordinate and then create a new one if the conditions say so
		do {
			newY = random.nextInt(MIN_Y, MAX_Y);//new random Y coordinate where the limits for the RNG are based on the current Y coordinate
			System.out.println("newY: " + newY);//print statement for analysis
		} while(newY < LOWER_LIMIT || newY > GRID_MAX);//repeat the RNG if Y < 1 or Y > 4, which would mean the new coordinate would be outside of the grid.
		//if statement depending on the new Y coordinate.
		//If the new Y coordinate is less than or more than the current coordinate we can run the same do while loop top get a new X coordinate.
		if(newY < currentY || newY > currentY) {
			do {
				newX = random.nextInt(MIN_X, MAX_X);//new random X coordinate where the limits for the RNG are based on the current X coordinate
				System.out.println("newX: " + newX);//print statement for analysis
			} while(newX < LOWER_LIMIT || newX > GRID_MAX);//repeat the RNG if X < 1 or X > 4, which would mean the new coordinate would be outside of the grid.
		//Otherwise, the new Y coordinate is exactly the same as the current Y coordinate, which is fine...
		//...but it means that the new X coordinate cannot be the the same as the current X coordinate as the ship has to move to a new coordinate
		} else {
			do { 
				newX = random.nextInt(MIN_X, MAX_X);
				System.out.println("newX: " + newX);
				//therefore the while condition says that the RNG will create a new X coordinate as long as X < 1 or X > 4, which would mean the new coordinate would be outside of the grid.
				//...and as long as the new X coordinate is the same as the current X coordinate
			} while(newX < LOWER_LIMIT || newX > GRID_MAX || newX == currentX);
		}//end else statement
		//add masterShip to new coordinates on the replacement board
		getReplacementBoard().getRow(newY).getSquare(newX).addMasterShip();	
		//save the new coordinates of the masterShip
		setMasterShipY(newY);
		setMasterShipX(newX);
		//No need to bother removing the master ship as the board is going to be updated with the replacement board
	}//end method that moves masterShip

	//method that checks whether a new enemy ship will spawn
	public void checkIfNewShip() {
		//declare local variables
		final int RNG_LIMIT = 3;//the upper limit for the RNG
		Random random = new Random();//the local RNG
		//variable num that stores the generated number
		int num = random.nextInt(RNG_LIMIT);
		//Switch statement for the different results from the RNG
		switch (num) {
		case 1://if num = 1...
			spawnEnemyShip();//...call method to spawn enemy ship
			System.out.println("a new ship has spawned");
			break;
		}//end switch statement
	}//end method that checks whether a new enemy ship will spawn
	
	//method that calls the enemy ship factory and creates an enemy ship
	public void spawnEnemyShip() {
		//declare local variables
		EnemyShip newShip = this.factory.createEnemyShip();
		//calls method that places an enemy ship on the grid
		placeEnemyShipOnGrid(newShip);	
	}//end method that spawns enemy ship
	
	//Method used to spawn enemy ship in specific square.
	public void spawnEnemyShipOn(int Y, int X) {
		//declare local variables
		EnemyShip newShip = this.factory.createEnemyShip();
		//calls method that places an enemy ship on the grid
		getBoard().getRow(Y).getSquare(X).addEnemyShip(newShip); //an enemy ship will always enter the grid on row 1 square 1.
	}//end method that spawns enemy ship in specific square
	
	//method that places the enemy ship on the grid
	public void placeEnemyShipOnGrid(EnemyShip enemyShip) {
		//declare local variables
		final int COORDINATE = 1;
		//getBoard().getRow(COORDINATE).getSquare(COORDINATE).addEnemyShip(enemyShip); //an enemy ship will always enter the grid on row 1 square 1.
		getReplacementBoard().getRow(COORDINATE).getSquare(COORDINATE).addEnemyShip(enemyShip); //an enemy ship will always enter the grid on row 1 square 1.
	}//end method that places an enemy ship on the grid
	
	//method that places master ship on grid
	public void placeMasterShipOnGrid() {
		//declare local variables
		final int MIN = 1;//min limit is inclusive
		final int MAX = 5;//max limit is exclusive
		ThreadLocalRandom random = ThreadLocalRandom.current();//the local RNG
		//variables that store the generated coordinates for the MasterShip
		int column = random.nextInt(MIN, MAX);
		int row = random.nextInt(MIN, MAX);
		//indicate on the square whether the masterShip is present
		getBoard().getRow(row).getSquare(column).addMasterShip();
		//finally instantiate the instance variables that will track the location of the master ship
		setMasterShipX(column);
		setMasterShipY(row);
		System.out.println("initial Y: " + row);
		System.out.println("initial X: " + column);
	}//end method that places the enemyShip on the grid. 
		
	//method that iterates through the grid and returns a square.
	public Square findCoordinates(int x, int y) {
		//return a square based on coordinates
		return getBoard().getRow(y).getSquare(x);
	}//end method
	
	
	//getters and setters
	public int getMasterShipX() {
		return this.MasterShipX;
	}

	public void setMasterShipX(int masterShipX) {
		this.MasterShipX = masterShipX;
	}

	public int getMasterShipY() {
		return this.MasterShipY;
	}

	public void setMasterShipY(int masterShipY) {
		this.MasterShipY = masterShipY;
	}

	public Grid getBoard() {
		return this.board;
	}

	public void setBoard() {
		this.board = new Grid();//Instantiates this game board by calling its constructor
	}
	
	public void replaceBoard() {
		this.board = getReplacementBoard(); //always replaces the game board with the replacement
	}
	
	public Grid getReplacementBoard() {
		return this.replacementBoard;
	}

	public void setReplacementBoard() {
		this.replacementBoard = new Grid();//Instantiates this game board by calling its constructor
	}

	public MasterShip getMasterShip() {
		return this.masterShip;
	}

	public void setMasterShip() {
		this.masterShip = new MasterShip();//Instantiates this MasterShip by calling its constructor
	}

	public EnemyShipFactory getFactory() {
		return this.factory;
	}

	public void setFactory() {
		this.factory = new EnemyShipFactory();//Instantiates this factory by calling its constructor
	}

	public boolean isGameOver() {
		return this.gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}
	
	
	
	
}//end class
