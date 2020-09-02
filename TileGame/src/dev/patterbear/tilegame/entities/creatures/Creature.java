package dev.patterbear.tilegame.entities.creatures;

import dev.patterbear.tilegame.entities.Entity;

public abstract class Creature extends Entity {
	
	protected int health;

	public Creature(float x, float y) {
		super(x, y);
		health = 10;
	}

}
