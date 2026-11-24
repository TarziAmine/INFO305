package tp1;

public class Point {
	public static void main(String[] args) {
		Point p = new Point(3.0);
		Point pBis = new Point(3.0);
		
		System.out.println(p + "==" + pBis + " vaut: " + (p == pBis));
		System.out.println(p + "estEgal " + pBis + "vaut: " + p.estEgal(pBis));
	}

	double x;
	double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Point(double x) {
		this.x = x;
		this.y = 0;
	}

	public double distance(Point autre) {
		double dx = this.x - autre.x;
		double dy = this.y - autre.y;
		return Math.sqrt(dx * dx + dy * dy);

	}

	public boolean estEgal(Point autre) {
		return (this.x == autre.x && this.y == autre.y);

	}

	public String toString() {
		return "(" + x + "," + y + ")";
	}
}
