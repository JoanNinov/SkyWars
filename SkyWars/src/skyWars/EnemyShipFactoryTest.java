package skyWars;

import junit.framework.TestCase;

public class EnemyShipFactoryTest extends TestCase {

	public void testCreateEnemyShip() {
		//declare local variable
		EnemyShipFactory factory = new EnemyShipFactory();
		//test the method
		EnemyShip es = factory.createEnemyShip();
		//get the name of the ship 
		String shipName = "";
		//But it is created at random
		switch(es.getName()) {
		case("BattleCruiser"):
			shipName = "BattleCruiser";
		break;
		case("BattleShooter"):
			shipName = "BattleShooter";
		break;
		case("BattleStar"):
			shipName = "BattleStar";
		break;
		}
		//declare actual and expected.
		String actual = es.getName();
		String expected = shipName;
		
		assertTrue(actual == expected);
		
	}

}
