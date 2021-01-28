//GAMEBOARDDDD
// Java program to illustrate the BOARDLayout
// Done by Peri
import javax.swing.*;
import java.awt.*;

public class Board extends JPanel //class GridKayout extends JPanel
{
    private int cols; // to set the rows
	private int rows; // to set the columns
    private JLabel[][] board; //Defining matrix //Matrix is used as tiles are used to generate the JPanel 
    private ImageIcon bug_png;
    private ImageIcon ant_jpg;
	private ImageIcon blank_png;
    public Board(int col, int row) 
	{
	    cols = col; // Assigning col to cols
        rows = row; //Assignning row to rows
        board = new JLabel[rows][cols]; // the matrix of cols*rows.
        setBackground(new Color(200,200,200)); //contrast adjustment
        setLayout (new GridLayout(rows, cols, 0, 0));


        for (int i = 0; i < rows; i++ ) //increment of he col
		{
            for (int j = 0; j < cols; j++) //increment of the row
			{
				//all of the label settings are directly assigned to board 
                board[i][j] = new JLabel();// creating new label
                board[i][j].setBorder( BorderFactory.createLineBorder(Color.RED,1)); // Adjustment of the border using the borders from swing library
                board[i][j].setFont( new Font("Verdana", Font.BOLD, 12));
                board[i][j].setForeground(Color.WHITE); // the foreground will be in black color
                board[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                add(board[i][j]); //adding the adjusted board into the frame
            }
        }
        setPreferredSize(new Dimension(600,600)); // creating a new dimension with given size

        bug_png = new ImageIcon("bug.png");
        ant_jpg = new ImageIcon("ant.jpg");
		blank_png = new ImageIcon("blank.png");
    }
	//COLOR PANEL FOR THE board ALLIGNMENTS
    public void setBoard(int i, int j, int value) {

        if(value == 1){//ant
			board[i][j].setIcon(ant_jpg);
			board[i][j].setBackground( Color.WHITE ); //below icon is in white color
			board[i][j].setOpaque(true);
		}
		else if(value == 2){//bug               
			board[i][j].setIcon(bug_png);
			board[i][j].setBackground( Color.YELLOW ); //backround of ant is yellow color
			board[i][j].setOpaque(true);
		}
        else{
			board[i][j].setIcon(blank_png);
            board[i][j].setOpaque(false);
		}
        
    }
}
