
public abstract class Enemy 
{
	protected int health;
	protected boolean active;
	protected int damage;
	protected int moveSpeed; //assuming player move = 1
	
	public Enemy(int h, int d, int m) //constructor to set health, damage,
	{										// and the enemy to alive
		health = h;
		active = true;
		damage = d;
		moveSpeed = m;
	}
	
	protected abstract void move(); //each enemy will have its own movement type
	
	protected abstract void attack(); //each enemy will have its own attack, but some may not
	
	protected void removeEnemy()
	{
		//delete enemy out of list and therefore stop drawing?
	}
} //end Enemy class
