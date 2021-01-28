//done by amirah
import java.util.*;
import java.awt.*;
public class World
{
    private static Random rand = new Random();
    private int bugs;
    private int ants;
    private static final int SIZE = 20;
    private Organism[][] organism;
    //constructor
    World(int b,int a)
	{
       organism = new Organism[SIZE][SIZE];
       bugs = b;
       ants = a;
        for(int i = 0; i < b; i++)
		{
            boolean inhabited = true;
            while(inhabited)
			{//put Bugs
                int X = rand.nextInt(SIZE);
                int Y = rand.nextInt(SIZE);
                if(organism[X][Y] == null)
                {
                    inhabited = false;
                    organism[X][Y] = new Bug(this,X,Y);
                }
            }
        }
        for(int i = 0; i < a; i++)
		{
             boolean inhabited = true;
             while(inhabited)
			 {//put Ants
                 int X = rand.nextInt(SIZE);
                 int Y = rand.nextInt(SIZE);
                 if(organism[X][Y] == null)
                 {
                     inhabited = false;
                     organism[X][Y] = new Ant(this,X,Y);
                 }
           }
       }
    //accessors
    }
    public int getBugs()
	{
        return bugs;
    }
    public int getAnts()
	{
        return ants;
    }
    public int[][] getBoard()
	{// set ants, bugs and blank position
        int[][] board = new int[SIZE][SIZE];//0 to 19
        for(int i = 0; i < SIZE; i++)
		{
            for(int j = 0;j < SIZE; j++)
			{
                if(organism[j][i]!=null)
                    if(organism[j][i].getClass().getName().equals("Ant"))
                        board[j][i] = 1;
                    else if(organism[j][i].getClass().getName().equals("Bug"))
                        board[j][i] = 2;
                else
                    board[j][i] = ' ';

            }
        }
        return board;
    }

    //mutators
    public void BugsBreed()
	{//Bugs breed functions
        bugs++;
    }
    public void BugsShrink()
	{//Bugs shrink functions
        bugs--;
    }
    public void AntsBreed()
	{//Ants breed functions
        ants++;
    }
    public void AntsShrink()
	{//Ants shrink functions
        ants--;
    }

    public void moveAll()
	{
        for(int i = 0; i < SIZE; i++)
		{
            for(int j = 0;j < SIZE; j++)
			{
                if(organism[j][i] != null)
                    organism[j][i].move();

            }
        }
        for(int i = 0; i < SIZE; i++)
		{
            for(int j = 0;j < SIZE; j++)
			{
                if(organism[j][i] != null)
                    organism[j][i].moved=false;

            }
        }
    }
    public void breedAll()
	{
        for(int i = 0; i < SIZE; i++)
		{
            for(int j = 0;j < SIZE; j++)
			{
                if(organism[j][i] != null)
                    organism[j][i].breed();

            }
        }
    }
    public void starveAll()
	{
            for(int i = 0; i < SIZE; i++)
			{
                for(int j = 0;j < SIZE; j++)
				{
                    if(organism[j][i] != null)
                        organism[j][i].starve();

                }
            }
    }
    public boolean isEmpty(int x,int y)
	{//check board is fill or not
        boolean tbr = false;
        if(organism[x][y]==null)
            tbr = true;
        return tbr;
    }
    public boolean isAnt(int x,int y)
	{//check if ant is there or not
        boolean tbr = false;
        if(organism[x][y] instanceof Ant)
        tbr = true;
        return tbr;
    }
    public void setCell(int x, int y, Organism O)
	{
        organism[x][y] = O;
    }
	
}


