package skyWars;

import java.io.Serializable;
import java.util.Random;

public class EnemyShipFactory implements Serializable{
	
	public EnemyShip createEnemyShip() {
		
		//declare local variables
		final int RNG_LIMIT = 3;//the upper limit for the RNG
		final int RNG_MANIPULATOR = 1;//Making sure the RNG produces 1, 2 & 3 rather than 0, 1 & 2
		Random random = new Random();//the local RNG
		//EnemyShip randomShip = null;//placeholder for EnemyShip created
		
		//variable num that stores the generated number
		int num = random.nextInt(RNG_LIMIT) + RNG_MANIPULATOR;
		
		//Switch statement for the different results from the RNG
		switch (num) {
		case 1: //if num = 1...
			 return new BattleStar();//...create a BattleStar enemy ship and return it.
		case 2: //if num = 2...
			return new BattleCruiser();//...create a BattleCruiser enemy ship and return it.
		case 3: //if num = 3...
			return  new BattleShooter();//...create a BattleShooter enemy ship and return it.	
		}//end switch statement
		return null;
		
		
		/*
		//Switch statement for the different results from the RNG
		switch (num) {
		case 1: //if num = 1...
			 randomShip = new BattleStar();//...create a BattleStar enemy ship and return it.
			break;
		case 2: //if num = 2...
			randomShip = new BattleCruiser();//...create a BattleCruiser enemy ship and return it.
			break;
		case 3: //if num = 3...
			randomShip =  new BattleShooter();//...create a BattleShooter enemy ship and return it.
			break;	
		}//end switch statement
		return randomShip;
		*/
		
		/*
		//series of if/else statements that will return certain enemy ship based on the number generated
		if (num == 1) {//if num = 1...
			return new BattleStar();//...create a BattleStar enemy ship and return it.
		}//end first if statement
		
		else if (num == 2) {//if num = 2...
			return new BattleCruiser();//...create a BattleCruiser enemy ship and return it.
		}//end else if statement
		
		else {//if num != 1 || 2 then the only option left is to...
			return new BattleShooter();//...create a BattleShooter enemy ship and return it.
		}//end the else statement
		*/
	}//end factory method that returns an enemy ship

}//end class
