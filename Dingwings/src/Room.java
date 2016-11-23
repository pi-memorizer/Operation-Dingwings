import java.util.HashMap;
import java.util.Random;

public class Room
{
	int [][] map = new int[Main.MAP_WIDTH][Main.MAP_HEIGHT]; //The rooms map array of sprite indices
	
	HashMap <Coord, Room> roomMap = new HashMap <Coord, Room>();
		// add room to hashamp (each room is predetermined
		// once we enter a new room, generate room from hashmap
	public Room()
	{
		Random r = new Random();
		int w = r.nextInt(15);
		
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
							map[x][y] = Main.BLOCK_DOOR;
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
							map[x][y] = Main.BLOCK_DOOR;
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
							map[x][y] = Main.BLOCK_DOOR;
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
							map[x][y] = Main.BLOCK_DOOR;
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
							map[x][y] = Main.BLOCK_DOOR;
						if (y==0 && x!=Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y==0 && x==Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_DOOR;
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
							map[x][y] = Main.BLOCK_DOOR;
						if (x==0 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==0 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_DOOR;
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
							map[x][y] = Main.BLOCK_DOOR;
						if (x==0 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==0 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_DOOR;
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
							map[x][y] = Main.BLOCK_DOOR;
						if (x==0 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==0 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_DOOR;
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
								map[x][y] = Main.BLOCK_DOOR;
							if (x==Main.MAP_WIDTH - 1 && y!=Main.MAP_HEIGHT/2)
								map[x][y] = Main.BLOCK_WALL;
							if (x==Main.MAP_WIDTH - 1 && y==Main.MAP_HEIGHT/2)
								map[x][y] = Main.BLOCK_DOOR;
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
							map[x][y] = Main.BLOCK_DOOR;
						if (x==Main.MAP_WIDTH - 1 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==Main.MAP_WIDTH - 1 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_DOOR;
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
							map[x][y] = Main.BLOCK_DOOR;
						if (y==0 && x!=Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y==0 && x==Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_DOOR;
						if (x==Main.MAP_WIDTH-1 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==Main.MAP_WIDTH-1 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_DOOR;
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
							map[x][y] = Main.BLOCK_DOOR;
						if (y==0 && x!=Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y==0 && x==Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_DOOR;
						if (x==0 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==0 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_DOOR;
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
							map[x][y] = Main.BLOCK_DOOR;
						if (x==Main.MAP_WIDTH-1 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==Main.MAP_WIDTH-1 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_DOOR;
						if (x==0 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==0 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_DOOR;
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
							map[x][y] = Main.BLOCK_DOOR;
						if (x==Main.MAP_WIDTH-1 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==Main.MAP_WIDTH-1 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_DOOR;
						if (x==0 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==0 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_DOOR;
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
							map[x][y] = Main.BLOCK_DOOR;
						if (x==Main.MAP_WIDTH-1 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==Main.MAP_WIDTH-1 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_DOOR;
						if (x==0 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==0 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_DOOR;
						if (y==Main.MAP_HEIGHT-1 && x!=Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y==Main.MAP_HEIGHT-1 && x==Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_DOOR;
					}
				}
				break;
				}
		}
	}
}