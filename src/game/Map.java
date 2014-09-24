package game;

import java.util.ArrayList;
import java.util.List;

public class Map {

	private List<ArrayList<Boolean>> tiles;

	public Map() {
		tiles = new ArrayList<ArrayList<Boolean>>();
		for (int x = 0; x < 10; x++) {
			tiles.add(new ArrayList<Boolean>());
			for (int y = 0; y < 10; y++) {
				tiles.get(x).add(true);
				if ((x % 2 == 0 && y % 3 == 0) || (y % 2 == 0 && x % 3 != 0)) {
					tiles.get(x).set(y, false);
				}
			}
		}
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
}
