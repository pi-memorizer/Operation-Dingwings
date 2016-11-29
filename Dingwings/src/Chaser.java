
public class Chaser extends Enemy 
{
	@Override
	public int getSpriteID()
	{
		return Main.CHASER_ENEMY;
	}
	
	public Chaser(int x, int y) 
	{
		//health = 3, damage = 1, moveSpeed = 1
		super(3, 1, 1, x, y);
	}
	
	protected void move()
	{
		int xDistAbs = Math.abs(Player.xCoord - super.xCoord);
		int yDistAbs = Math.abs(Player.yCoord - super.yCoord);
		int xDist = (Player.xCoord - super.xCoord);
		int yDist = (Player.yCoord - super.yCoord);
		
		if (xDistAbs > yDistAbs)
		{
			//Reece you're an idiot - if you move by xDist it could move like 6
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
	}
	
	protected void attack()
	{
		if (Math.abs(Player.xCoord - super.xCoord) == 1 || Math.abs(Player.yCoord - super.yCoord) == 1)
		{
			Player.health -= super.damage;
		}
	}
}
