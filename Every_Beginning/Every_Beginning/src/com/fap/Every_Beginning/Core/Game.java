package com.fap.Every_Beginning.Core;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;

import com.fap.Every_Beginning.Graphics.Animations.ScreenDisplay;
import com.fap.Every_Beginning.Graphics.World.Level;

public class Game extends Canvas implements Runnable {

	private static int widthResolution = 800;
	private static int heightResolution = 600;
	private static int widthFrame = widthResolution;
	private static int heightFrame = heightResolution;
	
	public static String title = "Every Beginning";

	private Thread thread;
	private JFrame frame;
	private ScreenDisplay screen;
	private Level level;

	private boolean running;
	
	private BufferedImage imageInFrame = new BufferedImage(widthFrame, heightFrame, BufferedImage.TYPE_INT_RGB);
	private int[] pixelsInFrame = ((DataBufferInt) imageInFrame.getRaster().getDataBuffer()).getData();

	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setTitle(game.title);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);

		game.start();
	}

	public Game () {
		Dimension FrameResolution = new Dimension(widthFrame, heightFrame);
		setPreferredSize(FrameResolution);
		
		
		screen = new ScreenDisplay(widthResolution, heightResolution);
		frame = new JFrame();
		frame.setResizable(false);
		
		level = Keeper.createWordl("");
	}

	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
	}
	
	public void run() {
		long clock1Sec = System.currentTimeMillis();
		requestFocus();
		
		int fps = 0;
		int tps = 0;
		
		while(running) {
			
			tickGame();
			renderOnScreen();

			tps++;
			fps++;
			
			if (System.currentTimeMillis() - clock1Sec > 1000) {
				clock1Sec += 1000;
				frame.setTitle(title + "    |     " + "Fps : "
						+ fps + " , Tps : " + tps);
				fps = 0;
				tps = 0;
				
			}
		}

		Stop();
	}

	public void tickGame() {
		level.tickLevel();
	}
	
	public void renderOnScreen() {
		BufferStrategy BufferStrategy = getBufferStrategy();
		if (BufferStrategy == null) {
			createBufferStrategy(3);
			return;
		}
		
		level.renderLevel(100, 100, screen);
		
		for (int i = 0; i < pixelsInFrame.length; i++) {
			pixelsInFrame[i] = screen.pixelsScreen[i];
		}
		
		Graphics graphics = BufferStrategy.getDrawGraphics();
		graphics.setColor(new Color(0xFF00FF));
		graphics.fillRect(0, 0, widthFrame, heightFrame);

		graphics.drawImage(imageInFrame, 0, 0, widthFrame, heightFrame, null);
		graphics.dispose();
		BufferStrategy.show();
	}
	
	public synchronized void Stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
