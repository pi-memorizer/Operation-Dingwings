
public class Projectile {
	public String projectileSprite;
	public static int xCoord;
	public static int yCoord;
	public static int direction;
	
	public Projectile()
	{
		projectileSprite = "Projectile-!";
		xCoord = 0;
		yCoord = 0;
		direction = 1;
	}
	
	public Projectile(String spriteName, int startXPos, int startYPos, int d)
	{
		projectileSprite = spriteName;
		xCoord = startXPos;
		yCoord = startYPos;
		direction = d;
	}
	
	
	//Copied from Player class
	public static void move(int dx, int dy)
	{
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
	}
}