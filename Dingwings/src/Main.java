import java.util.*;
public class Main
{
	public static final int KEY_DELAY = 50; //Minimum amount of milliseconds to wait before accepting key
	public static final int FRAME_DELAY = 50; //Milliseconds per frame
	public static final int BLOCK_WIDTH = 64; //Pixel width of sprites
	public static final int BLOCKS_LEFT = 7; //Amount of blocks to the left and right of the player
	public static final int BLOCKS_UP = 5; //Amount of blocks to the top and bottom of the player
	public static final int MAP_WIDTH = 20; //Map array length
	public static final int MAP_HEIGHT = 20; //Map array height
	
	public static final int PLAY_STATE = 0;
	public static final int WIN_STATE = 1;
	public static final int LOSE_STATE = 2;
	public static final int START_STATE = 3;
	
	public static int gameState = START_STATE;
	
	//Sprite info
	public static final int NUM_SPRITES = 13; //Total number of sprites
	public static final int BLOCK_AIR = 0; //Sprite ID for blank space
	public static final int BLOCK_WALL = 1; //Sprite ID for some placeholder wall
	public static final int SPRITE_PLAYER = 2; //Sprite ID for the player
	public static final int BOMB_ENEMY = 3;
	public static final int BOSS_ENEMY = 4;
	public static final int CANDLE_ENEMY = 5;
	public static final int CHASER_ENEMY = 6;
	public static final int SPAWNER_ENEMY = 7;
	public static final int TWIDDLE_ENEMY = 8;
	public static final int PROJECTILE_CANDLE = 9;
	public static final int PROJECTILE_RANGE_ATTACK = 10;
	public static final int PROJECTILE_BOSS = 11;
	public static final int SPRITE_HEART = 12;
	
	//Key bindings
	public static final int UP_KEY = 'W'; //Can later be changed for arrow keys
	public static final int DOWN_KEY = 'S';
	public static final int LEFT_KEY = 'A';
	public static final int RIGHT_KEY = 'D';
	public static final int ATTACK_KEY = ' '; //Spacebar
	public static final int RANGED_KEY = 'M';
	
	public static Room currentRoom = new Room(0,0); //Will be used later when multiple rooms are available
	
	public static void main(String [] args)
	{
		IO io = new IO(); //Get the graphics and key press handling
		io.tryImg(BLOCK_AIR, "Air"); //do this for all sprites, assuming it is in "images/air.png"
		io.tryImg(BLOCK_WALL, "Wall");
		io.tryImg(SPRITE_PLAYER, "Player-J");
		io.tryImg(BOMB_ENEMY,  "Enemy1-M");
		io.tryImg(BOSS_ENEMY, "Enemy1-N");
		io.tryImg(CANDLE_ENEMY, "Enemy1-SingleQuote");
		io.tryImg(CHASER_ENEMY, "Enemy1-L");
		io.tryImg(SPAWNER_ENEMY, "Enemy1-1");
		io.tryImg(TWIDDLE_ENEMY, "Enemy1-DoubleQuotes");
		io.tryImg(PROJECTILE_CANDLE, "Projectile-R");
		io.tryImg(PROJECTILE_RANGE_ATTACK, "New Projectile");
		io.tryImg(PROJECTILE_BOSS, "Projectile-]");
		io.tryImg(SPRITE_HEART, "Life-[");
		
		while(true) //Game loop
		{
			io.repaint(); //Draws the screen each frame
			long _c = System.currentTimeMillis(); //Time at which frame started
			
			//TODO game loop logic here
			int _health = Player.health;
			if(gameState==PLAY_STATE)
			{
				for(int i = 0; i < currentRoom.enemies.size(); i++)
				{
					Enemy e = currentRoom.enemies.get(i);
					int x = e.xCoord;
					int y = e.yCoord;
					boolean dead = false;
					if(e.health<=0) dead = true; else e.move();
					if(e.health<=0) dead = true; else if(x==e.xCoord&&y==e.yCoord)
						e.attack();
					if(dead||e.health<=0)
					{
						currentRoom.enemies.remove(i);
						i--;
						if(e instanceof Boss)
							gameState = WIN_STATE;
					}
				}
				if(Player.health<=0)
				{
					gameState = LOSE_STATE;
				}
			}
			
			if(Player.health!=_health)
				Player.damageSound.play();
			
			long c_ = System.currentTimeMillis(); //Time at which frame ended
			if(c_-_c<FRAME_DELAY) //Frame lock magic
			{
				try {
					Thread.sleep(FRAME_DELAY-(c_-_c));
				} catch(Exception e) {}
			}
		}
	}
	
	//What to do when the player runs out of lives
	public static void endGame()
	{
		//Player.die();
		//Maybe show and end screen that has an option for restart and one for quit
	}
}