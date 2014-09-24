package graphics;

import game.Map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class MapPanel extends JPanel {
	private Map map;
	private int tileSize = 20;

	private List<Point> path;

	public MapPanel(Map imap) {
		super();
		map = imap;

		path = new ArrayList<Point>();
	}

	public void drawPath(List<Point> ipath) {
		path = ipath;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int x = 0; x < map.getWidth(); x++) {
			for (int y = 0; y < map.getHeight(); y++) {
				if (path.contains(new Point(x, y))) {
					g.setColor(Color.GREEN);
					g.fillRect((x + 1) * tileSize, (y + 1) * tileSize,
							tileSize, tileSize);
				} else if (map.isTileWalkable(x, y)) {
					g.setColor(Color.WHITE);
					g.fillRect((x + 1) * tileSize, (y + 1) * tileSize,
							tileSize, tileSize);
				} else {
					g.setColor(Color.RED);
					g.fillRect((x + 1) * tileSize, (y + 1) * tileSize,
							tileSize, tileSize);
				}
			}
		}
	}
}
