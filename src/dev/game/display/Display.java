package dev.game.display;


import dev.game.gfx.Assets;
import dev.game.gfx.ImageLoader;
import dev.game.plants.PlantBuilder;
import dev.game.rooms.GameRoom;
import dev.game.rooms.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class Display {
	private JFrame frame;
	private Canvas canvas;

	private String title;
	private int width, height;

	private JButton plantButton;
	private JLayeredPane layers;
	private ArrayList<JButton> plantList;
	private ArrayList<String> plantNameList;

	private boolean plantSelection;
	private static boolean plantingState;
	private static String selectedPlant;

	public Display(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;

		plantList = new ArrayList<>();
		plantNameList = new ArrayList<>();

		createDisplay();
	}

	public void createDisplay() {
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));

		createPlantMenu(frame);

		canvas.addMouseListener(new PlantingMouseListener());

		JPanel panel = (JPanel) frame.getContentPane();
		panel.setPreferredSize(new Dimension(width, height));
		panel.setLayout(new GridLayout());
		panel.add(canvas);

		frame.pack();
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public JButton getPlantButton() {
		return plantButton;
	}

	public void setPlantButton(JButton b) {
		plantButton = b;
	}

	public void updateDisplaySize(int width, int height) {
		this.width = width;
		this.height = height;

		int plantheight = Math.min(300, (this.height - plantButton.getHeight()) / plantList.size());
		for (int i = 0; i < plantList.size(); i++) {
			JButton plant = plantList.get(i);
//			Image icon = plant.getIcon();
			plant.setBounds(0, plantButton.getHeight() + (i * plantheight), plantButton.getWidth(), plantheight);
		}
	}

	public void createPlantMenu(JFrame frame) {
		BufferedImage b = ImageLoader.loadImage("/textures/plantButton.png");
		ImageIcon icon = new ImageIcon(b);
		plantButton = new JButton(icon);
		layers = frame.getLayeredPane();
		layers.add(plantButton, JLayeredPane.PALETTE_LAYER);
		plantButton.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		plantButton.setOpaque(true);
		plantButton.setBorderPainted(false);
		plantButton.setBackground(new Color(130, 100, 0));

		plantSelection = false;
		plantingState = false;

		JButton jButton = new JButton(new ImageIcon(Assets.eggShooter));
		//I deserve to be hanged for this code...
		jButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				((GameRoom) Room.getRoom()).getPlantBuilder().setCurrentPlantType(PlantBuilder.PlantType.EGGSHOOTER);
			}
		});
		plantList.add(jButton);

		jButton = new JButton(new ImageIcon(Assets.eggFlower));
		//I deserve to be hanged for this code...
		jButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				((GameRoom) Room.getRoom()).getPlantBuilder().setCurrentPlantType(PlantBuilder.PlantType.EGGFLOWER);
			}
		});
		plantList.add(jButton);

//		jButton = new JButton(new ImageIcon(Assets.chenapult));
//		//I deserve to be hanged for this code...
//		jButton.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent actionEvent) {
//				((GameRoom) Room.getRoom()).getPlantBuilder().setCurrentPlantType(PlantBuilder.PlantType.value);
//			}
//		});
//		plantList.add(jButton);

		jButton = new JButton(new ImageIcon(Assets.walbert));
		//I deserve to be hanged for this code...
		jButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				((GameRoom) Room.getRoom()).getPlantBuilder().setCurrentPlantType(PlantBuilder.PlantType.WALBERT);
			}
		});
		plantList.add(jButton);

		jButton = new JButton(new ImageIcon(Assets.youmu));
		//I deserve to be hanged for this code...
		jButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				((GameRoom) Room.getRoom()).getPlantBuilder().setCurrentPlantType(PlantBuilder.PlantType.YOUMU);
			}
		});
		plantList.add(jButton);
//
//		plantList.add(new JButton(new ImageIcon(Assets.chenapult)));
//		plantList.add(new JButton(new ImageIcon(Assets.walbert)));

		plantNameList.add("eggShooter");
		plantNameList.add("eggFlower");
//		plantNameList.add("chenapult");
		plantNameList.add("walbert");
		plantNameList.add("youmu");

		int plantheight = Math.min(200, (this.height - plantButton.getHeight()) / plantList.size());
		System.out.println(plantList.size());

		for (int i = 0; i < plantList.size(); i++) {
			final int index = i;
			JButton plant = plantList.get(i);
			layers.add(plant, JLayeredPane.PALETTE_LAYER);
			plant.setBounds(0, plantButton.getHeight() + (i * plantheight), plantButton.getWidth(), plantheight);
			plant.setOpaque(true);
			plantButton.setBorderPainted(false);
			plant.setBackground(new Color(130, 100, 0));
			plant.setHorizontalAlignment(JLabel.CENTER);
			plant.setVerticalAlignment(JLabel.CENTER);
			plant.setVisible(false);

			plant.addActionListener(e -> {
				plantingState = true;
				selectedPlant = plantNameList.get(index);
			});

		}

		plantButton.addActionListener(e -> {
			if (!plantSelection) {
				plantSelection = true;
				for (JButton plant : plantList) {
					plant.setVisible(true);
					plant.setVisible(true);
				}
			} else {
				plantSelection = false;
				plantingState = false;
				for (JButton plant : plantList) {
					plant.setVisible(false);
					plant.setVisible(false);
				}
			}
		});
	}

	public JLayeredPane getLayers() {
		return layers;
	}

	public static boolean getState() {
		return plantingState;
	}

	public static String getSelectedPlant() {
		return selectedPlant;
	}

}
