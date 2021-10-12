package skyWars;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Grid implements Serializable{
	
	//declare instance variables
	private final int FIRST_ROW = 1;
	private final int TOTAL_ROWS = 4;
	ArrayList<Row> grid = new ArrayList<Row>();//list of rows which defines the grid
	
	//Constructor for Grid
	public Grid() {
		//declare local variable 
		Row tempRow; //a temporary Row object that will store the created Row within each iteration of the loop below
		//for loop that iterates through the desired size of the grid
		for(int loop = FIRST_ROW; loop <= TOTAL_ROWS; loop++) {
			tempRow = new Row(loop); //a Row is created at each iteration of the loop
			this.grid.add(tempRow); //the created Row at each iteration is entered in the collection of rows for the grid
		}//end for loop
	}//end constructor for Row
	
	//method that gets the specific row in the grid
	public Row getRow(int rowNum) { //parameter for the row which we are looking for
		//enhanced for loop that iterates through all rows in the grid
		for (Row tempRow: this.grid) {
			//if statement that checks for the row number according to the method parameter
			if(tempRow.getNumber() == rowNum) {
				//return the row with the number matching the parameter.
				return tempRow;
			}//close if statement
		}//end enhanced for loop
		return null;
	}//close method for finding specific row
	
	//create method that adds all class details into a string
	public String toString() {
		//declare local variable
		String output;
		//build output 
		output = "This is the grid.\n";
		output = output + "It consists of " + TOTAL_ROWS +" Rows\n";
		output = output + "The details of each row within this grid is as follows:\n\n";
		//now get the details of each row
		for(Row tempRow : this.grid) {
			output = output + tempRow.toString() +"\n";
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
	public ArrayList<Row> getGrid() {
		return this.grid;
	}

	/*
	public void setGrid(ArrayList<Row> grid) {
		this.grid = grid;
	}
	*/
	
}//end class
