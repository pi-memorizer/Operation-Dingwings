			//scissors enemy
public class Twiddle extends Enemy 
{

	public Twiddle(int x, int y)
	{
		//you can't kill them, so ridiculously large health or something
		//health = MANY, damage = 1, moveSpeed = 3
		super(999, 1, 3);
		super.xCoord = x;
		super.yCoord = y;
	}
	
	protected void move()
	{
		/*
		 * move in one direction until hit wall
		 * reverse direction
		 * repeat
		 */
	}
	
	protected void attack()
	{
		//if player is in fromt of twiddle
		//player health -= damage
	}
}
