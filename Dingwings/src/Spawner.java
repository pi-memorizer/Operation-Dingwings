import java.util.*;

public class Spawner extends Enemy 
{
	final double SPAWN_RATE = .05;
	
	@Override
	public int getSpriteID()
	{
		return Main.SPAWNER_ENEMY;
	}
	
	public Spawner(int x, int y)
	{
		//health = 2, damage = 0, moveSpeed = 2
		super(2, 0, 2, x, y);
	}
	
	protected void move()
	{
		Random r = new Random();
		int num = r.nextInt(4000);
		if (num < 1000)
			enemyMove(1,0);
		else if (num < 2000)
			enemyMove(-1, 0);
		else if (num < 3000)
			enemyMove(0,1);
		else if (num < 4000)
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
				if (Main.currentRoom.map[super.xCoord + 1][super.yCoord + 1] == Main.BLOCK_AIR)
				{
				Candle candle = new Candle(super.xCoord + 1, super.yCoord + 1);
				Main.currentRoom.enemies.add(candle);
				}
			}
			else if (val == 1)
			{
				if (Main.currentRoom.map[super.xCoord + 1][super.yCoord + 1] == Main.BLOCK_AIR)
				{
				Bomb bomb = new Bomb(super.xCoord + 1, super.yCoord + 1);
				Main.currentRoom.enemies.add(bomb);
				}
			}
			else if (val == 2)
			{
				if (Main.currentRoom.map[super.xCoord + 1][super.yCoord + 1] == Main.BLOCK_AIR)
				{
				Twiddle twiddle = new Twiddle(super.xCoord + 1, super.yCoord + 1);
				Main.currentRoom.enemies.add(twiddle);
				}
			}
			else if (val == 3)
			{
				if (Main.currentRoom.map[super.xCoord + 1][super.yCoord + 1] == Main.BLOCK_AIR)
				{
				Chaser chaser = new Chaser(super.xCoord + 1, super.yCoord + 1);
				Main.currentRoom.enemies.add(chaser);
				}
			}
			else if (val == 4)
			{
				if (Main.currentRoom.map[super.xCoord + 1][super.yCoord + 1] == Main.BLOCK_AIR)
				{
				Spawner spawner = new Spawner(super.xCoord + 1, super.yCoord + 1);
				Main.currentRoom.enemies.add(spawner);
				}
			}
		}
	}
}
