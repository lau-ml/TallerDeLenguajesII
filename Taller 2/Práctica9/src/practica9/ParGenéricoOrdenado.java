package practica9;

public class ParGenéricoOrdenado <X extends Comparable<X>,Y extends Comparable<Y>> implements Comparable<ParGenéricoOrdenado<X,Y>> {
	private X x;
	private Y y;
	public X getX() {
		return x;
	}
	public void setX(X x) {
		this.x = x;
	}
	public Y getY() {
		return y;
	}
	public void setY(Y y) {
		this.y = y;
	}
	@Override
	public int compareTo(ParGenéricoOrdenado<X, Y> o) {
		if (this.x.equals(o.getX()))
			return 1;
		else if (this.y.equals(o.getY()))
			return 2;
		else
			return 0;
	}	
}