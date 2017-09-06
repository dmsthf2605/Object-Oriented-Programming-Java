public class StrangeBank {
    // once deposit some money, can't deposit money in a new currency
    // unless the account is empty
    private String currency;

    public StrangeBank(){
        currency = null;
    }

    public synchronized void deposit(String s) throws InterruptedException{
        show("IN DEPOSIT: BEGINNING");

        while(currency != null){
            show("IN DEPOSIT: before wait()");
            wait();
            show("IN DEPOSIT: after wait()");
        }

        currency = s;
        show("IN DEPOSIT: before notifyAll()");
        notifyAll();
        show("IN DEPOSIT: after notifyAll()");

        show("IN DEPOSIT: END");
    }

    public synchronized String withdraw() throws InterruptedException{
        show("IN WITHDRAW: BEGINNING");
        while(currency == null){
            show("IN WITHDRAW: before wait()");
            wait();
            show("IN WITHDRAW: after wait()");
        }

        String s2 = currency;
        currency = null;

        show("IN WITHDRAW: before notifyAll()");
        notifyAll();
        show("IN WITHDRAW: after notifyAll()");

        show("IN WITHDRAW: END");
        return s2;
    }

    private static void show(String description){
        String t = Thread.currentThread().getName();
        System.out.println(t + ": " + description);
    }

}
