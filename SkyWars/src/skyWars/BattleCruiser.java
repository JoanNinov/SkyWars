package skyWars;

import java.io.Serializable;

public class BattleCruiser extends EnemyShip implements Serializable{
	
	public BattleCruiser( ) {
		setName();
		setMoved(false);
	}

	@Override
	String getName() {
		return this.name;
	}
	
	@Override
	void setMoved(boolean moved) {
		this.moved = moved;	
	}

	@Override
	boolean getMoved() {
		return this.moved;
	}

	@Override
	void setName() {
		this.name = "BattleCruiser";	
	}

}//end class BattleCruiser
