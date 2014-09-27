package graphics;

import game.Game;
import game.Map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class MapPanel extends JPanel implements MouseListener {
	private Game game;
	private Map map;
	private int tileSize = 20;

	private List<Point> path;

	public MapPanel(Game g, Map imap) {
		super();
		game = g;
		map = imap;

		path = new ArrayList<Point>();

		addMouseListener(this);
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

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX() / tileSize - 1;
		int y = e.getY() / tileSize - 1;
		if (x >= 0 && x < map.getWidth() && y >= 0 && y < map.getHeight()) {
			game.tileClicked(x, y);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
