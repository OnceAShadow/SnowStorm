package com.fap.Every_Beginning.Core;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {

	private static int WidthResolution = 800;
	private static int HeightResolution = 600;
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
		Frame.setResizable(false);
	}
	
	public static void main(String[] args) {
		Game game = new Game();
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
		
		int FPS = 0;
		int TPS = 0;
		
		while(Running) {
			
			TickGame();
			RenderOnScreen();

			TPS++;
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

		graphics.drawImage(ImageInFrame, 0, 0, WidthFrame, HeightFrame, null);

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
