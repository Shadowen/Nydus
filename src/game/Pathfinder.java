package game;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Pathfinder {
	private Map map;

	public Pathfinder(Map m) {
		map = m;
	}

	public List<Point> findPath(int startx, int starty, int endx, int endy) {
		// Init node-map
		List<ArrayList<Node>> nodes = new ArrayList<ArrayList<Node>>();
		for (int x = 0; x < map.getWidth(); x++) {
			nodes.add(new ArrayList<Node>());
			for (int y = 0; y < map.getHeight(); y++) {
				nodes.get(x).add(new Node(x, y, map.isTileWalkable(x, y)));
			}
		}

		SortedSet<Node> openSet = new TreeSet<Node>();
		nodes.get(startx).get(starty).costFromStart = 0;
		nodes.get(startx).get(starty).predictedTotalCost = nodes.get(startx)
				.get(starty).costFromStart
				+ Math.abs(endy - starty)
				+ Math.abs(endx - startx);
		openSet.add(nodes.get(startx).get(starty));
		SortedSet<Node> closedSet = new TreeSet<Node>();

		while (openSet.size() > 0) {
			Node currentNode = openSet.first();
			if (currentNode.x == endx && currentNode.y == endy) {
				List<Point> path = new ArrayList<Point>();
				reconstructPath(path, currentNode);
				return path;
			}

			openSet.remove(currentNode);
			closedSet.add(currentNode);

			for (Node neighbor : getNeighbors(nodes, currentNode.x,
					currentNode.y)) {
				if (closedSet.contains(neighbor)) {
					continue;
				}
				if (!neighbor.walkable) {
					continue;
				}

				double tentative_g_score = currentNode.costFromStart + 1;
				if (!openSet.contains(neighbor)
						|| tentative_g_score < neighbor.costFromStart) {
					neighbor.parent = currentNode;
					neighbor.costFromStart = tentative_g_score;
					neighbor.predictedTotalCost = tentative_g_score
							+ Math.abs(endx - neighbor.x)
							+ Math.abs(endy - neighbor.y);
					openSet.add(neighbor);
				}
			}
		}

		// throw noPathException!?
		return new ArrayList<Point>();
	}

	private List<Node> getNeighbors(List<ArrayList<Node>> allNodes, int x, int y) {
		List<Node> neighbors = new ArrayList<Node>();
		if (x - 1 > 0) {
			neighbors.add(allNodes.get(x - 1).get(y));
		}
		if (x + 1 < allNodes.size()) {
			neighbors.add(allNodes.get(x + 1).get(y));
		}
		if (y - 1 > 0) {
			neighbors.add(allNodes.get(x).get(y - 1));
		}
		if (y + 1 < allNodes.get(x).size()) {
			neighbors.add(allNodes.get(x).get(y + 1));
		}
		return neighbors;
	}

	public List<Point> reconstructPath(List<Point> path, Node finalNode) {
		path.add(new Point(finalNode.x, finalNode.y));

		// Base case
		if (finalNode.parent == null) {
			return path;
		}
		return reconstructPath(path, finalNode.parent);
	}
}