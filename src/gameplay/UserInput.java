package gameplay;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UserInput extends KeyAdapter {
	
		@Override
		public void keyPressed(KeyEvent event) 
		{

			char keyPressedDown = event.getKeyChar();
			
			/*
			if (keyPressedDown == 'w' ||keyPressedDown == 'a'||keyPressedDown == 's'||keyPressedDown == 'd' ) 
			{
				System.out.println(event.getKeyChar());
			}
			*/

			if (event.getKeyCode() == KeyEvent.VK_HOME) 
			{
				System.out.println("Key codes: " + event.getKeyCode());
			} 
			else if (event.getKeyCode() == KeyEvent.VK_UP)
			{
				RunnableGame.inputTest = 1;
				RunnableGame.arrow = "UP";
			}
			else if (event.getKeyCode() == KeyEvent.VK_DOWN)
			{
				RunnableGame.inputTest = 2;
				RunnableGame.arrow = "DOWN";
			}			
			else if (event.getKeyCode() == KeyEvent.VK_LEFT)
			{
				RunnableGame.inputTest = 3;
				RunnableGame.arrow = "LEFT";
			}
			else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
			{
				RunnableGame.inputTest = 4;
				RunnableGame.arrow = "RIGHT";
			}
		}

}
