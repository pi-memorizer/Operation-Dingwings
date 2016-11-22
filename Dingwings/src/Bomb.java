
public class Bomb extends Enemy
{

	public Bomb()
	{
		super(1, 2, 0);
	}
	
	protected void move() //they don't move
	{}
	
	protected void attack()
	{
		//if player within one space, blow up, remove from world
		//player health -= damage
	}
}
