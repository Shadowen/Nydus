package game;

import graphics.DisplayFrame;

public class Game {
	public static void main(String[] args) {
		Map m = new Map();

		Pathfinder p = new Pathfinder(m);
		DisplayFrame d = new DisplayFrame(m);

		d.drawPath(p.findPath(0, 2, 9, 3));
	}
}
