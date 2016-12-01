import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

//BEHOLD KYLE'S REALM

public class IO extends JFrame //JFrame is a window
{
	private static final long serialVersionUID = 1L; //Required by JFrame, ignore
	
	long clock = 0; //Last time a key was pressed in millis
	BufferedImage offscreenImg; //Used for double buffering
	Graphics2D offscreenG; //Used for double buffering
	int width; //width in pixels of drawing area
	int height; //height in pixels of drawing area
	
	BufferedImage [] sprites = new BufferedImage[Main.NUM_SPRITES]; //Array of sprite images
	
	public IO()
	{
		//Make sure the program actually quits when the window is closed: very important!
		addWindowListener(new WindowListener(){
			@Override
			public void windowActivated(WindowEvent arg0) {}
			@Override
			public void windowClosed(WindowEvent arg0) {}
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
			@Override
			public void windowDeactivated(WindowEvent arg0) {}
			@Override
			public void windowDeiconified(WindowEvent arg0) {}
			@Override
			public void windowIconified(WindowEvent arg0) {}
			@Override
			public void windowOpened(WindowEvent arg0) {}
		});
		//Handle key presses
		addKeyListener(new KeyListener(){
			@Override
			public void keyPressed(KeyEvent arg0) {
				try {
					int key = arg0.getKeyCode();
					//make sure a valid key is being pressed so that it doesn't change the timing for random keys
					if(key==Main.UP_KEY||key==Main.LEFT_KEY||key==Main.DOWN_KEY||key==Main.RIGHT_KEY||key==Main.ATTACK_KEY||key==Main.RANGED_KEY)
					{
						if(System.currentTimeMillis()-clock>=Main.KEY_DELAY) //Make sure you can actually press a key
						{
							clock = System.currentTimeMillis(); //New last key press time
							if(Main.gameState==Main.PLAY_STATE)
							{
								if(key==Main.UP_KEY)
									Player.moveUp();
								if(key==Main.LEFT_KEY)
									Player.moveLeft();
								if(key==Main.DOWN_KEY)
									Player.moveDown();
								if(key==Main.RIGHT_KEY)
									Player.moveRight();
								if(key==Main.ATTACK_KEY)
									Player.attack();
								if(key==Main.RANGED_KEY)
									Player.ranged();
							} else if(Main.gameState==Main.START_STATE)
							{
								if(key==' ')
								{
									Main.gameState = Main.PLAY_STATE;
								}
							}
						}
					}
				} catch(Exception e) {}
			}
			@Override
			public void keyReleased(KeyEvent arg0) {}
			@Override
			public void keyTyped(KeyEvent arg0) {}
		});
		width = (2*Main.BLOCKS_LEFT+1)*Main.BLOCK_WIDTH;
		height = (2*Main.BLOCKS_UP+1)*Main.BLOCK_WIDTH;
		offscreenImg = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		offscreenG = offscreenImg.createGraphics();
		setVisible(true);
		setSize(getInsets().left+width,getInsets().top+height);
		setResizable(false);
		setTitle("Operation Dingwings");
	}
	
	//used to load a sprite from file
	public void tryImg(int id, String name)
	{
		try {
			sprites[id] = ImageIO.read(new File("images/" + name + ".png"));
		} catch(Exception e) {}
	}
	
	//Does drawing to screen
	@Override
	public void paint(Graphics g)
	{
		offscreenG.setColor(Color.white);
		offscreenG.fillRect(0, 0, width, height); //clear buffer
		
		if(Main.gameState==Main.PLAY_STATE)
		{
			//Draw each surrounding block
			for(int x = Player.xCoord-Main.BLOCKS_LEFT, _x = 0; x <= Player.xCoord+Main.BLOCKS_LEFT; x++, _x++)
			{
				for(int y = Player.yCoord-Main.BLOCKS_UP, _y = 0; y <= Player.yCoord+Main.BLOCKS_UP; y++, _y++)
				{
					if(x>=0&&y>=0&&x<Main.MAP_WIDTH&&y<Main.MAP_HEIGHT)
					{
						BufferedImage sprite = sprites[Main.currentRoom.map[x][y]];
						if(sprite!=null)
						{
							offscreenG.drawImage(sprite, _x*Main.BLOCK_WIDTH, _y*Main.BLOCK_WIDTH, this);
						}
					}
				}
			}
			//Draw the player to middle of screen if possible
			if(sprites[Main.SPRITE_PLAYER]!=null)
			{
				offscreenG.drawImage(sprites[Main.SPRITE_PLAYER], Main.BLOCKS_LEFT*Main.BLOCK_WIDTH, Main.BLOCKS_UP*Main.BLOCK_WIDTH, this);
			}
			for(int i = 0; i < Main.currentRoom.enemies.size(); i++)
			{
				Enemy e = Main.currentRoom.enemies.get(i);
				int x = (e.xCoord-Player.xCoord+Main.BLOCKS_LEFT)*Main.BLOCK_WIDTH;
				int y = (e.yCoord-Player.yCoord+Main.BLOCKS_UP)*Main.BLOCK_WIDTH;
				offscreenG.drawImage(sprites[e.getSpriteID()], x, y, this);
			}
			for(int i = 0; i < Player.health/10; i++)
			{
				offscreenG.drawImage(sprites[Main.SPRITE_HEART], 32*i,0,32,32,this);
			}
		} else if(Main.gameState==Main.START_STATE)
		{
			offscreenG.setColor(Color.black);
			offscreenG.drawString("OPERATION: DINGWINGS", 0, 20);
			offscreenG.drawString("Press space to play", 0, 60);
		} else if(Main.gameState==Main.WIN_STATE)
		{
			offscreenG.setColor(Color.black);
			offscreenG.drawString("You win!", 0, 20);
		} else if(Main.gameState==Main.LOSE_STATE)
		{
			offscreenG.setColor(Color.black);
			offscreenG.drawString("You lose.", 0, 20);
		}
		g.drawImage(offscreenImg,getInsets().left,getInsets().top,this); //draw buffer to screen
	}
	
	//Handles window changes and redraws
	@Override
	public void update(Graphics g)
	{
		paint(g);
	}
}