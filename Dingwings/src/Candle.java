//import java.util.ArrayList;
public class Candle extends Enemy 
{
	//ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	//Use the enemy ArrayList in Room
	public final int PROJECTILE_DELAY = 20; //Need to change this with play-testing
	public int currentDelay; //Time since last projectile
	
	@Override
	public int getSpriteID()
	{
		return Main.CANDLE_ENEMY;
	}
	
	public Candle(int x, int y)
	{
		//health = 2, damage = 1, moveSpeed = 0
		super(2, 1, 0, x, y);
	}
	
	protected void move() //they don't move
	{}
	
	protected void attack()
	{ 
		double distance = 0;
		distance = Math.sqrt((Player.xCoord - this.xCoord)*(Player.xCoord - this.xCoord) + (Player.yCoord - this.yCoord)*(Player.yCoord - this.yCoord));
		
		if (currentDelay > PROJECTILE_DELAY)
		{
			if (distance < 4)
			{
				if (Player.xCoord > this.xCoord)
				{
					Main.currentRoom.enemies.add(new Projectile(this.xCoord, this.yCoord, 1));
				}
				else if (Player.xCoord < this.xCoord)
				{
					Main.currentRoom.enemies.add(new Projectile(this.xCoord, this.yCoord, 3));
				}
				else if (Player.yCoord > this.yCoord)
				{
					Main.currentRoom.enemies.add(new Projectile(this.xCoord, this.yCoord, 4));
				}
				else
				{
					Main.currentRoom.enemies.add(new Projectile(this.xCoord, this.yCoord, 2));
				}
			}
			currentDelay = 0;
		}
		else
		{
			currentDelay++;
		}
	}
}
