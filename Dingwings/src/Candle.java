
public class Candle extends Enemy 
{

	public Candle(int x, int y)
	{
		//health = 2, damage = 1, moveSpeed = 0
		super(2, 1, 0);
		super.xCoord = x;
		super.yCoord = y;
	}
	
	protected void move() //they don't move
	{}
	
	protected void attack()
	{
		//fire projectile towards player if within 4-5 spaces
	}
}
