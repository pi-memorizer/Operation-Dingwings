/*Direction Information:
 * 1 = Right
 * 2 = Down
 * 3 = Left
 * 4 = Up
 */
public class Projectile extends Enemy{
	public String projectileSprite;
	public int dx, dy;
	
	public Projectile()
	{
		super();
		projectileSprite = "Projectile-R";
		xCoord = 0;
		yCoord = 0;
	}
	
	public Projectile(int startXPos, int startYPos, int dx, int dy)
	{
		super(1, 1, 1, startXPos, startYPos);
		projectileSprite = "Projectile-R";
		xCoord = startXPos;
		yCoord = startYPos;
		this.dx = dx;
		this.dy = dy;
	}
	
	@Override
	public int getSpriteID()
	{
		return Main.PROJECTILE_CANDLE;
	}
	
	//Copied from Player class
	@Override
	protected void move()
	{
		int _x = xCoord;
		int _y = yCoord;
		enemyMove(dx,dy);
		if(_x==xCoord&&_y==yCoord)
		{
			health = 0;
		}
		/*
		int x = xCoord+dx;
		int y = yCoord+dy;
		//Need to fix this so it works
		if(x>=0&&y>=0&&x<Main.MAP_WIDTH&&y<Main.MAP_HEIGHT) //make sure that's vaild
		{
			if(Main.currentRoom.map[x][y]== Main.BLOCK_AIR || Main.currentRoom.map[x][y] == Main.SPRITE_PLAYER) //see if you can walk there
			{
				xCoord = x;
				yCoord = y;
			}
		}
		*/
	}
	
	@Override
	protected void attack()
	{
		if (Player.xCoord == this.xCoord && Player.yCoord == this.yCoord)
		{
			Player.health -= super.damage;
		}
	}
}
