import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Room
{
	public boolean exitTop;
	public boolean exitLeft;
	public boolean exitRight;
	public boolean exitBottom;
	public int currentRoomX;
	public int currentRoomY;
	int [][] map = new int[Main.MAP_WIDTH][Main.MAP_HEIGHT]; //The rooms map array of sprite indices
	
	public static HashMap <String, Room> roomMap = new HashMap <String, Room>();
		// add room to hashamp (each room is predetermined
		// once we enter a new room, generate room from hashmap
	
	public ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	
	public Room(int x, int y)
	{
		currentRoomX = x;
		currentRoomY = y;
		makeRoom();
		roomMap.put(x + "," + y, this);
		enemies.add(new Bomb(5,5));
		enemies.add(new Candle(10,5));
		enemies.add(new Boss(5,10));
		enemies.add(new Spawner(10,10));
		enemies.add(new Twiddle(1,1));
		enemies.add(new Chaser(10,1));
	}
	
	private void makeRoom()
	{
		if (Player.xCoord == Main.MAP_WIDTH/2 && Player.yCoord == Main.MAP_HEIGHT/2)
		{
			for(int x = 0; x < Main.MAP_WIDTH; x++)
			{
				for(int y = 0; y < Main.MAP_HEIGHT; y++)
				{
					if(y== Main.MAP_HEIGHT-1)
						map[x][y] = Main.BLOCK_WALL;
					else
						map[x][y] = Main.BLOCK_AIR;
					if (y==0 && x!=Main.MAP_WIDTH/2)
						map[x][y] = Main.BLOCK_WALL;
					if (y==0 && x==Main.MAP_WIDTH/2)
						map[x][y] = Main.BLOCK_AIR;
					if (x==Main.MAP_WIDTH-1 && y!=Main.MAP_HEIGHT/2)
						map[x][y] = Main.BLOCK_WALL;
					if (x==Main.MAP_WIDTH-1 && y==Main.MAP_HEIGHT/2)
						map[x][y] = Main.BLOCK_AIR;
					if (x==0 && y!=Main.MAP_HEIGHT/2)
						map[x][y] = Main.BLOCK_WALL;
					if (x==0 && y==Main.MAP_HEIGHT/2)
						map[x][y] = Main.BLOCK_AIR;
					if (y==Main.MAP_HEIGHT-1 && x!=Main.MAP_WIDTH/2)
						map[x][y] = Main.BLOCK_WALL;
					if (y==Main.MAP_HEIGHT-1 && x==Main.MAP_WIDTH/2)
						map[x][y] = Main.BLOCK_AIR;
				}
			}
			exitTop = true;
			exitLeft = true;
			exitBottom = true;
			exitRight = true;
		}
		Random r = new Random();
		int w = r.nextInt(8); // change this number depending on the number of options. 
		//Change this number to mess with percentages as well
		
		if (Player.xCoord == Main.MAP_WIDTH-1)
			//########################################################################################
			//this will be used to only generate rooms with openings on the left
			//########################################################################################
		{
			Player.xCoord = 1;
			switch(w)
			{
			case 0: {//initialize with walls on all sides but left has pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(y==0||x==Main.MAP_WIDTH-1||y==Main.MAP_HEIGHT-1)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if (x==0 && y!= Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==0 && y== Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				exitTop = false;
				exitLeft = true;
				exitBottom = false;
				exitRight = false;
				break;
				}
			case 1: {//initialize with walls on all sides but bottom and left have pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(y==0||x==Main.MAP_WIDTH-1)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if ( y== Main.MAP_HEIGHT - 1 && x != Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y== Main.MAP_HEIGHT - 1 && x == Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==0 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==0 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				exitTop = false;
				exitLeft = true;
				exitBottom = true;
				exitRight = false;
				break;
				}
			case 2: {//initialize with walls on all sides but right and left have pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(y==0||y==Main.MAP_HEIGHT-1)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if ( x== Main.MAP_WIDTH - 1 && y != Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x== Main.MAP_WIDTH - 1 && y == Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==0 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==0 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				exitTop = false;
				exitLeft = true;
				exitBottom = false;
				exitRight = true;
				break;
				}
			case 3: {//initialize with walls on all sides but top and left have pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(x== Main.MAP_WIDTH - 1||y==Main.MAP_HEIGHT-1)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if ( y==0 && x != Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y==0 && x == Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==0 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==0 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				exitTop = true;
				exitLeft = true;
				exitBottom = false;
				exitRight = false;
				break;
				}
			case 4: {//initialize with walls on all sides but bottom, top, and left have pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(x==Main.MAP_WIDTH-1)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if ( y== Main.MAP_HEIGHT - 1 && x != Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y== Main.MAP_HEIGHT - 1 && x == Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
						if (y==0 && x!=Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y==0 && x==Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==0 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==0 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				exitTop = true;
				exitLeft = true;
				exitBottom = true;
				exitRight = false;
				break;
				}
			case 5: 	{//initialize with walls on all sides but bottom, right, and left have pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(y==0)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if (y== Main.MAP_HEIGHT-1 && x!=Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y== Main.MAP_HEIGHT-1 && x==Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==Main.MAP_WIDTH-1 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==Main.MAP_WIDTH-1 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==0 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==0 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				exitTop = false;
				exitLeft = true;
				exitBottom = true;
				exitRight = true;
				break;
				}
			case 6: {//initialize with walls on all sides but top, right, and left have pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(y== Main.MAP_HEIGHT-1)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if (y==0 && x!=Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y==0 && x==Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==Main.MAP_WIDTH-1 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==Main.MAP_WIDTH-1 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==0 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==0 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				exitTop = true;
				exitLeft = true;
				exitBottom = false;
				exitRight = true;
				break;
				}
			case 7: {//initialize with walls on all sides but all sides have pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(y== Main.MAP_HEIGHT-1)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if (y==0 && x!=Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y==0 && x==Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==Main.MAP_WIDTH-1 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==Main.MAP_WIDTH-1 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==0 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==0 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
						if (y==Main.MAP_HEIGHT-1 && x!=Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y==Main.MAP_HEIGHT-1 && x==Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				exitTop = true;
				exitLeft = true;
				exitBottom = true;
				exitRight = true;
				break;
				}
		}
		}
		else if (Player.xCoord == 0)
			//########################################################################################
			//this will be used to only generate rooms with openings on the right
			//########################################################################################
		{
			//Coord.mapX = Coord.mapX + 1;
			Player.xCoord = Main.MAP_WIDTH-2;
			switch(w)
			{
			case 0: {//initialize with walls on all sides but right has pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(x==0||y==0||y==Main.MAP_HEIGHT-1)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if (x == Main.MAP_WIDTH - 1 && y != Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x == Main.MAP_WIDTH - 1 && y == Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				exitTop = false;
				exitLeft = false;
				exitBottom = false;
				exitRight = true;
				break;
				}
			case 1: {//initialize with walls on all sides but right and left have pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(y==0||y==Main.MAP_HEIGHT-1)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if ( x== Main.MAP_WIDTH - 1 && y != Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x== Main.MAP_WIDTH - 1 && y == Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==0 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==0 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				exitTop = false;
				exitLeft = true;
				exitBottom = false;
				exitRight = true;
				break;
				}
			case 2: {//initialize with walls on all sides but top and right have pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(x== 0||y==Main.MAP_HEIGHT-1)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if ( y==0 && x != Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y==0 && x == Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==Main.MAP_WIDTH - 1 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==Main.MAP_WIDTH - 1 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				exitTop = true;
				exitLeft = false;
				exitBottom = false;
				exitRight = true;
				break;
				}
			case 3: {//initialize with walls on all sides but bottom and right have pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(x== 0||y==0)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if ( y==Main.MAP_HEIGHT-1 && x != Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y==Main.MAP_HEIGHT-1 && x == Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==Main.MAP_WIDTH - 1 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==Main.MAP_WIDTH - 1 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				exitTop = false;
				exitLeft = false;
				exitBottom = true;
				exitRight = true;
				break;
				}
			case 4: {//initialize with walls on all sides but bottom, top, and right have pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(x==0)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if ( y== Main.MAP_HEIGHT - 1 && x != Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y== Main.MAP_HEIGHT - 1 && x == Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
						if (y==0 && x!=Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y==0 && x==Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==Main.MAP_WIDTH-1 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==Main.MAP_WIDTH-1 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				exitTop = true;
				exitLeft = false;
				exitBottom = true;
				exitRight = true;
				break;
				}
			case 5: 	{//initialize with walls on all sides but bottom, right, and left have pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(y==0)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if (y== Main.MAP_HEIGHT-1 && x!=Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y== Main.MAP_HEIGHT-1 && x==Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==Main.MAP_WIDTH-1 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==Main.MAP_WIDTH-1 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==0 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==0 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				exitTop = false;
				exitLeft = true;
				exitBottom = true;
				exitRight = true;
				break;
				}
			case 6: {//initialize with walls on all sides but top, right, and left have pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(y== Main.MAP_HEIGHT-1)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if (y==0 && x!=Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y==0 && x==Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==Main.MAP_WIDTH-1 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==Main.MAP_WIDTH-1 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==0 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==0 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				exitTop = true;
				exitLeft = true;
				exitBottom = false;
				exitRight = true;
				break;
				}
			case 7: {//initialize with walls on all sides but all sides have pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(y== Main.MAP_HEIGHT-1)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if (y==0 && x!=Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y==0 && x==Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==Main.MAP_WIDTH-1 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==Main.MAP_WIDTH-1 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==0 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==0 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
						if (y==Main.MAP_HEIGHT-1 && x!=Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y==Main.MAP_HEIGHT-1 && x==Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				exitTop = true;
				exitLeft = true;
				exitBottom = true;
				exitRight = true;
				break;
				}
			}
		}
		else if (Player.yCoord == Main.MAP_HEIGHT - 1)
			//########################################################################################
			//this will be used to only generate rooms with openings on the top
			//########################################################################################
		{
			Player.yCoord = 1;
			switch(w)
			{
			case 0: {//initialize with walls on all sides but top has pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(x==0||x==Main.MAP_WIDTH-1||y==Main.MAP_HEIGHT-1)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if (y == 0 && x!=Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y==0 && x==Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				exitTop = true;
				exitLeft = false;
				exitBottom = false;
				exitRight = false;
				break;
				}
			case 1: {//initialize with walls on all sides but bottom and top have pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(x==0||x==Main.MAP_WIDTH-1)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if ( y== Main.MAP_HEIGHT - 1 && x != Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y== Main.MAP_HEIGHT - 1 && x == Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
						if (y==0 && x!=Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y==0 && x==Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				exitTop = true;
				exitLeft = false;
				exitBottom = true;
				exitRight = false;
				break;
				}
			case 2: {//initialize with walls on all sides but top and left have pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(x== Main.MAP_WIDTH - 1||y==Main.MAP_HEIGHT-1)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if ( y==0 && x != Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y==0 && x == Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==0 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==0 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				exitTop = true;
				exitLeft = true;
				exitBottom = false;
				exitRight = false;
				break;
				}
			case 3: {//initialize with walls on all sides but top and right have pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(x== 0||y==Main.MAP_HEIGHT-1)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if ( y==0 && x != Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y==0 && x == Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==Main.MAP_WIDTH - 1 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==Main.MAP_WIDTH - 1 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				exitTop = true;
				exitLeft = false;
				exitBottom = false;
				exitRight = true;
				break;
				}
			case 4: {//initialize with walls on all sides but bottom, top, and right have pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(x==0)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if ( y== Main.MAP_HEIGHT - 1 && x != Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y== Main.MAP_HEIGHT - 1 && x == Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
						if (y==0 && x!=Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y==0 && x==Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==Main.MAP_WIDTH-1 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==Main.MAP_WIDTH-1 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				exitTop = true;
				exitLeft = false;
				exitBottom = true;
				exitRight = true;
				break;
				}
			case 5: {//initialize with walls on all sides but bottom, top, and left have pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(x==Main.MAP_WIDTH-1)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if ( y== Main.MAP_HEIGHT - 1 && x != Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y== Main.MAP_HEIGHT - 1 && x == Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
						if (y==0 && x!=Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y==0 && x==Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==0 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==0 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				exitTop = true;
				exitLeft = true;
				exitBottom = true;
				exitRight = false;
				break;
				}
			case 6: {//initialize with walls on all sides but top, right, and left have pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(y== Main.MAP_HEIGHT-1)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if (y==0 && x!=Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y==0 && x==Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==Main.MAP_WIDTH-1 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==Main.MAP_WIDTH-1 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==0 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==0 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				exitTop = true;
				exitLeft = true;
				exitBottom = false;
				exitRight = true;
				break;
				}
			case 7: {//initialize with walls on all sides but all sides have pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(y== Main.MAP_HEIGHT-1)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if (y==0 && x!=Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y==0 && x==Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==Main.MAP_WIDTH-1 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==Main.MAP_WIDTH-1 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==0 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==0 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
						if (y==Main.MAP_HEIGHT-1 && x!=Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y==Main.MAP_HEIGHT-1 && x==Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				exitTop = true;
				exitLeft = true;
				exitBottom = true;
				exitRight = true;
				break;
				}
			}
		}
		else if (Player.yCoord == 0)
			//########################################################################################
			//this will be used to only generate rooms with openings on the bottom
			//########################################################################################
		{
			Player.yCoord = Main.MAP_HEIGHT-2;
			switch(w)
			{
			case 0: {//initialize with walls on all sides but bottom has pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(x==0||y==0||x==Main.MAP_WIDTH-1)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if (y== Main.MAP_HEIGHT - 1 && x != Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y== Main.MAP_HEIGHT - 1 && x == Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				exitTop = false;
				exitLeft = false;
				exitBottom = true;
				exitRight = false;
				break;
				}
			case 1: {//initialize with walls on all sides but bottom and top have pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(x==0||x==Main.MAP_WIDTH-1)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if ( y== Main.MAP_HEIGHT - 1 && x != Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y== Main.MAP_HEIGHT - 1 && x == Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
						if (y==0 && x!=Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y==0 && x==Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				exitTop = true;
				exitLeft = false;
				exitBottom = true;
				exitRight = false;
				break;
				}
			case 2: {//initialize with walls on all sides but bottom and left have pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(y==0||x==Main.MAP_WIDTH-1)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if ( y== Main.MAP_HEIGHT - 1 && x != Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y== Main.MAP_HEIGHT - 1 && x == Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==0 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==0 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				exitTop = false;
				exitLeft = true;
				exitBottom = true;
				exitRight = false;
				break;
				}
			case 3: {//initialize with walls on all sides but bottom and right have pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(x== 0||y==0)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if ( y==Main.MAP_HEIGHT-1 && x != Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y==Main.MAP_HEIGHT-1 && x == Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==Main.MAP_WIDTH - 1 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==Main.MAP_WIDTH - 1 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				exitTop = false;
				exitLeft = false;
				exitBottom = true;
				exitRight = true;
				break;
				}
			case 4: {//initialize with walls on all sides but bottom, top, and right have pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(x==0)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if ( y== Main.MAP_HEIGHT - 1 && x != Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y== Main.MAP_HEIGHT - 1 && x == Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
						if (y==0 && x!=Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y==0 && x==Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==Main.MAP_WIDTH-1 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==Main.MAP_WIDTH-1 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				exitTop = true;
				exitLeft = false;
				exitBottom = true;
				exitRight = true;
				break;
				}
			case 5: {//initialize with walls on all sides but bottom, top, and left have pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(x==Main.MAP_WIDTH-1)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if ( y== Main.MAP_HEIGHT - 1 && x != Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y== Main.MAP_HEIGHT - 1 && x == Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
						if (y==0 && x!=Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y==0 && x==Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==0 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==0 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				exitTop = true;
				exitLeft = true;
				exitBottom = true;
				exitRight = false;
				break;
				}
			case 6: 	{//initialize with walls on all sides but bottom, right, and left have pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(y==0)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if (y== Main.MAP_HEIGHT-1 && x!=Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y== Main.MAP_HEIGHT-1 && x==Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==Main.MAP_WIDTH-1 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==Main.MAP_WIDTH-1 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==0 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==0 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				exitTop = false;
				exitLeft = true;
				exitBottom = true;
				exitRight = true;
				break;
				}
			case 7: {//initialize with walls on all sides but all sides have pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(y== Main.MAP_HEIGHT-1)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if (y==0 && x!=Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y==0 && x==Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==Main.MAP_WIDTH-1 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==Main.MAP_WIDTH-1 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==0 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==0 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
						if (y==Main.MAP_HEIGHT-1 && x!=Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y==Main.MAP_HEIGHT-1 && x==Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				exitTop = true;
				exitLeft = true;
				exitBottom = true;
				exitRight = true;
				break;
				}
			}
		}
		Room r1 = Room.roomMap.get((Player.xMap-1) + "," + Player.yMap);
		if (r1 != null)
		{
			int block = Main.BLOCK_AIR;
			if (r1.exitLeft==false)
			{
				block = Main.BLOCK_WALL;
			}
			map[0][Main.MAP_HEIGHT/2] = block;
		}
		r1 = Room.roomMap.get((Player.xMap+1) + "," + Player.yMap);
		if (r1 != null)
		{
			int block = Main.BLOCK_AIR;
			if(r1.exitRight==false)
			{
				block = Main.BLOCK_WALL;
			}
			map[Main.MAP_WIDTH-1][Main.MAP_HEIGHT/2] = block;
		}
		r1 = Room.roomMap.get(Player.xMap + "," + (Player.yMap-1));
		if (r1 != null)
		{
			int block = Main.BLOCK_AIR;
			if(r1.exitTop==false)
			{
				block = Main.BLOCK_WALL;
			}
			map[Main.MAP_WIDTH/2][0] = block;
		}
		r1 = Room.roomMap.get(Player.xMap + "," + (Player.yMap+1));
		if (r1 != null)
		{
			int block = Main.BLOCK_AIR;
			if(r1.exitBottom==false)
			{
				block = Main.BLOCK_WALL;
			}
			map[Main.MAP_WIDTH/2][Main.MAP_HEIGHT-1] = block;
		}
/*
		switch(w)
		{
		//This case should never be randomly generated, which is why it is case -1
		case -1: {//initialize with walls on all sides
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(x==0||y==0||x==Main.MAP_WIDTH-1||y==Main.MAP_HEIGHT-1)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				break;
				}
		case 0: {//initialize with walls on all sides but top has pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(x==0||x==Main.MAP_WIDTH-1||y==Main.MAP_HEIGHT-1)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if (y == 0 && x!=Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y==0 && x==Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				break;
				}
		case 1: {//initialize with walls on all sides but bottom has pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(x==0||y==0||x==Main.MAP_WIDTH-1)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if (y== Main.MAP_HEIGHT - 1 && x != Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y== Main.MAP_HEIGHT - 1 && x == Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				break;
				}
		case 2: {//initialize with walls on all sides but left has pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(y==0||x==Main.MAP_WIDTH-1||y==Main.MAP_HEIGHT-1)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if (x==0 && y!= Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==0 && y== Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				break;
				}
		case 3: {//initialize with walls on all sides but right has pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(x==0||y==0||y==Main.MAP_HEIGHT-1)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if (x == Main.MAP_WIDTH - 1 && y != Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x == Main.MAP_WIDTH - 1 && y == Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				break;
				}
		case 4: {//initialize with walls on all sides but bottom and top have pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(x==0||x==Main.MAP_WIDTH-1)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if ( y== Main.MAP_HEIGHT - 1 && x != Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y== Main.MAP_HEIGHT - 1 && x == Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
						if (y==0 && x!=Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y==0 && x==Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				break;
				}
		case 5: {//initialize with walls on all sides but bottom and left have pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(y==0||x==Main.MAP_WIDTH-1)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if ( y== Main.MAP_HEIGHT - 1 && x != Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y== Main.MAP_HEIGHT - 1 && x == Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==0 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==0 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				break;
				}
		case 6: {//initialize with walls on all sides but right and left have pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(y==0||y==Main.MAP_HEIGHT-1)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if ( x== Main.MAP_WIDTH - 1 && y != Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x== Main.MAP_WIDTH - 1 && y == Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==0 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==0 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				break;
				}
		case 7: {//initialize with walls on all sides but top and left have pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(x== Main.MAP_WIDTH - 1||y==Main.MAP_HEIGHT-1)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if ( y==0 && x != Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y==0 && x == Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==0 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==0 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				break;
				}
		case 8: {//initialize with walls on all sides but top and right have pathway
					for(int x = 0; x < Main.MAP_WIDTH; x++)
					{
						for(int y = 0; y < Main.MAP_HEIGHT; y++)
						{
							if(x== 0||y==Main.MAP_HEIGHT-1)
								map[x][y] = Main.BLOCK_WALL;
							else
								map[x][y] = Main.BLOCK_AIR;
							if ( y==0 && x != Main.MAP_WIDTH/2)
								map[x][y] = Main.BLOCK_WALL;
							if (y==0 && x == Main.MAP_WIDTH/2)
								map[x][y] = Main.BLOCK_AIR;
							if (x==Main.MAP_WIDTH - 1 && y!=Main.MAP_HEIGHT/2)
								map[x][y] = Main.BLOCK_WALL;
							if (x==Main.MAP_WIDTH - 1 && y==Main.MAP_HEIGHT/2)
								map[x][y] = Main.BLOCK_AIR;
						}
					}
					break;
					}
		case 9: {//initialize with walls on all sides but bottom and right have pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(x== 0||y==0)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if ( y==Main.MAP_HEIGHT-1 && x != Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y==Main.MAP_HEIGHT-1 && x == Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==Main.MAP_WIDTH - 1 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==Main.MAP_WIDTH - 1 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				break;
				}
		case 10: {//initialize with walls on all sides but bottom, top, and right have pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(x==0)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if ( y== Main.MAP_HEIGHT - 1 && x != Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y== Main.MAP_HEIGHT - 1 && x == Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
						if (y==0 && x!=Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y==0 && x==Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==Main.MAP_WIDTH-1 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==Main.MAP_WIDTH-1 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				break;
				}
		case 11: {//initialize with walls on all sides but bottom, top, and left have pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(x==Main.MAP_WIDTH-1)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if ( y== Main.MAP_HEIGHT - 1 && x != Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y== Main.MAP_HEIGHT - 1 && x == Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
						if (y==0 && x!=Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y==0 && x==Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==0 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==0 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				break;
				}
		case 12: 	{//initialize with walls on all sides but bottom, right, and left have pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(y==0)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if (y== Main.MAP_HEIGHT-1 && x!=Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y== Main.MAP_HEIGHT-1 && x==Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==Main.MAP_WIDTH-1 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==Main.MAP_WIDTH-1 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==0 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==0 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				break;
				}
		case 13: {//initialize with walls on all sides but top, right, and left have pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(y== Main.MAP_HEIGHT-1)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if (y==0 && x!=Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y==0 && x==Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==Main.MAP_WIDTH-1 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==Main.MAP_WIDTH-1 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==0 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==0 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				break;
				}
		case 14: {//initialize with walls on all sides but all sides have pathway
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(y== Main.MAP_HEIGHT-1)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if (y==0 && x!=Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y==0 && x==Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==Main.MAP_WIDTH-1 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==Main.MAP_WIDTH-1 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
						if (x==0 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==0 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_AIR;
						if (y==Main.MAP_HEIGHT-1 && x!=Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y==Main.MAP_HEIGHT-1 && x==Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_AIR;
					}
				}
				break;
				}
		}
		*/
		
	}
}