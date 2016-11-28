import java.util.*;

public class Boss extends Enemy 
{
	ArrayList<Chaser> chasers = new ArrayList<>(3);
	
	public Boss(int x, int y)
	{
		//health = 8, damage = 1, moveSpeed = 2
		super(8, 1, 2, x, y);
	}
	
	protected void move()
	{
		//move like twiddle, but randomly switches between left/right and up/down
	}
	
	protected void attack()
	{
		//shoot projectiles in one or two patterns
	}
	
	protected void spawnChasers()
	{
		//add three chasers into boss's arraylist
		//will need a check somewhere for when that arraylist is empty 
		//to spawn 3 more
	}
}
