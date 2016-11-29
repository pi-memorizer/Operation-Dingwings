import java.util.*;

public class Boss extends Enemy 
{
	ArrayList<Chaser> chasers = new ArrayList<>(3);
	private boolean right;
	private boolean up;
	
	public Boss(int x, int y)
	{
		//health = 8, damage = 1, moveSpeed = 2
		super(8, 1, 2, x, y);
		right = true;
		up = false;
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
		spawnChasers();
		//shoot projectiles in one or two patterns
	}
	
	protected void spawnChasers()
	{
		if (chasers.size() == 0)
		{
		Chaser c1 = new Chaser(super.xCoord - 2, super.yCoord);
		Chaser c2 = new Chaser(super.xCoord, super.yCoord -2);
		Chaser c3 = new Chaser(super.xCoord + 2, super.yCoord);
		chasers.add(c1);
		chasers.add(c2);
		chasers.add(c3);
		}
	}
}
