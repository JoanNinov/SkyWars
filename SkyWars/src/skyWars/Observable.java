package skyWars;

public interface Observable {

	public void changeMode();
	public void moveAllEnemyShips();
	public void moveEnemyShip(EnemyShip enemyShip, int currentY, int currentX);
	public void moveMasterShip();
}
