// done by Peri
import javax.swing.*;
import java.util.*;

// Displays a frame containing a grid,
// each cell containing a value given in the input array, data
public class Body extends JFrame 
{
	// Inside this class we include Singleton Design Pattern
	// Singleton Pattern says that just"define a class that has 
	//only one instance and provides a global point of access to it"
	private static Body instance = new Body();
    private Board board;
    //set the tittle, rows and column so it can't be change by the user.
    private Body() 
	{
		String title;
		int col = 20,rows = 20;
        setTitle("Ant vs Bug"); // name of the board will be printed under main program
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE ); //exit
        board = new Board(rows, col); // creation of board
        add(board);
        pack();
        setVisible( true );
    }
	public static Body getInstance()
	{
		Body single_instance = new Body();
		return single_instance;
	}
    // Sets board cells to values in array
    public void setBoard( int [][] data ) 
	{
        for (int i = 0; i < data.length; i++ ) 
		{
            for (int j = 0; j < data[i].length; j++ )
			{
                board.setBoard( i, j, data[i][j] ); //board setup
            }
        }
    }
}
