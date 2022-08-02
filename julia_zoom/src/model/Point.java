package model;
public class Point{
    private int a;
    private int b;
    private int value;

    public Point(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    @Override
    public boolean equals (Object o) {
        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Point)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        Point p = (Point) o;
        return (this.a==p.getA())&&(this.b==p.getB());
    }

	@Override
	public String toString() {
		return "Point [a=" + a + ", b=" + b + ", value=" + value + "]";
	}
    

}
