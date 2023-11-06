package lesson18_Producer_Consumer;

public class Producer implements Runnable {
    Store store;

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 1; i < 11; i++) {
            store.put(i);
        }
    }
}
