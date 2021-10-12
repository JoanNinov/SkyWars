package skyWars;

import javax.swing.JOptionPane;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;


public class SkyWarsDemo {

	public static void main(String[] args) {
		
	
		/*
		//testing to create game pieces and print grid in info dialog box
		SkyWars game = new SkyWars();//create the UI
		
		game.printDetails();//print details of grid
		//game.placeMasterShipOnGrid();//exists within the SkyWars constructor so will place another MasterShip on the field if used again.
		game.checkIfNewShip();//checks whether there will be an enemy ship at 1:1. will give a console message if so
		//game.spawnEnemyShip();// for sure creates a new enemy ship and places it at 1:1
		game.printDetails();//print details of grid
		//game.getBoard().getRow(1).getSquare(1).printDetails();//get square at 1:1 and print details
		//game.getBoard().getRow(game.getMasterShipY()).getSquare(game.getMasterShipX()).printDetails();//get square with latest MasterShip coordinates.
		*/
		
		
		/*
		//testing conflict
		SkyWars game = new SkyWars();//create the UI
		//get the coordinates of the master ship
		int X = game.getMasterShipX();
		int Y = game.getMasterShipY();
		
		game.printDetails();//print details of grid
		System.out.println("The strength of the ship is " + game.getMasterShip().modeStrength());
		game.spawnEnemyShipOn(Y, X);//spawn enemyship where mastership is
		//game.spawnEnemyShip();//spawn a second enemyShip where mastership is
		//game.spawnEnemyShip();//spawn a third enemyShip where mastership is
		game.printDetails();//print details of grid
		//game.changeMode();//change the MasterShip mode 
		//System.out.println("The strength of the ship is " + game.getMasterShip().modeStrength());
		game.checkConflict();
		game.printDetails();//print details of grid
		*/
		
		
		/*
		//testing to move all ships
		SkyWars game = new SkyWars();//create the UI
		
		//game.printDetails();//print details of grid
		//game.spawnEnemyShip();// for sure creates a new enemy ship and places it at 1:1 	For these three placements to work we need to adjust the 
		//game.spawnEnemyShip();// for sure creates a new enemy ship and places it at 1:1		spawnEnemyShip method as it depends on which board  																						
		//game.spawnEnemyShip();// for sure creates a new enemy ship and places it at 1:1 	you want to place the ships
		game.initialise();//initialise the game
		game.printDetails();//print details of grid
		game.move();
		game.printDetails();//print details of grid
		game.move();
		game.printDetails();//print details of grid
		game.move();
		game.printDetails();//print details of grid
		game.move();
		game.printDetails();//print details of grid
		game.move();
		game.printDetails();//print details of grid
		game.move();
		game.printDetails();//print details of grid
		game.move();
		game.printDetails();//print details of grid
		game.move();
		game.printDetails();//print details of grid
		*/
		

		/*
		//checking whether moving the ship works
		SkyWars game = new SkyWars();//create the UI
		
		game.printDetails();//print details of grid
		game.moveMasterShip();//move the ship
		game.printDetails();//print details of grid
		game.moveMasterShip();//move the ship
		game.printDetails();//print details of grid
		game.moveMasterShip();//move the ship
		game.printDetails();//print details of grid
		game.moveMasterShip();//move the ship
		game.printDetails();//print details of grid
		game.moveMasterShip();//move the ship
		game.printDetails();//print details of grid
		game.moveMasterShip();//move the ship
		game.printDetails();//print details of grid
		*/

		
		/*
		//checking whether the enemyShip factory works
		EnemyShip newShip;
		EnemyShipFactory factory = new EnemyShipFactory();
		String output;
		
		newShip = factory.createEnemyShip();
		newShip.getName();
		
		output = "Newly created: " + newShip.name + "\n";
		output = output + "This ship has moved: " + newShip.getMoved();
		JOptionPane.showMessageDialog(null, output);
		newShip.setMoved(true);
		output = "This " + newShip.name + " has moved: " + newShip.getMoved();
		JOptionPane.showMessageDialog(null, output);
		*/
		
		
		/*
		//Check to see if MasterShip Strategy pattern works by using methods in ship
		MasterShip ms = new MasterShip();//check on ship
		
		String output = "The strength of the ship is " + ms.getStrength(); 
		JOptionPane.showMessageDialog(null, output);
		ms.setShipModeBehaviour(new OffensiveMode());
		
		output = "The strength of the ship is " + ms.getStrength(); 
		
		JOptionPane.showMessageDialog(null, output);
		*/
	
		
		/*
		//Check to see if MasterShip Strategy pattern works within the game
		SkyWars game = new SkyWars();//create the UI check with methods in game
		
		String output = "The strength of the ship is " + game.getMasterShip().getStrength(); 
		JOptionPane.showMessageDialog(null, output);
		game.changeMode();
		
		output = "The strength of the ship is " + game.getMasterShip().getStrength(); 
		
		JOptionPane.showMessageDialog(null, output);
		*/
		
		
		/*
		//Checking whether we can create an empty object and then replace it with another one. 
		Square sq1 = new Square(1);
		Square sq2 = new Square();
		sq1.printDetails();
		sq2.printDetails();
		sq2 = sq1;
		sq1.printDetails();
		sq2.printDetails();
		*/
		
		
		/*
		//testing ThreadLocalRandom
		int min = 1;
		int max = 2;
		
		int random = ThreadLocalRandom.current().nextInt(min, max + 1);
		System.out.println(random);
		*/
		
		
	}

}
