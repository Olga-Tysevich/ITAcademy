package forCheck.lesson18;

public class Consumer implements Runnable {
    Store store;

    public Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 1; i < 11; i++) {
            store.get();
        }
    }
}
