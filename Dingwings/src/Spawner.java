
public class Spawner extends Enemy 
{
	final double SPAWN_RATE = .05;
	
	public Spawner()
	{
		super(2, 0, 2);
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
