package dev.patterbear.tilegame;

import dev.patterbear.tilegame.display.Display;

public class Launcher {
	
	public static void main(String[] args) {
		Game game = new Game("Game Name", 640, 360);
		game.start();
	}

}
