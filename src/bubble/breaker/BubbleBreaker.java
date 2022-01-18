/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubble.breaker;

/**
 * this controls the user input of the game
 *
 * @author mitchell
 */
public class BubbleBreaker {

	/**
	 * running the method that the user will interact with
	 *
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		//Menu movement would work better then user input(still needed for entering name)
		//how will this game be layed out, this stuff could be put in a Game class
		//Main Menu - This is were the user will be able to goto any other part of the game, the menu items include
		//---------
		//Start Game(Resume Game, would be cool)
		//Highscores(Prints the Highscores)
		//Settings (Colour mode, ?Gamemodes(Shifter(Done), Standard, Continous, Megashift))?
		//Exit
		boolean loop = true;
		while (loop) {
			int choose = Menu.intMenu("\nMain Menu (Please note in any menu you can type E at anytime to exit)\n---------", "Start Game", "Highscores", "Settings", "Exit");//make loop in intMenu
			switch (choose) {
				case 1:
					Game.startNewGame();
					break;
				case 2:
					Game.showScoreboard();
					break;
				case 3:
					Game.changeSettings();//could remove this completely by find what system is being used through the java API hooks, but saving the settings to the score file was more fun
					break;
				case 4:
					loop = false;
					break;
				case -2:
					loop = false;
					break;
			}
		}
	}

}
