
public class Bomb extends Enemy
{

	public Bomb(int x, int y)
	{
		//health = 1, damage = 2, moveSpeed = 0
		super(1, 2, 0, x, y);
	}
	
	protected void move() //they don't move
	{}
	
	protected void attack()
	{
		if ((Math.abs(super.xCoord - Player.xCoord) <= 64) || (Math.abs(super.yCoord - Player.yCoord) <= 64))
		{
			Player.health -= super.damage;
			//remove bomb
		}
	}
}
