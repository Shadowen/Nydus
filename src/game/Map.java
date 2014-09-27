package game;

import java.util.ArrayList;
import java.util.List;

public class Map {

	private List<ArrayList<Boolean>> tiles;
	private int width = 10;
	private int height = 10;

	public Map() {
		tiles = new ArrayList<ArrayList<Boolean>>();
		for (int x = 0; x < width; x++) {
			tiles.add(new ArrayList<Boolean>());
			for (int y = 0; y < height; y++) {
				tiles.get(x).add(true);
			}
		}
		regenerate();
	}

	public int getWidth() {
		return tiles.size();
	}

	public int getHeight() {
		return tiles.size();
	}

	public boolean isTileWalkable(int x, int y) {
		return tiles.get(x).get(y);
	}

	public void regenerate() {
		width++;
		height++;
		tiles = new ArrayList<ArrayList<Boolean>>();
		for (int x = 0; x < width; x++) {
			tiles.add(new ArrayList<Boolean>());
			for (int y = 0; y < height; y++) {
				if (Math.random() < .7) {
					tiles.get(x).add(true);
				} else {
					tiles.get(x).add(false);
				}
			}
		}
	}
}
