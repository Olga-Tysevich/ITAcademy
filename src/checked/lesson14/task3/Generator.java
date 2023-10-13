package checked.lesson14.task3;

import java.util.List;
import java.util.Random;

public class Generator extends Thread {
    private final List<Integer> list;

    public Generator(List<Integer> list) {
        this.list = list;
    }

    public void run() {
        Random random = new Random();
        for (int i = 1; i < 101; i++) {
            list.add(random.nextInt(100));
            System.out.println("Thread: " + Thread.currentThread().getName() + " add number");
            try {
                Thread.sleep(200);
                System.out.println("Thread: " + Thread.currentThread().getName() + " falls asleep");
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
