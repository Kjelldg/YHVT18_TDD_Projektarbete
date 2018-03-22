package gameplay;

import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class RunnableGame {
	
	public static int playerPosition_X_Position = 0;
	public static int playerPosition_Y_Position = 0;
	public static int inputTest = 0;
	public static String arrow = "";
	
	
	public static void main(String[] args) {

		JTextField textField = new JTextField();		
		textField.addKeyListener(new UserInput());
		
		JFrame jframe = new JFrame();
		jframe.add(textField);
		jframe.setSize(200, 200);
		jframe.setVisible(true);		  
		
		int [][] gameBoardArray = {
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
				};				
		
		while(true) 
		{			
			
			// Loops the gameBoard array
			for (int i = 0; i < gameBoardArray.length; i++) 
			{
				System.out.println(Arrays.toString(gameBoardArray[i]));
				
				for (int j = 0; j < gameBoardArray[i].length; j++) 
				{
					if (gameBoardArray[i][j] == 1) 
					{						
						playerPosition_X_Position = j;
						playerPosition_Y_Position = i;
						
					}
				}
				
			}
			
			System.out.println("Y position is: " + playerPosition_Y_Position);
			System.out.println("X position is: " + playerPosition_X_Position);
			
			
			// Move the player by having the java swing window selected and use the arrow keys (not numpad arrow keys btw).
			switch(arrow)
			{
				case "UP": 		System.out.println("Up arrow was pressed.");
								gameBoardArray[playerPosition_Y_Position][playerPosition_X_Position] = 0;
								gameBoardArray[playerPosition_Y_Position-1][playerPosition_X_Position] = 1;							
					break;
				case "DOWN": 	System.out.println("Down arrow was pressed.");
								gameBoardArray[playerPosition_Y_Position][playerPosition_X_Position] = 0;
								gameBoardArray[playerPosition_Y_Position+1][playerPosition_X_Position] = 1;
					break;
				case "LEFT": 	System.out.println("Left arrow was pressed.");
								gameBoardArray[playerPosition_Y_Position][playerPosition_X_Position] = 0;
								gameBoardArray[playerPosition_Y_Position][playerPosition_X_Position-1] = 1;
					break;
				case "RIGHT":	System.out.println("Right arrow was pressed.");
								gameBoardArray[playerPosition_Y_Position][playerPosition_X_Position] = 0;
								gameBoardArray[playerPosition_Y_Position][playerPosition_X_Position+1] = 1;
					break;
				default: System.out.println("Nothing was pressed.");
					break;
			}
			
			arrow = "";
			
			System.out.println("\n\n\n\n\n"); // Prints empty lines beneath the game board.
			try {
				Thread.sleep(200); 
			} catch (InterruptedException e) {			
				e.printStackTrace();
			}
		}

	}

}
