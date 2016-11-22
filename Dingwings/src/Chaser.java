
public class Chaser extends Enemy 
{
	
	public Chaser() 
	{
		super(3, 1, 1);
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
