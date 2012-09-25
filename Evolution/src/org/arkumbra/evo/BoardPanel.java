package org.arkumbra.evo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class BoardPanel extends JPanel {
	public static final int HEIGHT 	= 600;
	public static final int WIDTH  	= 600;
	
	private final int	tSize		= 3;
	private final int	rows 		= 230;
	private final int	cols 		= 230;
	
	private Tile[][] 	map			= new Tile[rows][cols];
	
	public BoardPanel() {
		setSize(HEIGHT, WIDTH);
		this.setPreferredSize(new Dimension(HEIGHT,WIDTH));
		this.setBackground(Color.RED);
		
		map = EnvironmentFactory.generateMapWaterFirst(map, 25, 1000, 998877665544332211L);
	}

	
	public void paintComponent(Graphics g) {
		int foodCount = 0;
		
		for(int x = 0; x < rows; x++) {
			for(int y = 0; y < cols; y++) {
				Tile t = map[x][y];
				if(t.getType() == Tile.TileType.TILE_WATER) {
					g.setColor(new Color(25, 25, 185));
					
				} else if (t.getType() == Tile.TileType.TILE_GROUND) {
					byte food = t.getFood();
					g.setColor(new Color(30, 200+(food*10), 30));
					foodCount += food;
				}
				
				g.fillRect(x*tSize,
						y*tSize,
						tSize,
						tSize);
					
					
			}
		}
		
		InfoPanel.setFoodNumber(foodCount);
		
	}

}
