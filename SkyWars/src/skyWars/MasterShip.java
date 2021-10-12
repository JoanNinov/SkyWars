package skyWars;

import java.io.Serializable;

public class MasterShip implements Serializable {
	
	//declare instance variables
	private int strength; //variable that will store the ship's strength. This integer will be compared to the size of the list of enemyShips on a given square.
	private ShipModeBehaviour shipModeBehaviour; //variable for the behaviour within the strategy pattern
	
	//constructor for this class
	public MasterShip() {
		setShipModeBehaviour(new DefensiveMode());//where the default is to spawn the ship in defensive mode.
	}
	
	public int modeStrength() {
		return getShipModeBehaviour().mode();
	}
	
	
	//getters and setters
	public ShipModeBehaviour getShipModeBehaviour() {
		return this.shipModeBehaviour;
	}
	
	//exception in this setter
	public void setShipModeBehaviour(ShipModeBehaviour shipModeBehaviour) {
		this.shipModeBehaviour = shipModeBehaviour;
		//the exception is that when we set the new shipModeBehaviour we want to update the ships strength accordingly.
		setStrength(modeStrength());
	}
	
	public int getStrength() {
		return this.strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}
	
}
