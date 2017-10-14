package com.fap.Every_Beginning;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {

	private static int WidthResolution = 100;
	private static int HeightResolution = 100;
	
	private static int WidthFrame = WidthResolution;
	private static int HeightFrame = HeightResolution;
	
	public static String Title = "Every Beginning";
	
	
	private Thread thread;
	private JFrame Frame;
	
	
	private boolean Running;
	
	private BufferedImage ImageInFrame = new BufferedImage(WidthFrame, HeightFrame, BufferedImage.TYPE_INT_RGB);
	private int[] PixelsInFrame = ((DataBufferInt) ImageInFrame.getRaster().getDataBuffer()).getData();

	
	public Game () {
		Dimension FrameResolution = new Dimension(WidthFrame, HeightFrame);
		setPreferredSize(FrameResolution);
		
		Frame = new JFrame();
		

	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.Frame.setResizable(false);
		game.Frame.setTitle(game.Title);
		game.Frame.add(game);
		game.Frame.pack();
		game.Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.Frame.setLocationRelativeTo(null);
		game.Frame.setVisible(true);

		game.Start();

	}
	
	public synchronized void Start() {
		Running = true;
		thread = new Thread(this, "Affichage");
		thread.start();
				
	}
	
	public void run() {
		long Clock1Sec = System.currentTimeMillis();

		
		requestFocus();
		
		int FPS = 0, TPS = 0;
		
		while(Running) {
			
			TickGame();
			TPS++;
			
			RenderOnScreen();
			FPS++;
			
			if (System.currentTimeMillis() - Clock1Sec > 1000) {
				Clock1Sec += 1000;
				Frame.setTitle(Title + "    |     " + "Fps : "
						+ FPS + " , Tps : " + TPS);
				FPS = 0;
				TPS = 0;
				
			}
		}
		Stop();
	}
	
	
	public void TickGame() {
		
	}
	
	public void RenderOnScreen() {
		BufferStrategy BufferStrategy = getBufferStrategy();
		if (BufferStrategy == null) {
			createBufferStrategy(3);
			return;
		}
		
		Graphics graphics = BufferStrategy.getDrawGraphics();

		graphics.setColor(new Color(0xFF00FF));
		graphics.fillRect(0, 0, WidthFrame, HeightFrame);
	
		graphics.drawImage(ImageInFrame, 0, 0, WidthResolution, HeightResolution, null);

		
		graphics.dispose();
		BufferStrategy.show();
	
	}
	
	public synchronized void Stop() {
		Running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
