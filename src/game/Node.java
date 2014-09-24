package game;

public class Node implements Comparable {
	int x;
	int y;
	boolean walkable;
	public double costFromStart;
	public double predictedTotalCost;
	public Node parent;

	public Node(int ix, int iy, boolean iwalkable) {
		x = ix;
		y = iy;
		walkable = iwalkable;
	}

	@Override
	public int compareTo(Object o) {
		Node otherNode = (Node) o;
		// Compare the predicted cost
		double distanceDifference = this.predictedTotalCost
				- otherNode.predictedTotalCost;
		// If they are the same distance, sort by x and y
		if (distanceDifference == 0) {
			int xcoordinateDifference = this.x - otherNode.x;
			if (xcoordinateDifference == 0) {
				int ycoordinateDifference = this.y - otherNode.y;
				return (int) Math.signum(ycoordinateDifference);
			}
			return (int) Math.signum(xcoordinateDifference);
		}
		return (int) Math.signum(distanceDifference);
	}
}
