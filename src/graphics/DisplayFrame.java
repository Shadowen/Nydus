package graphics;

import game.Game;
import game.Map;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

public class DisplayFrame extends JFrame implements ActionListener {

	private static final String REGENERATE_MAP_COMMAND = "RegenerateMap";
	private Game game;
	private MapPanel mapPanel;
	private JButton regenerateMapButton;

	public DisplayFrame(Game g, Map map) {
		super();

		game = g;

		setSize(640, 480);

		mapPanel = new MapPanel(game, map);
		setContentPane(mapPanel);

		regenerateMapButton = new JButton("Regenerate");
		add(regenerateMapButton);
		regenerateMapButton.setActionCommand(REGENERATE_MAP_COMMAND);
		regenerateMapButton.addActionListener(this);

		setVisible(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void drawPath(List<Point> path) {
		mapPanel.drawPath(path);
		mapPanel.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(REGENERATE_MAP_COMMAND)) {
			game.regenerateMap();
		}
	}
}
