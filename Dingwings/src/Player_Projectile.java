
public class Player_Projectile extends Enemy{
	public String projectileSprite;
	public int dx, dy, xCoord, yCoord;
	
	public Player_Projectile()
	{
		super();
		projectileSprite = "New Projectile";
		xCoord = 0;
		yCoord = 0;
	}
	
	public Player_Projectile(int startXPos, int startYPos, int dx, int dy)
	{
		super(1, 1, 1, startXPos, startYPos);
		projectileSprite = "New Projectile";
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
			}
		} else health = 0;
	}
	
	@Override
	protected void attack()
	{
		for(Enemy e : Main.currentRoom.enemies)
		{
			if(e.xCoord==(xCoord)&&e.yCoord==(yCoord))
			{
				e.health--;
				health = 0;
			}
		}
	}
}
