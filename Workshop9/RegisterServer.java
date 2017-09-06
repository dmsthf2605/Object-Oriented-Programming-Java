public class RegisterServer {
    public RegisterServer() {
        try {
            Register r = new RegisterImpl();
            java.rmi.Naming.rebind("Wonderful", r);
        } catch (Exception e) {
            System.out.println("Trouble: " + e);
        }
    }

    public static void main(String args[]) {
        new RegisterServer();
    }
}