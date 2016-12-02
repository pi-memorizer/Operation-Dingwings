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
		//health = MANY, damage = 8, moveSpeed = 3
		super(999, 8, 3, x, y);
		facingRight = true;
	}
	
	protected void move()
	{
		if (facingRight)
		{
			super.enemyMove(1, 0);
			if (xCoord<Main.MAP_WIDTH-2 && Main.currentRoom.map[super.xCoord + 2][super.yCoord]==Main.BLOCK_WALL)
			{
				facingRight = false;
			} else if(xCoord==Main.MAP_WIDTH-1) {
				facingRight = false;
			}
		}
		else
		{
			super.enemyMove(-1, 0);
			if (xCoord > 1 && Main.currentRoom.map[super.xCoord - 2][super.yCoord]==Main.BLOCK_WALL)
			{
				facingRight = true;
			} else if(xCoord==0) {
				facingRight = true;
			}
		}
		attack();
	}
	
	protected void attack()
	{
		if(Player.xCoord==xCoord&&Player.yCoord==yCoord)
		{
			Player.health -= damage;
		}
	}
}
