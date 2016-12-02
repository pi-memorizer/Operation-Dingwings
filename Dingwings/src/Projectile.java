public class Projectile extends Enemy{
	public String projectileSprite;
	public int dx, dy;
	
	public Projectile()
	{
		super();
		projectileSprite = "Projectile-R";
		xCoord = 0;
		yCoord = 0;
	}
	
	public Projectile(int startXPos, int startYPos, int dx, int dy)
	{
		super(1, 1, 1, startXPos, startYPos);
		projectileSprite = "Projectile-R";
		xCoord = startXPos;
		yCoord = startYPos;
		this.dx = dx;
		this.dy = dy;
	}
	
	@Override
	public int getSpriteID()
	{
		return Main.PROJECTILE_CANDLE;
	}
	
	@Override
	protected void move()
	{
		int _x = xCoord;
		int _y = yCoord;
		enemyMove(dx,dy);
		if(_x==xCoord&&_y==yCoord)
		{
			health = 0;
		}
		attack();
	}
	
	@Override
	protected void attack()
	{
		if (Player.xCoord == this.xCoord && Player.yCoord == this.yCoord)
		{
			Player.health -= super.damage;
		}
	}
}
