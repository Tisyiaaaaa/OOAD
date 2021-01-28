// ANT VS BUGS SIMULATION - MAIN PROGRAM
// done by Peri, Amirah , Tisyia , Amiera
import java.util.*;
import java.awt.*;
import java.io.*;
import java.lang.*;
import java.util.concurrent.TimeUnit; //timer in milli
 
public class Program
{
	public static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
	{
		World world = new World(5,100);//////////ants/doodlebugs
        Body body = Body.getInstance(); //here, we declare the calling of the singleton design pattern
        body.setBoard( world.getBoard()); 
        String input = "1";
        int ts = 1; //timesteps
        boolean play = true;
		long startTime; //start time
        long endTime;   //end time
        double time;    //time difference
       	int count = 0;  //added for n steps
        startTime = System.currentTimeMillis(); // starts timer here
 
        while(play)
		{	System.out.println("");
			System.out.println("#############################################");
			System.out.println("# 	ANTS AND BUGS SIMULATION            #");
			System.out.println("#############################################");
			System.out.println("# CHOICE: [ENTER]   Timesteps.		    #");
			System.out.println("#         [Q/q]     Quit Program.	    #");
			System.out.println("#         [N/n]     Compute n timesteps.    #");
			System.out.println("#############################################");
			System.out.print("CHOICE -> ");
			input = s.nextLine();
			count++; //Repeats until while loop ends or if Q is entered
			
			if(input.equals("Q")||input.equals("q")) // quit
			{//quit simulation
				play = false; // game ends
				endTime = System.currentTimeMillis(); // calculates time
				time = (endTime - startTime) / 1000.0;
				System.out.println("\n Thank you for using the Program " );
				System.out.println("\n Overall Elapsed Time is:  " + time + " ms");
				System.out.println("\n Total Computed n timesteps:  " + count + " steps" );
				System.exit(0); // exits the program
				break;
			}
			else if(input.equals("n")||input.equals("N"))
			{//computing n value
				play = true;
				System.out.println("\nComputed n timesteps:  " + count );

				continue;
			}
			else if(input.equals(""))
			{// read the enter command
				timestep(ts,world);
				
			}
			else if(isNum(input))
			{
				ts = Integer.parseInt(input);
				timestep(ts,world);
				System.out.println("\nComputed n timesteps:  " + count );
			}
			else
			{
				System.out.println("Try again!");
				continue;
			}
            body.setBoard(world.getBoard());
        }
		// endTime = System.currentTimeMillis();
        // time = (endTime - startTime) / 1000.0;
        // System.out.println("\nElapsed Time is:  " + time + " ms");
		// System.out.println("\nOverall Computed n timesteps:  " + count );
    }
    public static void timestep(int ts, World w)
	{ // ant movements
		for(int i = ts; i > 0; i--)
		{
			w.moveAll();
			//Doodlebugs and ants move around
			//a grid. if a doodlebug lands on an ant
			w.breedAll();
			//the ant is eaten by the doodlebug.
			//if Ant lives for 3 turns then it breeds.
			//If a doodlebug lives for 8 turns it breeds
			w.starveAll();
			//If a doodlebug doesnt eat for 3 turns it starves
	}
		}
	public static boolean isNum(String s)
	{ //exepctions for the above isNum	
	    try
		{
	      Integer.parseInt(s);
	    } catch(NumberFormatException nfe) 
		{
	        return false;
	    }
	    return true;
}
}

