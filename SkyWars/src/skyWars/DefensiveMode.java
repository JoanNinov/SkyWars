package skyWars;

public class DefensiveMode implements ShipModeBehaviour {

	@Override
	public int mode() {
		return 1;
	}//end method
	//this method returns 1 because in defensive mode the ship can only destroy max 1 enemy ship

}//end class
