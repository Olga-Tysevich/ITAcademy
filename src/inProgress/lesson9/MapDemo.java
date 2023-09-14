package inProgress.lesson9;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {
    public static void main(String[] args) {
        String newString = "bbbbbaacccaaaaaaaaaaacccccccccccbbbb";

        getCharsCount(newString);

    }

    public static void getCharsCount(String string) {
        Map<Character, Integer> charsArray = new LinkedHashMap<>();

        for (int i = 0; i < string.length(); i++) {
            char currentChar = string.charAt(i);
            if (charsArray.containsKey(currentChar)) {
                charsArray.put(currentChar, charsArray.get(currentChar) + 1);
            } else {
                charsArray.put(currentChar, 1);
            }
        }

        charsArray.forEach((k,v) -> System.out.println(k + " - " + v));
    }
}
