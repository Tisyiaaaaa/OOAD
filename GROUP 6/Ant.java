// done by Tisyia
import java.awt.*;
import java.io.*;
import java.util.*;
//import java.swing.*;

public class Ant extends Organism{
    private static Random r = new Random();
    private int contBreed; 
      public Ant(World world,int x, int y){
            super(world,x, y );
            contBreed = 3; // ants will breed after the steps = 3
            moved = false;//defaults to TRUE, therefore ants will not move
    }
    public void move(){
        if(!moved){
            //the direction where the ants will be facing.
            int[] posMoves = new int[4];
            int i = 1;
            posMoves[0] = r.nextInt(4);
            do{
                do{
                    posMoves[i] = r.nextInt(4); // generate random numbers for the ants movements
                }
                while(posMoves[i]!=posMoves[i-1]);
                i++;
            }
            while(i<4);
            i = 0;
            boolean empty = false;
            int ox = x;
            int oy = y;
            while(i<4 && !empty){
                if(posMoves[i] == 0){
					if(x!=0){
						if(world.isEmpty(x-1,y)){ // ants will move to the left
							empty = true; // if it is empty, 

							world.setCell(x-1,y,this);// will move the ant to the new cell
							world.setCell(ox,y,null); // the cell that was occupied before will be set to empty
							moved = true; 
							contBreed--; // minus the time towards breeding
							x=x-1;
						}
					}
					else if(world.isEmpty(19,y)){ // to make sure it doesn't go out of the bound since the dimension is 20x20
							empty = true; // if it is empty
							contBreed--; // minus breed countdown
							world.setCell(19,y,this); // move the ant to the new cell
							world.setCell(ox,y,null); // set the cell before empty
							moved = true;
							x=19;
					}
				}

				else if(posMoves[i] == 1){
								  
				  
					if(x!=19){
						if(world.isEmpty(x+1,y)){ // ants will move to the right
							contBreed--; // minus the time towards breeding
							world.setCell(x+1,y,this); // the ant will move to the new cell
							world.setCell(ox,y,null); // the cell occupied before will be empty
							moved = true;
							empty = true;
							x=x+1;
						}
					}
					else if(world.isEmpty(0,y)){// to make sure it doesn't go out of the bound since the dimension is 20x20

							world.setCell(0,y,this);// move the ant to new cell
							world.setCell(ox,y,null); // cell before will become empty
							moved = true;
							empty = true;
							x=0;
							contBreed--;
					}
				}
				   
				else if(posMoves[i] == 2){

					if(y!=0){
						if(world.isEmpty(x,y-1)){ // ants will move downwards

							world.setCell(x,y-1,this); // Ants will move to the new cell
							world.setCell(x,oy,null); // the cell occupied before will be empty
							moved = true;// the ant moved
							empty = true; 
							y=y-1;
							contBreed--; // minus towards the time to breed
						}
					}
					else if(world.isEmpty(x,19)){// to make sure it doesn't go out of the bound since the dimension is 20x20


							world.setCell(x,19,this);// move the ant to the new cell
							world.setCell(x,oy,null);// cell before will be empty
							moved = true;
							empty = true;
							y=19;
							contBreed--;
					}
				}
				   
				   
				else if(posMoves[i] == 3){
					if(y!=19){
					 if(world.isEmpty(x,y+1)){ // ants will move upwards
							world.setCell(x,y+1,this);// the nats will move to the new cell
							world.setCell(x,oy,null); // the cell occupied before will be empty
							moved = true;
							empty = true;
							y=y+1;
							contBreed--; // minus towards the breeding time
						}
					}
					else if(world.isEmpty(x,0)){// to make sure it doesn't go out of the bound since the dimension is 20x20

							world.setCell(x,0,this);// move the ant to the new cell
							world.setCell(x,oy,null);// cell before will be empty
							moved = true;
							empty = true;
							y=0;
							contBreed--;
					}
									 
				}
				
				else{System.out.println("Hello");} // testing of there's error
            i++;
            }
        }


    }
    public void breed(){
        if(contBreed==0){ // when the it is breeding time (ants will breed after steps = 3)
            int[] posMoves = new int[4]; // 4 directions where the ants will be moving
            int i = 1;
            posMoves[0] = r.nextInt(4); // random number generator 0 - 3
            do{
                do{
                    posMoves[i] = r.nextInt(4); // random number
                }
                while(posMoves[i]!=posMoves[i-1]);
                i++;
            }
            while(i<4);
            i = 0;
            boolean empty = false;
            int ox = x;
            int oy = y;
            while(i<4 && !empty){
                if(posMoves[i] == 0){ 
					if(x!=0){
						if(world.isEmpty(x-1,y)){ // if the cell on the left side is empty
							world.setCell(x-1,y,new Ant(world, x-1,y)); // the new born ant will be place in the new cell
							contBreed = 3; // reset back the countdown to breed again!
							empty = true;
						}
					}
					else if(world.isEmpty(19,y)){// to make sure it doesn't go out of the bound since the dimension is 20x20
							world.setCell(19,y,new Ant(world, 19,y)); // put the new ant inside the cell if it is empty
							contBreed = 3;// reset back breeding countdown
							empty = true;
					}
				}
				if(posMoves[i] == 1){
					if(x!=19){
						if(world.isEmpty(x+1,y)){ // if the cell on the right side is empty, 
							world.setCell(x+1,y,new Ant(world, x+1,y)); // new born ant will be put on that cell
							contBreed=3;// reset countdown to breed back to 3
							empty = true;
						}
					}
					else if(world.isEmpty(0,y)){// to make sure it doesn't go out of the bound since the dimension is 20x20
						world.setCell(0,y,new Ant(world, 0,y));// put the new ant inside the new cell
						contBreed=3; // reset breeding countdown back to 3
						empty = true;
					}
				}
				if(posMoves[i] == 2){
					if(y!=0){
						if(world.isEmpty(x,y-1)){// if the cell downward is empty, 
						world.setCell(x,y-1,new Ant(world, x,y-1)); // the new born ant will be inserted there..
						contBreed=3;// reset countdown to breed to 3
						empty = true;

						}
					}
					else if(world.isEmpty(x,19)){// to make sure it doesn't go out of the bound since the dimension is 20x20
						world.setCell(x,19,new Ant(world, x,19)); // put the new ant inside the new cell that is empty
						contBreed=3; // reset back the breeding countdown to 3
						empty = true;
					}
				}
				if(posMoves[i] == 3){
					if(y!=19){
						if(world.isEmpty(x,y+1)){ // if the cell upward is empty,
							world.setCell(x,y+1,new Ant(world, x,y+1));// new born ant will be inserted there
							contBreed=3;// reset back the countdown to breed back to 3
							empty = true;
						}
					}
					else if(world.isEmpty(x,0)){// to make sure it doesn't go out of the bound since the dimension is 20x20
						world.setCell(x,0,new Ant(world, x,0)); // put the new ant inside the new cell that is empty
						contBreed=3; // reset back the breeding countdown to 3
						empty = true;
					}
				}
								
            i++;
            }
        }

    }
	
}
