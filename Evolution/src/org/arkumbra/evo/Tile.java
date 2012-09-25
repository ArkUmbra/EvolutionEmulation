package org.arkumbra.evo;



public abstract class Tile {
	
	// Possible tiles
	public static enum TileType {
		TILE_WATER,
		TILE_GROUND
	}
	
	private TileType 	type;
	private byte		food = 0;
	
	
	public Tile(TileType t, byte food) {
		this.type = t;
		this.food = food;
	}


	public TileType getType() {
		return type;
	}


	public void setType(TileType type) {
		this.type = type;
	}


	public byte getFood() {
		return food;
	}


	public void setFood(byte food) {
		this.food = food;
	}
}
