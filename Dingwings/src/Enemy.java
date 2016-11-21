
public abstract class Enemy 
{
	protected int health;
	protected boolean active;
	protected int damage;
	
	public Enemy(int h, int d) //constructor to set health, damage,
	{										// and the enemy to alive
		health = h;
		active = true;
		damage = d;
	}
	
	protected abstract void move(); //each enemy will have its own movement type
	
	protected abstract void attack(); //each enemy will have its own attack, but some may not
	
	protected void removeEnemy()
	{
		//delete enemy out of list and therefore stop drawing?
	}
} //end Enemy class
