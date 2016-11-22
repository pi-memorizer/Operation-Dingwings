			//scissors enemy
public class Twiddle extends Enemy 
{

	public Twiddle()
	{
		//you can't kill them, so ridiculously large health or something
		super(999, 1, 3);
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
