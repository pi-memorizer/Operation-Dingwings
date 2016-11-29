
public class Candle extends Enemy 
{
	@Override
	public int getSpriteID()
	{
		return Main.CANDLE_ENEMY;
	}
	
	public Candle(int x, int y)
	{
		//health = 2, damage = 1, moveSpeed = 0
		super(2, 1, 0, x, y);
	}
	
	protected void move() //they don't move
	{}
	
	protected void attack()
	{
		int xDistAbs = Math.abs(Player.xCoord - this.xCoord);
		int yDistAbs = Math.abs(Player.yCoord - this.yCoord);
		
		if (xDistAbs >= 5)
		{
			if (Player.xCoord >= this.xCoord)
			{
				//Make new projectile going to the right
			}
			else
			{
				//Make new projectile going to the left
			}
		}
		else if (yDistAbs >= 5)
		{
			if (Player.yCoord >= this.yCoord)
			{
				//Make new projectile going up
			}
			else
			{
				//Make new projectile going down
			}
		}
		//fire projectile towards player if within 4-5 spaces
	}
}
