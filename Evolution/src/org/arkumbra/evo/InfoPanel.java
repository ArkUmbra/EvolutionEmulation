package org.arkumbra.evo;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9205339101938922111L;
	
	
	int height = 40;
	private static JLabel seed = new JLabel("Seed: example");
	private static JLabel food = new JLabel("Food: 1230123");
	
	public InfoPanel() { 
		this.setLayout(new FlowLayout());
		add(food);
		add(seed);
	}
	
	public static void setFoodNumber(int i) {
		food.setText("Food: " + i);
	}
	
	public static void setSeedNumber(long i) {
		seed.setText("Seed: " + i);
	}
	
	

}
