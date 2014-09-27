package game;

import java.awt.Point;
import java.util.List;

public abstract class Pathfinder {
	public abstract List<Point> findPath(int startx, int starty, int endx,
			int endy);
}
