package skyWars;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Row implements Serializable {

	//declare instance variables
	private int number; //the number of the row
	private final int FIRST_SQUARE = 1; //making sure square count starts from 1
	private final int TOTAL_SQUARES = 4; //max amount of squares in a row 
	ArrayList<Square> row = new ArrayList<Square>();//list of squares which defines the row

	//Constructor for Row
	public Row(int number) {
		setNumber(number);
		//declare local variable 
		Square tempSquare; //a temporary Square object that will store the created square within each iteration of the loop below
		//for loop that iterates through the desired length of the row
		for(int loop = FIRST_SQUARE; loop <= TOTAL_SQUARES; loop++) {
			tempSquare = new Square(loop); //a Square is created at each iteration of the loop
			tempSquare.setRowNumber(getNumber()); //also add a value to the squareRow number indicating which row it belongs to. Needed for GUI 
			this.row.add(tempSquare); //the created square at each iteration is entered in the collection of squares for the row
		}//end for loop
	}//end constructor for Row
	
	//method that finds a square
	public Square findSquareWithMasterShip() {
		//declare local variable
		Square square = new Square();//dummy square created with the empty constructor.Initialised due to not wanting to specify it as null
		//enhanced for loop that iterates through each square in this row
		for (Square tempSquare : this.row) {
			//for each square we check whether the master ship is present
			if(tempSquare.isMasterShipPresent()) {//if true...
				//...we save the square in our iteration of the row within the dummy square local variable
				square = tempSquare;
			}//end if statement
		}//end enhanced for loop
		//return the square which at this point is not a dummy any longer.
		return square;
	}//end method that finds a specific square
	
	//method that gets the specific square in the row
	public Square getSquare(int squareNum) { //parameter for the square which we are looking for
		//enhanced for loop that iterates through all squares in the row
		for (Square tempSquare: this.row) {
			//if statement that checks for the square number according to the method parameter
			if(tempSquare.getNumber() == squareNum) {
				//return the square with the number matching the parameter.
				return tempSquare;
			}//close if statement
		}//end enhanced for loop
		return null;
	}//close method for finding specific square
	
	//create method that adds all class details into a string
	public String toString() {
		//declare local variable
		String output;
		//build output 
		output = "This is Row #" + getNumber() + "\n";
		output = output + "It consists of " + TOTAL_SQUARES +" Squares\n";
		output = output + "The details of each square within this row is as follows:\n";
		//now get the details of each Square
		for(Square tempSquare : this.row) {
			output = output +tempSquare.toString() +"\n";
		}//end for loop
		//return the output
		return output;
	}//end method to add details to a string
	
	//construct method to print details
	public void printDetails() {
		//declare local variables and initiate them
		String output = toString();	
		// display message
		JOptionPane.showMessageDialog(null, output);
	}//end method to print details
	
	
	//getters and setters
	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public ArrayList<Square> getRow() {
		return this.row;
	}

	/*
	public void setRow(ArrayList<Square> row) {
		this.row = row;
	}
	*/
	
}//end class
