package skyWars;

import java.io.Serializable;

public abstract class EnemyShip implements Serializable {
	
	//declare instance variables
	protected String name;
	protected boolean moved;
	
	
	//abstract getters and setters
	abstract String getName();
	
	abstract void setName();
	
	abstract boolean getMoved();
	
	abstract void setMoved(boolean moved);
	
}//end abstract class for enemy ships
