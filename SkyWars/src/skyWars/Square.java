package skyWars;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Square implements Serializable {
	
	//declare instance variables
	private int number; //the number of the square
	private int rowNumber;
	private boolean masterShipPresent = false; //whether the square is occupied by a master ship. by default it is false
	private ArrayList<EnemyShip> enemyShips = new ArrayList<EnemyShip>();//list of enemy ships on the square
	
	
	//empty constructor for square
	public Square() {}//end constructor for Square
	
	//Constructor for Square
	public Square(int number) {
		setNumber(number);//set the number of the square
	}//end constructor for Square
	
	//method to add enemy ships that are occupying the square
	public void addEnemyShip(EnemyShip enemyShip) {
		this.enemyShips.add(enemyShip);
	}//end method that adds enemy ship
	
	//create method that removes the ships that have moved away from this square
	public void removeEnemyShip(EnemyShip enemyShip) {
		this.enemyShips.remove(enemyShip);
	}//end method that removes enemy ships that have moved to a different square
	
	//method that empties the square of enemy ships (Removes them from the square's Linked list) This would occurs when the master space ship wins the battle. 
	public void destroyEnemyShips() {
		this.enemyShips.clear();//clears the Linked list containing enemy ships 
	}//end method that removes all enemy ships on the square. Removes them from the Linked list.
	
	//method that gets the size of the enemy ship list
	public int getNumberOfShips() {
		return getEnemyShips().size();
	}//end method that returns size of list

	//create method that adds all class details into a string
	public String toString() {
		//declare local variables
		String output;
		//build output
		output = "This is Square #" + getNumber() + " for this row:\n";
		//if statement that builds output based on whether the master space ship is present on the square or not
		if(isMasterShipPresent()) {// if the master space ship is present
			output = output + "the Master space ship is currently on this square";
		} else {//if the master space ship is not present
			output = output + "the master space ship is NOT on this square";
		}//close if statement regarding presence of master space ship
		output = output + " & ";
		//if statement that builds output based on whether the square has enemy ships present/ whether enemy ship objects are saved in its list of enemy ships
		if(getEnemyShips().size() > 0) {//if the list is not empty
			output = output + "This is the list of enemy ships currently on this square: ";
			//enhanced for loop that iterates through each object/enemy space ship in the squares list of enemy space ships.
			for(EnemyShip tempShip : getEnemyShips()) {
				output = output + tempShip.getName() +", ";//the name of the enemy space ship is added to the output
			}//close enhanced for loop
			//creates the line break after listing all ships
			output = output + "\n";
		} else {//otherwise if no ships are present
			output = output + "There are no enemy ships on this square";
		}//close if statement that builds output based on enemy ships/objects saved in the square's list of enemy ships
		//return the built output
		return output;
	}//end method that adds all class details into a string and builds the output
	
	//construct method to print details
	public void printDetails() {
		//declare local variables and initiate them
		String output = toString();	
		// display message
		JOptionPane.showMessageDialog(null, output);
	}//end method to print details
	
	public String SquareInfo(int rowNumber) {
		//declare local variable
		String output;
		//build output
		output = "This is Square #" + getNumber() + " in row #" + rowNumber + "\n";
		//if statement for the intergalactic hole
		if(getNumber() == 1 && rowNumber == 1) {
			output = output + "This square is the one-directional intergalactic hole.\n";
		}//end if statement
		output = output + "This square is occupied by " + this.enemyShips.size() + " Enemy Ships.\n"; 
		//enhanced for loop that iterates through
		for(EnemyShip tempShip : this.enemyShips) {
			output = output + tempShip.getName() +"\n";
		}
		//return the built output
		return output;
	}
		
	//getters and Setters
	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getRowNumber() {
		return this.rowNumber;
	}

	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}

	public boolean isMasterShipPresent() {
		return this.masterShipPresent;
	}

	public void addMasterShip() {
		this.masterShipPresent = true;
	}
	
	public void removeMasterShip() {
		this.masterShipPresent = false;
	}
	

	public ArrayList<EnemyShip> getEnemyShips() {
		return this.enemyShips;
	}

	/*
	public void setEnemyShips(ArrayList<EnemyShip> enemyShips) {
		this.enemyShips = enemyShips;
	}
	*/
	
}//end class
