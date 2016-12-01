			//scissors enemy
public class Twiddle extends Enemy 
{
	@Override
	public int getSpriteID()
	{
		return Main.TWIDDLE_ENEMY;
	}
	
	private boolean facingRight;
	public Twiddle(int x, int y)
	{
		//you can't kill them, so ridiculously large health or something
		//health = MANY, damage = 1, moveSpeed = 3
		super(999, 1, 3, x, y);
		facingRight = true;
	}
	
	protected void move()
	{
		if (facingRight)
		{
			super.enemyMove(1, 0);
			if (xCoord<Main.MAP_WIDTH-2 && Main.currentRoom.map[super.xCoord + 1][super.yCoord]==Main.BLOCK_WALL)
			{
				facingRight = false;
			}
		}
		else
		{
			super.enemyMove(-1, 0);
			if (super.xCoord > 0 && Main.currentRoom.map[super.xCoord - 1][super.yCoord]==Main.BLOCK_WALL)
			{
				facingRight = true;
			}
		}
	}
	
	protected void attack()
	{
		
		if (facingRight && (Player.xCoord - super.xCoord == 1))
		{
			Player.health -= super.damage;
		}
		else if (!facingRight && (Player.xCoord - super.xCoord == -1))
		{
			Player.health -= super.damage;
		}
	}
}
