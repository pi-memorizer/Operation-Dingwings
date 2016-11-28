public class Player
{
	public static int health = 5;
	
	public static int xCoord = Main.MAP_WIDTH/2; //The player's position in the x direction
	public static int yCoord = Main.MAP_HEIGHT/2; //Same for y
	public static int xMap = 0;
	public static int yMap = 0;
	
	
	public static int direction = 0;
	public static final int UP = 0;
	public static final int DOWN = 1;
	public static final int LEFT = 2;
	public static final int RIGHT = 3;
	//TODO implement coordinates for which room the player is in
	
	//Called when the player tries to move up
	public static void moveUp()
	{
		move(0,-1); //tries moving on a delta
		direction = UP;
	}
	
	public static void moveLeft()
	{
		move(-1,0);
		direction = LEFT;
	}
	
	public static void moveRight()
	{
		move(1,0);
		direction = RIGHT;
	}
	
	public static void moveDown()
	{
		move(0,1);
		direction = DOWN;
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
			Room newRoom = Room.roomMap.get((dx+xMap) + "," + (dy+yMap));
			if(newRoom==null)
			{
				newRoom = new Room(dx+xMap,dy+yMap);
				System.out.println("Hi");
			}
			Main.currentRoom = newRoom;
			xMap += dx;
			yMap += dy;
			if(dx==-1) xCoord = Main.MAP_WIDTH -1;
			if(dx==1) xCoord = 0;
			if(dy==-1) yCoord = Main.MAP_HEIGHT -1;
			if(dy==1) yCoord = 0;
			//TODO add code to which rooms if you walk out
			//########################################################
		}
	}
	
		
	//Code to call when the attack key is pressed
	public static void attack()
	{
		switch(direction)
		{
		case UP:
			attack(0,-1);
			break;
		case DOWN:
			attack(0,1);
			break;
		case LEFT:
			attack(-1,0);
			break;
		case RIGHT:
			attack(1,0);
			break;
		}
	}
	
	public static void attack(int dx, int dy)
	{
		
	}
	
	public static void ranged()
	{
		switch(direction)
		{
		case UP:
			ranged(0,-1);
			break;
		case DOWN:
			ranged(0,1);
			break;
		case LEFT:
			ranged(-1,0);
			break;
		case RIGHT:
			ranged(1,0);
			break;
		}
	}
	
	public static void ranged(int dx, int dy)
	{
		
	}
}