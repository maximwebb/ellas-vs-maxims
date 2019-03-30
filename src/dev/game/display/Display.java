package dev.game.display;

import dev.game.gfx.Assets;
import dev.game.gfx.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;


public class Display {
	private JFrame frame;
	private Canvas canvas;

	private String title;
	private int width, height;

	private JButton plantButton;
	private JLayeredPane layers;

	public Display(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;

		createDisplay();
	}

	public void createDisplay() {
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));

		createPlantMenu(frame);

		frame.add(canvas);
		frame.pack();

	}

	public Canvas getCanvas() {
		return canvas;
	}

	public JButton getPlantButton(){
		return plantButton;
	}

	public void setPlantButton(JButton b){
		plantButton = b;
	}

	public void createPlantMenu(JFrame frame){
		BufferedImage b = ImageLoader.loadImage("/textures/plantButton.png");
		ImageIcon icon = new ImageIcon(b);
		plantButton = new JButton (icon);
		layers = frame.getLayeredPane();
		layers.add(plantButton, JLayeredPane.PALETTE_LAYER);
		plantButton.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		plantButton.setOpaque(false);
		plantButton.setContentAreaFilled(false);
		plantButton.setFocusPainted(false);
		plantButton.setBorderPainted(false);

		JInternalFrame plantList = new JInternalFrame();
		plantList.setVisible(false);
		plantButton.addActionListener(e -> {
			plantList.setLocation(0, plantButton.getHeight());
			plantList.setSize(plantButton.getWidth(), 200);
			plantList.setVisible(true);

		});


	}

}
