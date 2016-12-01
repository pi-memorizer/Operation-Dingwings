
public class Chaser extends Enemy 
{
	int delay = 5;
	@Override
	public int getSpriteID()
	{
		return Main.CHASER_ENEMY;
	}
	
	public Chaser(int x, int y) 
	{
		//health = 3, damage = 1, moveSpeed = 1
		super(3, 1, 25, x, y);
	}
	
	protected void move()
	{
		double distance = 0;
		distance = Math.sqrt((Player.xCoord - this.xCoord)*(Player.xCoord - this.xCoord) + (Player.yCoord - this.yCoord)*(Player.yCoord - this.yCoord));
		int dx = 0;
		int dy = 0;
		if(delay>=moveSpeed)
		{
			if(Player.xCoord>xCoord)
				dx = 1;
			else if(Player.xCoord<xCoord)
				dx = -1;
			if(Player.yCoord>yCoord)
				dy = 1;
			else if(Player.yCoord<yCoord)
				dy = -1;
			enemyMove(dx, dy);
			/*
			int xDistAbs = Math.abs(Player.xCoord - this.xCoord);
			int yDistAbs = Math.abs(Player.yCoord - this.yCoord);
			int xDist = (Player.xCoord - this.xCoord);
			int yDist = (Player.yCoord - this.yCoord);
			
			if (xDistAbs > yDistAbs)
			{
				if (xDist < 0)
					super.enemyMove(1, 0);
				else
					super.enemyMove(-1, 0);
			}
			else
			{
				if (yDist < 0)
					super.enemyMove(0, 1);
				else
					super.enemyMove(0, -1);
			}
			*/
		delay = 0;
		} else {
			delay++;
		}
	}
	
	protected void attack()
	{
		if (Math.abs(Player.xCoord - super.xCoord) == 1 || Math.abs(Player.yCoord - super.yCoord) == 1)
		{
			Player.health -= super.damage;
		}
	}
}
