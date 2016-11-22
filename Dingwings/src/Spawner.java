
public class Spawner extends Enemy 
{
	final double SPAWN_RATE = .05;
	
	public Spawner(int x, int y)
	{
		//health = 2, damage = 0, moveSpeed = 2
		super(2, 0, 2);
		super.xCoord = x;
		super.yCoord = y;
	}
	
	protected void move()
	{
		//random movement
	}
	
	protected void attack()
	{
		//5% chance to spawn a random enemy in front of spawner
	}
}
