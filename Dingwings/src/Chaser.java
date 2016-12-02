
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
		//health = 3, damage = 4, moveSpeed = 1
		super(3, 4, 25, x, y);
	}
	
	protected void move()
	{
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
		delay = 0;
		} else {
			delay++;
		}
	}
	
	protected void attack()
	{
		if (Math.abs(Player.xCoord - super.xCoord) <= 1 && Math.abs(Player.yCoord - super.yCoord) <= 1)
		{
			Player.health -= super.damage;
		}
	}
}
