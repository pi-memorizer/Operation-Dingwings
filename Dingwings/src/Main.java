public class Main
{
	public static final int KEY_DELAY = 50; //Minimum amount of milliseconds to wait before accepting key
	public static final int FRAME_DELAY = 50; //Milliseconds per frame
	public static final int BLOCK_WIDTH = 64; //Pixel width of sprites
	public static final int BLOCKS_LEFT = 5; //Amount of blocks to the left and right of the player
	public static final int BLOCKS_UP = 3; //Amount of blocks to the top and bottom of the player
	public static final int MAP_WIDTH = 20; //Map array length
	public static final int MAP_HEIGHT = 15; //Map array height
	
	//Sprite info
	public static final int NUM_SPRITES = 3; //Total number of sprites
	public static final int BLOCK_AIR = 0; //Sprite ID for blank space
	public static final int BLOCK_WALL = 1; //Sprite ID for some placeholder wall
	public static final int SPRITE_PLAYER = 2; //Sprite ID for the player
	
	//Key bindings
	public static final int UP_KEY = 'W'; //Can later be changed for arrow keys
	public static final int DOWN_KEY = 'S';
	public static final int LEFT_KEY = 'A';
	public static final int RIGHT_KEY = 'D';
	public static final int ATTACK_KEY = ' '; //Spacebar
	
	public static Room currentRoom = new Room(); //Will be used later when multiple rooms are available
	
	public static void main(String [] args)
	{
		IO io = new IO(); //Get the graphics and key press handling
		io.tryImg(BLOCK_AIR, "Air"); //do this for all sprites, assuming it is in "images/air.png"
		io.tryImg(BLOCK_WALL, "Wall");
		io.tryImg(SPRITE_PLAYER, "Player-J");
		
		while(true) //Game loop
		{
			io.repaint(); //Draws the screen each frame
			long _c = System.currentTimeMillis(); //Time at which frame started
			
			//TODO game loop logic here
			
			long c_ = System.currentTimeMillis(); //Time at which frame ended
			if(c_-_c<FRAME_DELAY) //Frame lock magic
			{
				try {
					Thread.sleep(FRAME_DELAY-(c_-_c));
				} catch(Exception e) {}
			}
		}
	}
}