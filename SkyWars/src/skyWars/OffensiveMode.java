package skyWars;

public class OffensiveMode implements ShipModeBehaviour {
	
	@Override
	public int mode() {
		return 2;	
	}//end method
	//this method returns 2 because in offensive mode the ship can only destroy max 2 enemy ship

}//end class
