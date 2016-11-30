import java.util.ArrayList;
public class Candle extends Enemy 
{
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
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
		int xDistAbs = Math.abs(Player.xCoord - this.xCoord);
		int yDistAbs = Math.abs(Player.yCoord - this.yCoord);
		
		if (xDistAbs >= 4)
		{
			if (Player.xCoord >= this.xCoord)
			{
				Main.currentRoom.enemies.add(new Projectile(this.xCoord, this.yCoord, 1));
			}
			else
			{
				Main.currentRoom.enemies.add(new Projectile(this.xCoord, this.yCoord, 3));
			}
		}
		else if (yDistAbs >= 4)
		{
			if (Player.yCoord >= this.yCoord)
			{
				Main.currentRoom.enemies.add(new Projectile(this.xCoord, this.yCoord, 4));
			}
			else
			{
				Main.currentRoom.enemies.add(new Projectile(this.xCoord, this.yCoord, 2));
			}
		}
	}
}
