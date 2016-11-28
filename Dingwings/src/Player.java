public class Player
{
	public static int health = 5;
	
	public static int xCoord = Main.MAP_WIDTH/2; //The player's position in the x direction
	public static int yCoord = Main.MAP_HEIGHT/2; //Same for y
	//TODO implement coordinates for which room the player is in
	
	//Called when the player tries to move up
	public static void moveUp()
	{
		move(0,-1); //tries moving on a delta
	}
	
	public static void moveLeft()
	{
		move(-1,0);
	}
	
	public static void moveRight()
	{
		move(1,0);
	}
	
	public static void moveDown()
	{
		move(0,1);
	}
	
	//tries moving assuming that the player wants to move dx blocks in the right direction
	//(can be negative for left) and dy blocks in the down direction (also can be negative)
	public static void move(int dx, int dy)
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
		} else
		{
			Room newRoom = new Room();
			Main.currentRoom = newRoom;
			//TODO add code to which rooms if you walk out
			//########################################################
		}
	}
	
	//Code to call when the attack key is pressed
	public static void attack()
	{
		
	}
}