package org.arkumbra.evo;

import java.util.Random;

public class EnvironmentFactory {

	private EnvironmentFactory() {	}

	private static Random r = new Random();
	
	public static Tile[][] generateMapWaterFirst(Tile[][] map, int maxWaterBrush, int chance) {
		return generateMapWaterFirst(map, maxWaterBrush, chance, r.nextLong());
	}
		
	public static Tile[][] generateMapWaterFirst(Tile[][] map, int maxWaterBrush, int chance, long seed) {
		InfoPanel.setSeedNumber(seed);
		r.setSeed(seed);
		if(maxWaterBrush < 0) maxWaterBrush = 0;
		
		for(int x = 0; x < map.length; x++) {
			for(int y = 0; y < map.length; y++) {
				
				if(r.nextInt(chance) % chance == 0) {
					
					int wBrush = r.nextInt(maxWaterBrush);
					//Draws all the water in the brush area
					for(int i = 0; i < wBrush; i++) {
						for(int j = 0; j < wBrush; j++) {
							if(i+x < map.length && j+y < map.length) {
								map[x+i][y+j] = new TileWater();
							}
						}
					}
				}
				
			}
		}
		for(int x = 0; x < map.length; x++) {
			for(int y = 0; y < map.length; y++) {
				if(map[x][y] == null) {
					map[x][y] = new TileGround((byte)r.nextInt(6));
				}
			}
		}
		
		
		return map;
	}
}
