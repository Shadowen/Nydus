package graphics;

import game.Map;

import java.awt.Graphics;
import java.awt.Point;
import java.util.List;

import javax.swing.JFrame;

public class DisplayFrame extends JFrame {

	MapPanel mapPanel;

	public DisplayFrame(Map map) {
		super();

		setSize(640, 480);

		mapPanel = new MapPanel(map);
		setContentPane(mapPanel);

		setVisible(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void drawPath(List<Point> path) {
		mapPanel.drawPath(path);
	}
}
