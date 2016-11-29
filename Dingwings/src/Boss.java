import java.util.*;

public class Boss extends Enemy 
{
	ArrayList<Chaser> chasers = new ArrayList<>(3);
	private boolean right;
	private boolean up;
	private boolean switchDirections;
	
	public Boss(int x, int y)
	{
		//health = 8, damage = 1, moveSpeed = 2
		super(8, 1, 2, x, y);
		right = true;
		up = false;
		switchDirections = false;
	}
	
	protected void move()
	{
		Random r = new Random();
		int val = r.nextInt(1000);
		if (val < 500)
		{
			if (right)
			{
				super.enemyMove(1, 0);
				if (Main.currentRoom.map[super.xCoord + 1][super.yCoord]==Main.BLOCK_WALL)
				{
					right = false;
				}
			}
			else
			{
				super.enemyMove(-1, 0);
				if (Main.currentRoom.map[super.xCoord - 1][super.yCoord]==Main.BLOCK_WALL)
				{
					right = true;
				}
			}
		}
		else
		{
			if (up)
			{
				super.enemyMove(0, 1);
				if (Main.currentRoom.map[super.xCoord][super.yCoord + 1]==Main.BLOCK_WALL)
				{
					up = false;
				}
			}
			else
			{
				super.enemyMove(0, -1);
				if (Main.currentRoom.map[super.xCoord][super.yCoord - 1]==Main.BLOCK_WALL)
				{
					up = true;
				}
			}
		}
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
