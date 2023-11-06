package lesson9_Collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        String newString = "baaccc";
        Map<Character, Integer> newStringMap = getCharsCount(newString);

        newStringMap.forEach((k, v) -> System.out.print("| " + k + " - " + v + " |"));
        System.out.println();

        String text = "What happened to Osteen that winter day is what experts call a “near-death experience.” It can occur when doctors bring a person back to " +
                "life after the heart flatlines and breathing stops — which happens when a person dies for any reason, not just during a heart attack." +
                "Millions of people have reported near-death experiences since cardiopulmonary resuscitation, better known as CPR, was invented in 1960, said " +
                "Dr. Sam Parnia, an NYU Langone Health intensive care physician who has researched the phenomena for decades.";
        Map<Character, Integer> textMap = getCharsCount(text);
        textMap.forEach((k, v) -> System.out.print("| " + k + " - " + v + " |"));
    }

    public static Map<Character, Integer> getCharsCount(String string) {
        Map<Character, Integer> charsMap = new LinkedHashMap<>();

        for (int i = 0; i < string.length(); i++) {
            char currentChar = string.charAt(i);
            if (charsMap.containsKey(currentChar)) {
                charsMap.put(currentChar, charsMap.get(currentChar) + 1);
            } else {
                charsMap.put(currentChar, 1);
            }
        }

        return charsMap;
    }
}
