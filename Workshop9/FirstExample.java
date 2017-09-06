// functional interface - method with zero parameters
interface ExecutableZero {
    public void executeZero();
}

class RunnerZero {
    public int i;
    public RunnerZero(int i) {
        this.i = i;
    }
    public void run(ExecutableZero e) {
        e.executeZero();
    }
}

public class FirstExample {
    public static void ZeroParam() {
        RunnerZero r1 = new RunnerZero(1);        // old style
        r1.run(new ExecutableZero() {
            public void executeZero() {
                System.out.println("Hello there: " + r1.i);
            }
        });

        System.out.println("==Lambda===");
        RunnerZero r2 = new RunnerZero(2);
        // the same but using a lambda expression in Java 8
        r2.run( () -> { System.out.println("Hello there: " + r2.i); });
    }
}
