package gameplay;

import java.util.Arrays;
import java.util.stream.IntStream;

public class RunnableGame {
	
	public static boolean useList(String[] array, String targetValue) {
		return Arrays.asList(array).contains(targetValue);
	}

	/*
	public String findPlayer () 
	{
		
		for (int i = 0; i < gameBoardArray.length; i++) 
		{
			System.out.println(Arrays.toString(gameBoardArray[i]));
			
			for (int j = 0; j < gameBoardArray.length; i++) 
			{
				if (gameBoardArray[j] == 1) 
				{
					return "Player found!";
				}
			}			
		} 		
	}
	*/
	
	public static void main(String[] args) {
		
		int player = 1;
		int playerPosition_X_Position = 0;
		int playerPosition_Y_Position = 0;
		
		int [][] gameBoardArray = {
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
				};
				
		
		while(true) {	
		
			
			for (int i = 0; i < gameBoardArray.length; i++) 
			{
				// System.out.println(Arrays.toString(gameBoardArray[i]));
				
				for (int j = 0; j < gameBoardArray[i].length; j++) 
				{
					if (gameBoardArray[i][j] == 1) 
					{
						System.out.println("Player found! " + i + j);
						playerPosition_X_Position = j;
						playerPosition_Y_Position = i;
					}
				}			
			} 		
			
			playerPosition_X_Position--;
			playerPosition_Y_Position--;
			
			System.out.println("Y position is: " + playerPosition_Y_Position);
			System.out.println("X position is: " + playerPosition_X_Position);
			
			try {
				Thread.sleep(3000);
				System.out.println("\n");
				System.out.println("\n");
				System.out.println("\n");
				System.out.println("\n");
				System.out.println("\n");
				System.out.println("\n");
				System.out.println("\n");
				System.out.println("\n");
			} catch (InterruptedException e) {			
				e.printStackTrace();
			}
		}

	}

}
