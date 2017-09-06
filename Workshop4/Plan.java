interface Oi {
    interface Ii {
        void move();
    }
}

class Point implements Oi.Ii {
    int x, y;

    public Point(int a, int b) {
        x = a;
        y = b;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Point other = (Point) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }

    public void move() {
        x += 1;
        y += 1;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

public class Plan {

    Point[] plan = new Point[] { new Point(0, 0), new Point(1, 1) };

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        for (int i = 0; i < plan.length; i++)
            result = prime * result + plan[i].hashCode();
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Plan other = (Plan) obj;
        if (plan.length != other.plan.length)
            return false;
        for (int i = 0; i < plan.length; i++)
            if (!plan[i].equals(other.plan[i]))
                return false;

        return true;
    }

    public void forEach() {
        for (Point p : plan)
            p.move();
    }

    public static void main(String[] a) {
        Plan small = new Plan();
        Oi.Ii[] oi = small.plan;
        oi[0].move();
        oi[1].move();

        Plan big = new Plan();
        big.forEach();

        System.out.println(small.equals(big));
    }
}