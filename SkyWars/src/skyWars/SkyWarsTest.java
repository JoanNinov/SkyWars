package skyWars;

import junit.framework.TestCase;

public class SkyWarsTest extends TestCase {

	//testing conflict defensive mode where mastership wins
	public void testCheckConflictDefensiveWin() {
		//declare variables
		SkyWars game = new SkyWars();
		//declare testing variable
		int enemyShipsLeft = 0; //we expect all enemyships to have been removed from th square => lost in battle
		//create all game pieces
		game.initialise();
		//place ship on said ccordinate
		game.placeMasterShipOnGrid();
		//spawn enemy ship
		game.spawnEnemyShipOn(game.getMasterShipY(), game.getMasterShipX());
		//check for conflict
		game.checkConflict();
		//create expected and actual
		int actual = game.getBoard().getRow(game.getMasterShipY()).getSquare(game.getMasterShipX()).getNumberOfShips();
		int expected = enemyShipsLeft;

		assertTrue(actual == expected);
	}
	
	//testing conflict defensive mode where mastership loses
	public void testCheckConflictDefensiveLoss() {
		//declare variables
		SkyWars game = new SkyWars();
		//declare testing variable
		boolean isGameOver = true; //we expect the boolean for game over to be set to true
		//create all game pieces
		game.initialise();
		//place ship on said ccordinate
		game.placeMasterShipOnGrid();
		//spawn 2 enemy ships
		game.spawnEnemyShipOn(game.getMasterShipY(), game.getMasterShipX());
		game.spawnEnemyShipOn(game.getMasterShipY(), game.getMasterShipX());
		//check for conflict
		game.checkConflict();
		//create expected and actual
		boolean actual = game.isGameOver();
		boolean expected = isGameOver;

		assertTrue(actual == expected);
	}
	
	//testing conflict offensive mode where mastership wins
	public void testCheckConflictOffensiveWin() {
		//declare variables
		SkyWars game = new SkyWars();
		//declare testing variable
		int enemyShipsLeft = 0; //we expect all enemyships to have been removed from th square => lost in battle
		//create all game pieces
		game.initialise();
		//place ship on said ccordinate
		game.placeMasterShipOnGrid();
		//change mode of mastership
		game.changeMode();//mastership is on defensive as default and will thus change to foofensive
		//spawn 2 enemy ships
		game.spawnEnemyShipOn(game.getMasterShipY(), game.getMasterShipX());
		game.spawnEnemyShipOn(game.getMasterShipY(), game.getMasterShipX());
		//check for conflict
		game.checkConflict();
		//create expected and actual
		int actual = game.getBoard().getRow(game.getMasterShipY()).getSquare(game.getMasterShipX()).getNumberOfShips();
		int expected = enemyShipsLeft;

		assertTrue(actual == expected);
	}
	
	
	//testing conflict offensive mode where mastership loses
	public void testCheckConflictOffensiveLoss() {
		//declare variables
		SkyWars game = new SkyWars();
		//declare testing variable
		boolean isGameOver = true; //we expect the boolean for game over to be set to true
		//create all game pieces
		game.initialise();
		//place ship on said ccordinate
		game.placeMasterShipOnGrid();
		//change mode of mastership
		game.changeMode();//mastership is on defensive as default and will thus change to foofensive
		//spawn 3 enemy ships
		game.spawnEnemyShipOn(game.getMasterShipY(), game.getMasterShipX());
		game.spawnEnemyShipOn(game.getMasterShipY(), game.getMasterShipX());
		game.spawnEnemyShipOn(game.getMasterShipY(), game.getMasterShipX());
		//check for conflict
		game.checkConflict();
		//create expected and actual
		boolean actual = game.isGameOver();
		boolean expected = isGameOver;

		assertTrue(actual == expected);
	}
	

	public void testChangeMode() {
		//declare variables
		SkyWars game = new SkyWars();
		//create new master ship
		game.setMasterShip();;
		//chnage mode of mastership
		game.changeMode();
		//delare mode strength in a variable
		int strength = 2;
		//create expected and actual
		int actual = game.getMasterShip().modeStrength();
		int expected = strength;
		//check result
		assertTrue(actual == expected);	
	}

	public void testMoveAllEnemyShips() {
		//declare variables
		SkyWars game = new SkyWars();
		//create game pieces
		game.initialise();
		//create replacement board
		game.setReplacementBoard();
		//coordinate in which they spawn
		int coordinate = 1;
		//spawn several ships, which willby default spawn at 1:1
		game.spawnEnemyShip();
		game.spawnEnemyShip();
		game.spawnEnemyShip();
		game.spawnEnemyShip();
		game.spawnEnemyShip();
		//after moving we expect 1:1 to be empty, no ships in the list
		int numOfShipsLeft = 0;
		//move all ships
		game.moveAllEnemyShips();
		//create expected and actual
		int actual = game.getBoard().getRow(coordinate).getSquare(coordinate).getNumberOfShips();
		int expected = numOfShipsLeft;

		assertTrue(actual == expected);
		
	}
	
	public void testMoveEnemyShip() {
		//declare variables
		SkyWars game = new SkyWars();
		//create game pieces
		game.initialise();
		//create replacement board
		game.setReplacementBoard();
		//coordinate in which they spawn
		int coordinate = 1;
		//spawn several ships, which willby default spawn at 1:1
		game.spawnEnemyShip();
		//after moving we expect 1:1 to be empty, no ships in the list
		int numOfShipsLeft = 0;
		//move all ships
		game.moveAllEnemyShips();
		//create expected and actual
		int actual = game.getBoard().getRow(coordinate).getSquare(coordinate).getNumberOfShips();
		int expected = numOfShipsLeft;

		assertTrue(actual == expected);
	}

	public void testMoveMasterShip() {
		//declare variables
		SkyWars game = new SkyWars();
		//create game pieces
		game.initialise();
		//create replacement board
		game.setReplacementBoard();
		//place ship on said ccordinate
		game.placeMasterShipOnGrid();
		//declare boolean to check whether it is set to true on the new square for the master ship
		boolean isOn = true;
		//move masterShip
		game.moveMasterShip();
		//create expected and actual
		boolean actual = game.getReplacementBoard().getRow(game.getMasterShipY()).getSquare(game.getMasterShipX()).isMasterShipPresent();
		boolean expected = isOn;
		//checkich whether it is true that the ship was placed on a square. square is found based on saved coordinates for ship
		assertTrue(actual == expected);
	}

	public void testSpawnEnemyShipOn() {
		//declare variables
		SkyWars game = new SkyWars();
		//create all game pieces
		game.initialise();
		int numOfShips = 1;
		//place ship on said ccordinate
		game.spawnEnemyShipOn(numOfShips, numOfShips);
		//create expected and actual. check whether the ship has been added to the list of ships making the size of the list 1
		int actual = game.getBoard().getRow(numOfShips).getSquare(numOfShips).getNumberOfShips();
		int expected = numOfShips;
		//checkich whether it is true that the ship was placed on a square. square is found based on saved coordinates for ship
		assertTrue(actual == expected);
	}

	public void testPlaceEnemyShipOnGrid() {
		//declare variables
		SkyWars game = new SkyWars();
		//create a board. remebering that the method specifically places a shiop on the replacement grid due to the sequence of actions during the move method.
		game.setReplacementBoard();
		//create enemy ship.
		EnemyShip ship = new BattleCruiser();//created battlecruiser manually
		//place ship on said ccordinate
		game.placeEnemyShipOnGrid(ship);
		//declare integer
		int numOfShips = 1;
		//create expected and actual
		int actual = game.getReplacementBoard().getRow(numOfShips).getSquare(numOfShips).getNumberOfShips();
		int expected = numOfShips;
		//checkich whether it is true that the ship was placed on a square. square is found based on saved coordinates for ship
		assertTrue(actual == expected);
	}

	public void testPlaceMasterShipOnGrid() {
		//declare variables
		SkyWars game = new SkyWars();
		//create a board.
		game.setBoard();
		//place ship on said ccordinate
		game.placeMasterShipOnGrid();
		//declare boolean
		boolean isOn = true;
		//create expected and actual
		boolean actual = game.getBoard().getRow(game.getMasterShipY()).getSquare(game.getMasterShipX()).isMasterShipPresent();
		boolean expected = isOn;
		//checkich whether it is true that the ship was placed on a square. square is found based on saved coordinates for ship
		assertTrue(actual == expected);
	}

}
