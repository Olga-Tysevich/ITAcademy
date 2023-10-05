package inProgress.lesson15;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //task #1
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            list.add(random.nextInt(100) + 1);
        }
        list.forEach(s -> System.out.print(s + " "));

        System.out.println("\nMin: " + list.stream().min(Integer::compare).get());
        System.out.println("Max: " + list.stream().max(Integer::compare).get());
        System.out.println("Average: " + list.stream().mapToInt(Integer::intValue).average().getAsDouble());
        System.out.println("Product of numbers: " + list.stream().mapToLong(Integer::longValue).reduce((x, y) -> x * y).getAsLong());
        System.out.println("Sum of all numbers: " + list.stream().mapToInt(Integer::intValue).sum());
        System.out.println("Sum of all digits: " + Arrays.stream(list.stream().map(String::valueOf).collect(Collectors.joining()).split(""))
                .mapToInt(Integer::parseInt).sum());

        //task #2
        List<String> myList = Arrays.asList("a1", "a2", "a3", "b1", "b3", "c2", "c1", "c5");
        myList.stream().filter(s -> !s.contains("3")).forEach(s -> System.out.print(s + " "));
        System.out.println();
        myList.stream().filter(s -> !s.contains("3"))
                .sorted(Comparator.<String>comparingInt(s -> Integer.parseInt(s.split("")[1]))
                        .thenComparing(Comparator.<String, String>comparing(s -> s.split("")[0]).reversed()))
                .forEach(s -> System.out.print(s + " "));
        System.out.println();
        List<String> result = myList.stream().filter(s -> !s.contains("3"))
                .sorted(Comparator.<String>comparingInt(s -> Integer.parseInt(s.split("")[1]))
                        .thenComparing(Comparator.<String, String>comparing(s -> s.split("")[0]).reversed()))
                .skip(1).limit(myList.size() - myList.stream().filter(s -> s.contains("3")).toList().size() - 2)
                .map(String::toUpperCase).toList();

        result.forEach(s -> System.out.print(s + " "));
        System.out.println("\nNumber of remaining elements: " + result.size());


    }
}
