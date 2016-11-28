import java.util.*;

public class Spawner extends Enemy 
{
	final double SPAWN_RATE = .05;
	
	public Spawner(int x, int y)
	{
		//health = 2, damage = 0, moveSpeed = 2
		super(2, 0, 2, x, y);
	}
	
	protected void move()
	{
		Random r = new Random();
		int num = r.nextInt(4);
		if (num == 0)
			enemyMove(1,0);
		else if (num == 1)
			enemyMove(-1, 0);
		else if (num == 2)
			enemyMove(0,1);
		else if (num == 3)
			enemyMove(0, -1);
	}
	
	protected void attack()
	{
		//5% chance to spawn a random enemy in front of spawner
		Random r = new Random();
		int num = r.nextInt(100);
		if (num < 4)
		{
			int val = r.nextInt(5);
			if (val == 0)
			{
				//spawn candle
			}
			else if (val == 1)
			{
				//spawn bomb
			}
			else if (val == 2)
			{
				//spawn twiddle
			}
			else if (val == 3)
			{
				//spawn chaser
			}
			else if (val == 4)
			{
				//spawn spawner
			}
		}
	}
}
