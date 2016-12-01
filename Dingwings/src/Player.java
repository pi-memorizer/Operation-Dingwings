public class Player
{
	public static int health = 30;
	
	public static int xCoord = Main.MAP_WIDTH/2; //The player's position in the x direction
	public static int yCoord = Main.MAP_HEIGHT/2; //Same for y
	public static int xMap = 0;
	public static int yMap = 0;
	
	public static int direction = 0;
	public static final int UP = 0;
	public static final int DOWN = 1;
	public static final int LEFT = 2;
	public static final int RIGHT = 3;
	
	public static final int RANGE_DELAY = 10;
	public static int currentRangeDelay = 0;
	
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
			boolean b = true;
			for(Enemy e : Main.currentRoom.enemies)
			{
				if(e.xCoord==x&&e.yCoord==y)
				{
					b = false;
					break;
				}
			}
			if(Main.currentRoom.map[x][y]==Main.BLOCK_AIR&&b) //see if you can walk there
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
			}
			Main.currentRoom = newRoom;
			xMap += dx;
			yMap += dy;
			if(dx==-1) xCoord = Main.MAP_WIDTH -2;
			if(dx==1) xCoord = 1;
			if(dy==-1) yCoord = Main.MAP_HEIGHT -2;
			if(dy==1) yCoord = 1;
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
		for(Enemy e : Main.currentRoom.enemies)
		{
			if(e.xCoord==(xCoord+dx)&&e.yCoord==(yCoord+dy))
			{
				e.health--;
			}
		}
	}
	
	public static void ranged()
	{
		System.out.println("hi");
		if (currentRangeDelay > RANGE_DELAY)
		{
			System.out.println("hi");
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
			currentRangeDelay = 0;
		}
		else
		{
			currentRangeDelay++;
		}
	}
	
	public static void ranged(int dx, int dy)
	{
		Main.currentRoom.enemies.add(new Player_Projectile(xCoord+dx, yCoord+dy, dx, dy));
	}
}