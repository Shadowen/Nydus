package game;

import java.awt.Point;
import java.util.ArrayList;

import astar.AStarPathfinder;
import graphics.DisplayFrame;

public class Game {
	public static void main(String[] args) {
		new Game();
	}

	private Pathfinder p;
	private DisplayFrame d;
	private Map map;

	public Game() {
		map = new Map();
		p = new AStarPathfinder(map);

		d = new DisplayFrame(this, map);
	}

	public void tileClicked(int x, int y) {
		d.drawPath(p.findPath(0, 0, x, y));
	}

	public void regenerateMap() {
		// Generate a new map
		map.regenerate();
		p = new AStarPathfinder(map);

		// Clear the path
		d.drawPath(new ArrayList<Point>());
		// Draw everything
		d.repaint();
	}
}
