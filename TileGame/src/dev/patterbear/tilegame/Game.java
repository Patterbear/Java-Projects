package dev.patterbear.tilegame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import dev.patterbear.tilegame.display.Display;
import dev.patterbear.tilegame.gfx.Assets;
import dev.patterbear.tilegame.states.GameState;
import dev.patterbear.tilegame.states.MenuState;
import dev.patterbear.tilegame.states.SettingsState;
import dev.patterbear.tilegame.states.State;

public class Game implements Runnable {
	
	private Display display;
	public int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//States
	private State gameState;
	private State menuState;
	private State settingsState;
	
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		
	}
	
	private void init() {
		display = new Display(title, width, height);
		Assets.init();
		
		gameState = new GameState();
		menuState = new MenuState();
		settingsState = new SettingsState();
		State.setState(gameState);
	}

	
	private void tick() {
		if(State.getState() != null) {
			State.getState().tick();
		}
	}
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//Clear screen
		g.clearRect(0, 0, width, height);
		//Draw here
		
		if(State.getState() != null) {
			State.getState().render(g);
		}
		
		
		//End of drawing
		bs.show();
		g.dispose();
				
		
	}
	
	public void run() {
		
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000) {
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
			
		}
		
		stop();
	}
	
	public synchronized void start() {
		if(running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if(!running) {
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
