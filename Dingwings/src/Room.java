import java.util.HashMap;

public class Room
{
	int [][] map = new int[Main.MAP_WIDTH][Main.MAP_HEIGHT]; //The rooms map arraw of sprite indices
	
	public Room()
	{
		//initialize with walls on all sides
		
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
		
		//initialize with walls on all sides but top has pathway
		/*
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
					}
				}
		*/
		
		//initialize with walls on all sides but bottom has pathway
		/*
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(x==0||y==0||x==Main.MAP_WIDTH-1)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if ( y== Main.MAP_HEIGHT - 1 && x != Main.MAP_WIDTH/2)
							map[x][y] = Main.BLOCK_WALL;
					}
				}
		*/
		
		//initialize with walls on all sides but left has pathway
		/*
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(y==0||x==Main.MAP_WIDTH-1||y==Main.MAP_HEIGHT-1)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if ( x==0 && y!= Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
					}
				}
		*/
		
		//initialize with walls on all sides but right has pathway
		/*
				for(int x = 0; x < Main.MAP_WIDTH; x++)
				{
					for(int y = 0; y < Main.MAP_HEIGHT; y++)
					{
						if(x==0||y==0||y==Main.MAP_HEIGHT-1)
							map[x][y] = Main.BLOCK_WALL;
						else
							map[x][y] = Main.BLOCK_AIR;
						if ( x == Main.MAP_WIDTH - 1 && y != Main.MAP_HEIGHT/2)
							map[x][y] = Main.BLOCK_WALL;
					}
				}
		*/
	}
	HashMap <Integer, Room> roomMap = new HashMap <Integer, Room>();
	// add room to hashamp (each room is predetermined
	// once we enter a new room, generate room from hashmap and randomly generated number of exits
}