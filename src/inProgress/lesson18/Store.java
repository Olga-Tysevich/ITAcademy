package inProgress.lesson18;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Store {
    private final List<Integer> products = new ArrayList<>();
    private static final Semaphore semaphorePut = new Semaphore(3);
    private static final Semaphore semaphoreGet = new Semaphore(0);


    public void put(int productNumber) {
        try {
            semaphorePut.acquire();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        products.add(productNumber);
        System.out.printf("\nProducer added product, number of products %d", productNumber);
        semaphoreGet.release();
    }

    public void get() {
        try {
            semaphoreGet.acquire();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        if (products.size() != 0) {
            System.out.printf("\nConsumer consume the goods %d", products.get(0));
            products.remove(0);
        }
        semaphorePut.release();
    }
}
