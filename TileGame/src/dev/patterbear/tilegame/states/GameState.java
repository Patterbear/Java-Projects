package dev.patterbear.tilegame.states;

import java.awt.Graphics;

import dev.patterbear.tilegame.Game;
import dev.patterbear.tilegame.entities.creatures.Player;
import dev.patterbear.tilegame.gfx.Assets;
import dev.patterbear.tilegame.tiles.Tile;
import dev.patterbear.tilegame.worlds.World;

public class GameState extends State {
	
	private Player player;
	private World world;
	

	public GameState(Game game) {
		super(game);
		player = new Player(game, 100, 100);
		world = new World("res/worlds/world1.txts");
	}
	
	@Override
	public void tick() {
		world.tick();
		player.tick();
		
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		player.render(g);
	}

}
