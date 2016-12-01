
public class Player_Projectile extends Enemy{
	public int dx, dy;
	
	public Player_Projectile()
	{
		super();
		xCoord = 0;
		yCoord = 0;
	}
	
	public Player_Projectile(int startXPos, int startYPos, int dx, int dy)
	{
		super(1, 1, 1, startXPos, startYPos);
		xCoord = startXPos;
		yCoord = startYPos;
		this.dx = dx;
		this.dy = dy;
	}
	
	public int getSpriteID()
	{
		return Main.PROJECTILE_RANGE_ATTACK;
	}
	
	@Override
	protected void move()
	{
		int x = xCoord+dx;
		int y = yCoord+dy;
		if(x >=0 && y>=0 && x<Main.MAP_WIDTH && y<Main.MAP_HEIGHT) //make sure that's vaild
		{
			if(Main.currentRoom.map[x][y]==Main.BLOCK_AIR) //see if you can walk there
			{
				xCoord = x; //actually move
				yCoord = y;
			} else health = 0;
		} else health = 0;
		attack();
	}
	
	@Override
	protected void attack()
	{
		for(Enemy e : Main.currentRoom.enemies)
		{
			if(e!=this&&e.xCoord==(xCoord)&&e.yCoord==(yCoord))
			{
				e.health--;
				health = 0;
			}
		}
	}
}
