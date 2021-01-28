//done by Amirah

public abstract class Organism
{
    protected boolean moved;
    protected int x;
    protected int y;
    protected World world;
	//this is an abstract class and the methods are empty
    public Organism(World world,int x, int y) // ants and bugs 
	{
        this.world = world;
        this.x = x;
        this.y = y;
    }
    public void move() //ants and bugs movement around the board
	{
    }
    public void breed() // breeding for ant and bugs
	{
    }
    public void starve() //hunger
	{
    }
}
