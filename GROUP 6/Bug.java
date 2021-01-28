// done by Amiera
import java.awt.*;
import java.io.*;
import java.util.*;

//class Bug inherits class Organism
public class Bug extends Organism
{
    private static Random r = new Random();
    private int contBreed;
    private int contStarve;
    public Bug( World world,int _x, int _y)
	{
        super(world, _x, _y );
        contBreed = 8;
        contStarve = 3;
        moved = true;
    }
	//this function is the move for Bugs
    public void move()
	{
			if(!moved)
			{
	    	    //possible directions in order for Bugs
	    	    int[] posMoves = new int[4];
	    	    int i = 1;
	    	    posMoves[0] = r.nextInt(4); //generate random numbers for Bugs movement
	    	    do
				{
					do
					{
						posMoves[i] = r.nextInt(4);
					}
					while(posMoves[i]!=posMoves[i-1]);
					i++;
				}
				while(i<4);
				i = 0;
				boolean empty = false;
				int ox = x; 
				int oy = y; 
				while(i<4 && !empty)
				{
          	      if(posMoves[i] == 0)
				  {
						  if(x!=0)
						  {
							  if(world.isEmpty(x-1,y))
							  { //Bugs will move to the left
								  empty = true; // if its empty

								  world.setCell(x-1,y,this);//then it will be move to new cell
								  world.setCell(ox,y,null);//the cell that have Bug before will be set to empty
								  moved = true;
								  contBreed--; //minus time for the breed
								  contStarve--;//minus time for the starve
								  x=x-1;
							  }
						  }
						  else if(world.isEmpty(19,y))
						  {// to make sure it does not go out from the 20x20 dimension
								  empty = true;//if its empty
								  contBreed--;//minus breed countdown
								  contStarve--;//minus starve countdown
								  world.setCell(19,y,this);//then it will be move to new cell
								  world.setCell(ox,y,null);//the cell that have Bug before will be set to empty
								  moved = true;
								  x=19;
						  }
				}

				if(posMoves[i] == 1)
				{
						  if(x!=19)
						  {
							  if(world.isEmpty(x+1,y))
							  {//Bugs will move to the right
								  contBreed--;//minus time for the breed
								  contStarve--;//minus time for the starve
								  world.setCell(x+1,y,this);//then it will be move to new cell
								  world.setCell(ox,y,null);//the cell that have Bug before will be set to empty
								  moved = true;
								  empty = true;
								  x=x+1;
							  }
						  }
						  else if(world.isEmpty(0,y))
						  {// to make sure it does not go out from the 20x20 dimension

								  world.setCell(0,y,this);//then it will be move to new cell
								  world.setCell(ox,y,null);//the cell that have Bug before will be set to empty
								  moved = true;
								  empty = true;
								  x=0;
								  contBreed--;//minus time for the breed
								  contStarve--;//minus time for the starve
						  }
				}

				if(posMoves[i] == 2)
				{
						  if(y!=0)
						  {
							  if(world.isEmpty(x,y-1))
							  { //Bugs will move to downwards of the cell

								  world.setCell(x,y-1,this);//then it will be move to new cell
								  world.setCell(x,oy,null);//the cell that have Bug before will be set to empty
								  moved = true;
								  empty = true;
								  y=y-1;
								  contBreed--;//minus time for the breed
								  contStarve--;//minus time for the stave
							  }
						  }
						  else if(world.isEmpty(x,19))
						  {// to make sure it does not go out from the 20x20 dimension


								  world.setCell(x,19,this);//then it will be move to new cell
								  world.setCell(x,oy,null);//the cell that have Bug before will be set to empty
								  moved = true;
								  empty = true;
								  y=19;
								  contBreed--;//minus time for the breed
								  contStarve--;//minus time for the starve
						  }
				}

				if(posMoves[i] == 3)
				{
						  if(y!=19)
						  {
						   if(world.isEmpty(x,y+1))
						   {//Bugs will move to up of the cell
								  world.setCell(x,y+1,this);//then it will be move to new cell
								  world.setCell(x,oy,null);//the cell that have Bug before will be set to empty
								  moved = true;
								  empty = true;
								  y=y+1;
								  contBreed--;//minus time for the breed
								  contStarve--;//minus time for the starve
							  }
						  }
						  else if(world.isEmpty(x,0))
						  {// to make sure it does not go out from the 20x20 dimension

								  world.setCell(x,0,this);//then it will be move to new cell
								  world.setCell(x,oy,null);//the cell that have Bug before will be set to empty
								  moved = true;
								  empty = true;
								  y=0;
								  contBreed--;
								  contStarve--;
						  }
						  break;
				}
				i++;
			}
			i= 0;
			while(i<4 && !empty)
			{
				if(posMoves[i] == 0)
				{
                     if(x!=0){
                         if(world.isAnt(x-1,y))
						 {//if the cell have Ants, Bugs will move to left of the cell
                             empty = true;

                             world.setCell(x-1,y,this);//then it will be move to new cell
                             world.setCell(ox,y,null);//the cell that have Bug before will be set to empty
                             moved = true;
                             contBreed--;//minus time for the breed
                             contStarve=3;//reset back the countdown to breed again
                             x=x-1;
                         }
                     }
 					else if(world.isAnt(19,y))
					{// to make sure it does not go out from the 20x20 dimension
                             empty = true;
                             contBreed--;
                             contStarve=3;
                             world.setCell(19,y,this);//then it will be move to new cell
                             world.setCell(ox,y,null);//the cell that have Bug before will be set to empty
                             moved = true;
                             x=19;
                     }
				}

					if(posMoves[i] == 1)
					{
						 if(x!=19){
							 if(world.isAnt(x+1,y))
							 {//if the cell have Ants, Bugs will move to right of the cell
								 contBreed--;//minus time for the breed
								 contStarve=3;//reset back the countdown to breed again
								 world.setCell(x+1,y,this);//then it will be move to new cell
								 world.setCell(ox,y,null);//the cell that have Bug before will be set to empty
								 moved = true;
								 empty = true;
								 x=x+1;
							 }
						 }
						 else if(world.isAnt(0,y))
						 {// to make sure it does not go out from the 20x20 dimension

								 world.setCell(0,y,this);//then it will be move to new cell
								 world.setCell(ox,y,null);//the cell that have Bug before will be set to empty
								 moved = true;
								 empty = true;
								 x=0;
								 contBreed--;//minus time for the breed
								 contStarve=3;//reset back the countdown to breed again
						 }
					}

					if(posMoves[i] == 2)
					{
						 if(y!=0)
						 {
							 if(world.isAnt(x,y-1))
							 {//if the cell have Ants, Bugs will move to downwards of the cell

								 world.setCell(x,y-1,this);//then it will be move to new cell
								 world.setCell(x,oy,null);//the cell that have Bug before will be set to empty
								 moved = true;
								 empty = true;
								 y=y-1;
								 contBreed--;//minus time for the breed
								 contStarve=3;//reset back the countdown to breed again
							 }
						 }
						 else if(world.isAnt(x,19))
						 {// to make sure it does not go out from the 20x20 dimension


								 world.setCell(x,19,this);//then it will be move to new cell
								 world.setCell(x,oy,null);//the cell that have Bug before will be set to empty
								 moved = true;
								 empty = true;
								 y=19;
								 contBreed--;
								 contStarve=3;
						 }
					}

					if(posMoves[i] == 3)
					{
						 if(y!=19)
						 {
						  if(world.isAnt(x,y+1))
						  {//if the cell have Ants, Bugs will move to upwards of the cell
								 world.setCell(x,y+1,this);//then it will be move to new cell
								 world.setCell(x,oy,null);//the cell that have Bug before will be set to empty
								 moved = true;
								 empty = true;
								 y=y+1;
								 contBreed--;//minus time for the breed
								 contStarve=3;//reset back the countdown to breed again
							 }
						 }
						 else if(world.isAnt(x,0))
						 {//to make sure it does not go out from the 20x20 dimension

								 world.setCell(x,y+1,this);//then it will be move to new cell
								 world.setCell(x,oy,null);//the cell that have Bug before will be set to empty
								 moved = true;
								 empty = true;
								 y=0;
								 contBreed--;
								 contStarve=3;
						 }
					}
            i++;
            }
        }


 	}

//this function is for breed function
public void breed()
{
        if(contBreed==0)
		{ // when the it is breeding time (Bugs breed after 8 steps)
            //possible directions in order
            int[] posMoves = new int[4];// 4 directions where the bugs will be moving
            int i = 1;
            posMoves[0] = r.nextInt(4);//random number generator from 0 until 3
            do
			{
                do
				{
                    posMoves[i] = r.nextInt(4);//random number
                }
                while(posMoves[i]!=posMoves[i-1]);
                i++;
            }
            while(i<4);
            i = 0;
            boolean empty = false;
            int ox = x;
            int oy = y;
            while(i<4 && !empty)
			{
                if(posMoves[i] == 0)
				{
                        if(x!=0)
						{
                            if(world.isEmpty(x-1,y))
							{// if the cell on the left side is empty
                                world.setCell(x-1,y,new Bug(world, x-1,y));// the new born bug will be set at new cell
                                contBreed = 3;//reset back the countdown to breed again
                                empty = true;
                            }
                        }
                        else if(world.isEmpty(19,y))
						{//to make sure it does not go out from the 20x20 dimension
                                world.setCell(19,y,new Bug(world, 19,y));// it will put new Bug inside if cell is empty
                                contBreed = 3;//reset back the countdown to breed again
                                empty = true;
                        }
				}

				if(posMoves[i] == 1)
				{
                        if(x!=19)
						{
                            if(world.isEmpty(x+1,y))
							{// if the cell on the right side is empty
                                world.setCell(x+1,y,new Bug(world, x+1,y));;// the new born bug will be set at new cell
                                contBreed=3;//reset back the countdown to breed again
                                empty = true;
                            }
                        }
                        else if(world.isEmpty(0,y))
						{//to make sure it does not go out from the 20x20 dimension
                            world.setCell(0,y,new Bug(world, 0,y));// it will put new Bug inside if cell is empty
                            contBreed=3;//reset back the countdown to breed again
                            empty = true;
                        }
				}

				if(posMoves[i] == 2)
				{
                        if(y!=0)
						{
                            if(world.isEmpty(x,y-1))
							{// if the cell on the down side is empty
                            world.setCell(x,y-1,new Bug(world, x,y-1));// the new born bug will be set at new cell
                            contBreed=3;//reset back the countdown to breed again
                            empty = true;

                            }
                        }
                        else if(world.isEmpty(x,19))
						{//to make sure it does not go out from the 20x20 dimension
                            world.setCell(x,19,new Bug(world, x,19));// it will put new Bug inside if cell is empty
                            contBreed=3;//reset back the countdown to breed again
                            empty = true;
                        }
				}

				if(posMoves[i] == 3)
				{
                        if(y!=19)
						{
                            if(world.isEmpty(x,y+1))
							{// if the cell on the up side is empty
                                world.setCell(x,y+1,new Bug(world, x,y+1));// the new born bug will be set at new cell
                                contBreed=3;//reset back the countdown to breed again
                                empty = true;
                            }
                        }
                        else if(world.isEmpty(x,0))
						{//to make sure it does not go out from the 20x20 dimension
                            world.setCell(x,0,new Bug(world, x,0));// it will put new Bug inside if cell is empty
                            contBreed=3;//reset back the countdown to breed again
                            empty = true;
                        }
				}
				i++;
            }
        }

    }
	//this function is for starve function
 	public void starve()
	{//when the bug starve time
		if(contStarve==0)
			world.setCell(x,y,null);//set the cell to empty
	}
}

