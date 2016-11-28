
public abstract class Enemy 
{
	protected int health; //assuming all player attacks deal 1 damage
	protected boolean active;
	protected int damage;
	protected int moveSpeed; //assuming player move = 1
	
	public int xCoord;
	public int yCoord;
	
	public int getSpriteID() {return 0;}
	
	public Enemy(int h, int d, int m, int x, int y) //constructor to set health, damage,
	{										// and the enemy to alive
		health = h;
		active = true;
		damage = d;
		moveSpeed = m;
		xCoord = x;
		yCoord = y;
	}
	
	protected abstract void move(); //each enemy will have its own movement type
	
	protected abstract void attack(); //each enemy will have its own attack, but some may not
	
	protected void removeEnemy()
	{
		//delete enemy out of list and therefore stop drawing?
	}
	
	public void enemyMove(int dx, int dy)
	{
		int x = xCoord+dx;
		int y = yCoord+dy;
		if(x >=0 && y>=0 && x<Main.MAP_WIDTH && y<Main.MAP_HEIGHT) //make sure that's vaild
		{
			if(Main.currentRoom.map[x][y]==Main.BLOCK_AIR) //see if you can walk there
			{
				xCoord = x; //actually move
				yCoord = y;
			}
			//else if (Main.currentRoom.map[x][y]==Main.BLOCK_WALL)
			//{
				
			//}
		} 
	}
} //end Enemy class
