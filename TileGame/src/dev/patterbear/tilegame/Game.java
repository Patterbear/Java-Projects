package dev.patterbear.tilegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import dev.patterbear.tilegame.display.Display;
import dev.patterbear.tilegame.gfx.Assets;
import dev.patterbear.tilegame.gfx.ImageLoader;
import dev.patterbear.tilegame.gfx.SpriteSheet;

public class Game implements Runnable {
	
	private Display display;
	public int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		
	}
	
	private void init() {
		display = new Display(title, width, height);
		Assets.init();
	}
	
	private void tick() {
		
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
		
		g.drawImage(Assets.player, 0, 0, null);
		g.drawImage(Assets.grass, 50, 0, null);
		g.drawImage(Assets.dirt, 100, 0, null);
		g.drawImage(Assets.stone, 150, 0, null);
		g.drawImage(Assets.tree, 200, 0, null);
		
		
		//End of drawing
		bs.show();
		g.dispose();
				
		
	}
	
	public void run() {
		
		init();
		
		while(running) {
			tick();
			render();
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
