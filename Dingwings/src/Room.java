import java.util.HashMap;
import java.util.Random;

public class Room
{
	//TODO Make a noticeable screen marking when the player changes rooms
	int [][] map = new int[Main.MAP_WIDTH][Main.MAP_HEIGHT]; //The rooms map array of sprite indices
	
	HashMap <Coord, Room> roomMap = new HashMap <Coord, Room>();
		// add room to hashamp (each room is predetermined
		// once we enter a new room, generate room from hashmap
	public Room()
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
		}
		Random r = new Random();
		int w = r.nextInt(8); // change this number depending on the number of options. 
		//Change this number to mess with percentages as well
		
		if (Player.xCoord == Main.MAP_WIDTH-2)//take off -2 when we move location of room change
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
							map[x][y] = Main.BLOCK_DOOR;
					}
				}
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
							map[x][y] = Main.BLOCK_DOOR;
						if (x==0 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==0 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_DOOR;
					}
				}
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
							map[x][y] = Main.BLOCK_DOOR;
						if (x==0 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==0 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_DOOR;
					}
				}
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
							map[x][y] = Main.BLOCK_DOOR;
						if (x==0 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==0 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_DOOR;
					}
				}
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
		else if (Player.xCoord == 1)// change to 0 when we move location of room change
			//########################################################################################
			//this will be used to only generate rooms with openings on the right
			//########################################################################################
		{
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
							map[x][y] = Main.BLOCK_DOOR;
					}
				}
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
							map[x][y] = Main.BLOCK_DOOR;
						if (x==0 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==0 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_DOOR;
					}
				}
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
							map[x][y] = Main.BLOCK_DOOR;
						if (x==Main.MAP_WIDTH - 1 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==Main.MAP_WIDTH - 1 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_DOOR;
					}
				}
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
							map[x][y] = Main.BLOCK_DOOR;
						if (x==Main.MAP_WIDTH - 1 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==Main.MAP_WIDTH - 1 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_DOOR;
					}
				}
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
		else if (Player.yCoord == Main.MAP_HEIGHT - 2)//remove -1 when we change the location of the room change
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
							map[x][y] = Main.BLOCK_DOOR;
					}
				}
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
							map[x][y] = Main.BLOCK_DOOR;
						if (y==0 && x!=Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y==0 && x==Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_DOOR;
					}
				}
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
							map[x][y] = Main.BLOCK_DOOR;
						if (x==0 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==0 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_DOOR;
					}
				}
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
							map[x][y] = Main.BLOCK_DOOR;
						if (x==Main.MAP_WIDTH - 1 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==Main.MAP_WIDTH - 1 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_DOOR;
					}
				}
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
		else if (Player.yCoord == 1)// change to 0 when we change the location of the room change
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
							map[x][y] = Main.BLOCK_DOOR;
					}
				}
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
							map[x][y] = Main.BLOCK_DOOR;
						if (y==0 && x!=Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
						if (y==0 && x==Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_DOOR;
					}
				}
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
							map[x][y] = Main.BLOCK_DOOR;
						if (x==0 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==0 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_DOOR;
					}
				}
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
							map[x][y] = Main.BLOCK_DOOR;
						if (x==Main.MAP_WIDTH - 1 && y!=Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
						if (x==Main.MAP_WIDTH - 1 && y==Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_DOOR;
					}
				}
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
		*/
	}
}