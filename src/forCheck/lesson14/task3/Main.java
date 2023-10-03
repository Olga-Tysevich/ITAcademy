package forCheck.lesson14.task3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Generator generator = new Generator(list);
        generator.setName("Generator");
        generator.start();


        while (true){
            if(!generator.isAlive()) {
                System.out.println("Main List size: " + list.size());
                System.out.println("Main list: ");
                list.forEach(s -> System.out.print(s + " "));
                break;
            }
        }

    }
}
