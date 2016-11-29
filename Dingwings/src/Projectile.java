/*Direction Information:
 * 1 = Right
 * 2 = Down
 * 3 = Left
 * 4 = Up
 */
public class Projectile extends Enemy{
	public String projectileSprite;
	public static int xCoord;
	public static int yCoord;
	public static int direction;
	
	public Projectile()
	{
		super();
		projectileSprite = "Projectile-R";
		xCoord = 0;
		yCoord = 0;
		direction = 1;
	}
	
	public Projectile(int startXPos, int startYPos, int d)
	{
		super(1, 1, 1, startXPos, startYPos);
		projectileSprite = "Projectile-R";
		xCoord = startXPos;
		yCoord = startYPos;
		direction = d;
	}
	
	
	//Copied from Player class
	@Override
	protected void move()
	{
		switch (direction)
		{
			case 1:
				super.enemyMove(1,0);
				break;
			case 2:
				super.enemyMove(0, -1);
				break;
			case 3:
				super.enemyMove(-1,  0);
				break;
			case 4:
				super.enemyMove(0,  1);
				break;
			default:
				super.enemyMove(0, 0);
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
