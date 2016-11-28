
public class Chaser extends Enemy 
{
	
	public Chaser(int x, int y) 
	{
		//health = 3, damage = 1, moveSpeed = 1
		super(3, 1, 1, x, y);
	}
	
	protected void move()
	{
		int xDistAbs = Math.abs(Player.xCoord - this.xCoord);
		int yDistAbs = Math.abs(Player.yCoord - this.yCoord);
		int xDist = (Player.xCoord - this.xCoord);
		int yDist = (Player.yCoord - this.yCoord);
		
		if (xDistAbs > yDistAbs)
		{
			super.enemyMove(xDist, 0);
		}
		else
		{
			super.enemyMove(0, yDist);
		}
		/*
		 * find out if father away from player on x or y, then
		 * move close in that direction
		 * pause
		 * repeat
		 */
	}
	
	protected void attack()
	{
		if ((Player.xCoord == this.xCoord) && (Player.yCoord == this.yCoord))
		{
			Player.health -= super.damage;
		}
		//if within one space or on the same space
		//player health -= damage
	}
}
