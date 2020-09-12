package dev.patterbear.tilegame.states;

import java.awt.Graphics;

import dev.patterbear.tilegame.Game;
import dev.patterbear.tilegame.entities.creatures.Player;
import dev.patterbear.tilegame.gfx.Assets;
import dev.patterbear.tilegame.tiles.Tile;

public class GameState extends State {
	
	private Player player;
	

	public GameState(Game game) {
		super(game);
		player = new Player(game, 100, 100);
	}
	
	@Override
	public void tick() {
		player.tick();
		
	}

	@Override
	public void render(Graphics g) {
		player.render(g);
		Tile.tiles[0].render(g, 0, 0);
		Tile.tiles[1].render(g, 0, 70);
		Tile.tiles[2].render(g, 0, 140);
	}

}
