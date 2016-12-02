public class Candle extends Enemy 
{
	public final int PROJECTILE_DELAY = 15; //Need to change this with play-testing
	public int currentDelay; //Time since last projectile
	
	@Override
	public int getSpriteID()
	{
		return Main.CANDLE_ENEMY;
	}
	
	public Candle(int x, int y)
	{
		//health = 2, damage = 5, moveSpeed = 0
		super(2, 5, 0, x, y);
	}
	
	protected void move() //they don't move
	{}
	
	protected void attack()
	{ 
		double distance = 0;
		distance = Math.sqrt((Player.xCoord - this.xCoord)*(Player.xCoord - this.xCoord) + (Player.yCoord - this.yCoord)*(Player.yCoord - this.yCoord));
		
		if (currentDelay > PROJECTILE_DELAY)
		{
			if (distance < 7)
			{
				int dx = 0;
				int dy = 0;
				if(Player.xCoord>xCoord)
					dx = 1;
				else if(Player.xCoord<xCoord)
					dx = -1;
				if(Player.yCoord>yCoord)
					dy = 1;
				else if(Player.yCoord<yCoord)
					dy = -1;
				Main.currentRoom.enemies.add(new Projectile(xCoord,yCoord,dx,dy));
			}
			currentDelay = 0;
		}
		else
		{
			currentDelay++;
		}
	}
}
