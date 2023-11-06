package lesson15_Lambda_Streams_API;

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

        list.stream().min(Integer::compare).ifPresent(min -> System.out.println("\nMin: " + min));
        list.stream().max(Integer::compare).ifPresent(max -> System.out.println("Max: " + max));
        list.stream().mapToInt(Integer::intValue).average().ifPresent(average -> System.out.println("Average: " + average));
        list.stream().mapToLong(Integer::longValue).reduce((x, y) -> x * y).ifPresent(product -> System.out.println("Product of numbers: " + product));
        System.out.println("Sum of all numbers: " + list.stream().mapToInt(Integer::intValue).sum());
        System.out.println("Sum of all digits: " + Arrays.stream(list.stream().map(String::valueOf).collect(Collectors.joining()).split(""))
                .mapToInt(Integer::parseInt).sum());

        //task #2
        List<String> myList = Arrays.asList("a1", "a2", "a3", "b1", "b3", "c2", "c1", "c5");
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
