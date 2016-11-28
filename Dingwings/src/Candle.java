
public class Candle extends Enemy 
{

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
		//int xDist = (Player.xCoord - this.xCoord);
		//int yDist = (Player.yCoord - this.yCoord);
		
		if (xDistAbs >= 5)
		{
			//Shoot something horizontally
		}
		else if (yDistAbs >= 5)
		{
			//Shoot something vertically
		}
		//fire projectile towards player if within 4-5 spaces
	}
}
