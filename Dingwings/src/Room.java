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
	}
}