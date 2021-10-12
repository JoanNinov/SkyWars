package skyWars;

import java.io.Serializable;

public class BattleShooter extends EnemyShip implements Serializable{
	
	public BattleShooter( ) {
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
		this.name = "BattleShooter";	
	}

}//end class BattleShooter

