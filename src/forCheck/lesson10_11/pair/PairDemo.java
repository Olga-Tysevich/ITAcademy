package forCheck.lesson10_11.pair;

public class PairDemo {
    public static void main(String[] args) {
        Pair<String> stringPair = new Pair<>("first", "last");

        System.out.println(stringPair.first());
        System.out.println(stringPair.last());

        stringPair.swap();
        System.out.println("First after swap: " + stringPair.first() + "; last after swap: " + stringPair.last());

        stringPair.replaceFirst("newFirst");
        stringPair.replaceLast("newLast");

        System.out.println(stringPair);

        Pair<Integer> integerPair = new Pair<>(1, 2);

        System.out.println(integerPair.first());
        System.out.println(integerPair.last());

        integerPair.swap();
        System.out.println("First after swap: " + integerPair.first() + "; last after swap: " + integerPair.last());

        integerPair.replaceFirst(3);
        integerPair.replaceLast(4);

        System.out.println(integerPair);
    }
}
