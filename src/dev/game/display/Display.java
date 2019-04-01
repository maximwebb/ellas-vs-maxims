package dev.game.display;


import dev.game.gfx.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;




public class Display {
	private JFrame frame;
	private Canvas canvas;

	private String title;
	private int width, height;

	private JButton plantButton;
	private JLayeredPane layers;
	private JButton plantList;

	private boolean plantSelection;
	private static boolean plantingState;

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

		canvas.addMouseListener(new PlantingMouseListener());

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
		plantButton.setOpaque(true);
		plantButton.setBorderPainted(false);
		plantButton.setBackground(new Color(130, 100, 0));

		plantSelection = false;
		plantingState = false;

		BufferedImage p = ImageLoader.loadImage("/textures/eggShooter.png");
		plantList = new JButton(new ImageIcon(p));
		layers.add(plantList, JLayeredPane.PALETTE_LAYER);
		plantList.setBounds(0, plantButton.getHeight(), plantButton.getWidth(), 200);
		plantList.setOpaque(true);
		plantButton.setBorderPainted(false);
		plantList.setBackground(new Color(130, 100, 0));
		plantList.setHorizontalAlignment(JLabel.CENTER);
		plantList.setVerticalAlignment(JLabel.CENTER);
		plantList.setVisible(false);

		plantButton.addActionListener(e -> {
			if(!plantSelection){
				plantSelection = true;
				plantList.setVisible(true);
			}else{
				plantSelection = false;
				plantingState = false;
				plantList.setVisible(false);

			}

		});


		plantList.addActionListener(e -> {
			plantingState = true;

		});


	}


	public JLayeredPane getLayers(){
		return layers;
	}

	public JButton getPlantList(){
		return plantList;
	}

	public static boolean getState(){
		return plantingState;
	}


}
