package gameplay;

import java.util.Arrays;
import java.util.stream.IntStream;

public class RunnableGame {

	public static void main(String[] args) {
		
		int player = 1;
		
		int[][] gameBoardArray = {
				{0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
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
				System.out.println(Arrays.toString(gameBoardArray[i]));
				
				//TODO: Lägg till logik för att hitta "spelaren", dvs 1an i arrayen.
				
					
			} 
			
			
			
			
			try {
				Thread.sleep(3000);
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
