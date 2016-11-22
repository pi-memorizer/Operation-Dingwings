
public class Chaser extends Enemy 
{
	
	public Chaser(int x, int y) 
	{
		//health = 3, damage = 1, moveSpeed = 1
		super(3, 1, 1);
		super.xCoord = x;
		super.yCoord = y;
	}
	
	protected void move()
	{
		/*
		 * find out if father away from player on x or y, then
		 * move close in that direction
		 * pause
		 * repeat
		 */
		
	}
	
	protected void attack()
	{
		//if within one space or on the same space
		//player health -= damage
	}
}
