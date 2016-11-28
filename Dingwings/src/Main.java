import java.util.*;
public class Main
{
	//Reece changing stuff
	public static final int KEY_DELAY = 50; //Minimum amount of milliseconds to wait before accepting key
	public static final int FRAME_DELAY = 50; //Milliseconds per frame
	public static final int BLOCK_WIDTH = 64; //Pixel width of sprites
	public static final int BLOCKS_LEFT = 5; //Amount of blocks to the left and right of the player
	public static final int BLOCKS_UP = 3; //Amount of blocks to the top and bottom of the player
	public static final int MAP_WIDTH = 20; //Map array length
	public static final int MAP_HEIGHT = 20; //Map array height
	
	//Sprite info
	public static final int NUM_SPRITES = 11; //Total number of sprites
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
	
	//Key bindings
	public static final int UP_KEY = 'W'; //Can later be changed for arrow keys
	public static final int DOWN_KEY = 'S';
	public static final int LEFT_KEY = 'A';
	public static final int RIGHT_KEY = 'D';
	public static final int ATTACK_KEY = ' '; //Spacebar
	public static final int RANGED_KEY = 'M';
	
	public static Room currentRoom = new Room(); //Will be used later when multiple rooms are available
	
	public static ArrayList<Enemy> enemies;
	
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
		io.tryImg(PROJECTILE_RANGE_ATTACK, "Projectile-Q");
		
		while(true) //Game loop
		{
			io.repaint(); //Draws the screen each frame
			long _c = System.currentTimeMillis(); //Time at which frame started
			
			//TODO game loop logic here
			enemies = new ArrayList<>();
			
			//if player touches enemy or player touches projectile
				//player.loselife
			//if player.lives == 0
				//endGame();
			
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