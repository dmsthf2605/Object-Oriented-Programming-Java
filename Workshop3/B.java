class A {
    public int x = 1;
}

public class B extends A {
    public int x = 2;

    public static void main(String[] args) {
        B b = new B();
        A a = b;

        System.out.println(a.x == b.x);
        System.out.println(a.equals(b));
        System.out.println(a == b);

    }
}