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
	
	public ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	
	public Room(int x, int y)
	{
		Random r = new Random();
		int num = r.nextInt(3);
		if (num == 0)
			enemies1();
		else if (num == 1)
			enemies2();
		else if (num == 2)
			enemies3();
		
		currentRoomX = x;
		currentRoomY = y;
		makeRoom();
		roomMap.put(x + "," + y, this);
	}
	
	private void enemies1()
	{
		Candle c = new Candle(16, 16);
		Candle c2 = new Candle(4,4);
		Chaser ch = new Chaser(10,1);
		enemies.add(c);
		enemies.add(c2);
		enemies.add(ch);
	}
	
	private void enemies2()
	{
		Spawner s = new Spawner(1, 10);
		Spawner s2 = new Spawner(18, 10);
		Bomb b = new Bomb(10, 5);
		Bomb b2 = new Bomb(10, 15);
		enemies.add(s);
		enemies.add(s2);
		enemies.add(b);
		enemies.add(b2);
	}
	
	private void enemies3()
	{
		Twiddle t = new Twiddle(1, 4);
		Twiddle t2 = new Twiddle(1, 16);
		Chaser c = new Chaser(18,18);
		Spawner s = new Spawner(10, 1);
		enemies.add(t);
		enemies.add(t2);
		enemies.add(c);
		enemies.add(s);
	}
	
	private void makeRoom()
	{
		for(int x = 0; x < Main.MAP_WIDTH; x++)
		{
			for(int y = 0; y < Main.MAP_HEIGHT; y++)
			{
				if(x==0||y==0||x==Main.MAP_WIDTH-1||y==Main.MAP_HEIGHT-1)
				{
					map[x][y] = Main.BLOCK_WALL;
				} else map[x][y] = Main.BLOCK_AIR;
			}
		}
		Random r = new Random();
		int w = r.nextInt(10); // change this number depending on the number of options. 
		//Change this number to mess with percentages as well
		if(r.nextInt(10)<3)
		{
			exitTop = true;
			map[Main.MAP_WIDTH/2][0] = Main.BLOCK_AIR;
		}
		if(r.nextInt(10)<3)
		{
			exitBottom = true;
			map[Main.MAP_WIDTH/2][Main.MAP_HEIGHT-1] = Main.BLOCK_AIR;
		}
		if(r.nextInt(10)<3)
		{
			exitLeft = true;
			map[0][Main.MAP_HEIGHT/2] = Main.BLOCK_AIR;
		}
		if(r.nextInt(10)<3)
		{
			exitRight = true;
			map[Main.MAP_WIDTH-1][Main.MAP_HEIGHT/2] = Main.BLOCK_AIR;
		}
		if(!exitLeft&&!exitRight&&!exitTop&&!exitBottom)
		{
			switch(r.nextInt(4))
			{
			case 0:
				exitTop = true;
				map[Main.MAP_WIDTH/2][0] = Main.BLOCK_AIR;
				break;
			case 1:
				exitBottom = true;
				map[Main.MAP_WIDTH/2][Main.MAP_HEIGHT-1] = Main.BLOCK_AIR;
				break;
			case 2:
				exitLeft = true;
				map[0][Main.MAP_HEIGHT/2] = Main.BLOCK_AIR;
				break;
			case 3:
				exitRight = true;
				map[Main.MAP_WIDTH-1][Main.MAP_HEIGHT/2] = Main.BLOCK_AIR;
				break;
			}
		}
		
		Room r1 = Room.roomMap.get((currentRoomX-1) + "," + currentRoomY);
		if (r1 != null)
		{
			int block = Main.BLOCK_AIR;
			if (r1.exitRight==false)
			{
				block = Main.BLOCK_WALL;
				exitLeft = false;
			} else 
				exitLeft = true;
			map[0][Main.MAP_HEIGHT/2] = block;
		}
		Room r2 = Room.roomMap.get((currentRoomX+1) + "," + currentRoomY);
		if (r2 != null)
		{
			int block = Main.BLOCK_AIR;
			if(r2.exitLeft==false)
			{
				block = Main.BLOCK_WALL;
				exitRight = false;
			} else exitRight = true;
			map[Main.MAP_WIDTH-1][Main.MAP_HEIGHT/2] = block;
		}
		Room r3 = Room.roomMap.get(currentRoomX + "," + (currentRoomY-1));
		if (r3 != null)
		{
			int block = Main.BLOCK_AIR;
			if(r3.exitBottom==false)
			{
				block = Main.BLOCK_WALL;
				exitTop = false;
			} else exitTop = true;
			map[Main.MAP_WIDTH/2][0] = block;
		}
		Room r4 = Room.roomMap.get(currentRoomX + "," + (currentRoomY+1));
		if (r4 != null)
		{
			int block = Main.BLOCK_AIR;
			if(r4.exitTop==false)
			{
				block = Main.BLOCK_WALL;
				exitBottom = false;
			} else exitBottom = true;
			map[Main.MAP_WIDTH/2][Main.MAP_HEIGHT-1] = block;
		}
		
		if (exitLeft)
		{
			map[0][Main.MAP_HEIGHT/2] = Main.BLOCK_AIR;
		}
		else 
		{
			map[0][Main.MAP_HEIGHT/2] = Main.BLOCK_WALL;
		}
		if (exitRight)
		{
			map[Main.MAP_WIDTH-1][Main.MAP_HEIGHT/2] = Main.BLOCK_AIR;
		}
		else 
		{
			map[Main.MAP_WIDTH-1][Main.MAP_HEIGHT/2] = Main.BLOCK_WALL;
		}
		if (exitTop)
		{
			map[Main.MAP_WIDTH/2][0] = Main.BLOCK_AIR;
		}
		else 
		{
			map[Main.MAP_WIDTH/2][0] = Main.BLOCK_WALL;
		}
		if (exitBottom)
		{
			map[Main.MAP_WIDTH/2][Main.MAP_HEIGHT-1] = Main.BLOCK_AIR;
		}
		else 
		{
			map[Main.MAP_WIDTH/2][Main.MAP_HEIGHT-1] = Main.BLOCK_WALL;
		}
			
		int numberOfExits = 0;
		if (exitRight)
		{
			numberOfExits += 1;
		}
		if (exitLeft)
		{
			numberOfExits += 1;
		}
		if (exitTop)
		{
			numberOfExits += 1;
		}
		if (exitBottom)
		{
			numberOfExits += 1;
		}
		if (numberOfExits == 1)
		{
			if(Main.currentRoom!=null)
			{
				//TODO SPAWN A BOSS IN THE ROOM
				Boss lastBoss = new Boss (Main.MAP_WIDTH/2, Main.MAP_HEIGHT/2);
				enemies.clear();
				enemies.add(lastBoss);
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