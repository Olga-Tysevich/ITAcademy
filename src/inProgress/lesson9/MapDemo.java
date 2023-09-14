package inProgress.lesson9;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {
    public static void main(String[] args) {
        String newString = "bbbbbaacccaaaaaaaaaaacccccccccccbbbb";
        getCharsCount(newString);
        System.out.println();

        String text = "What happened to Osteen that winter day is what experts call a “near-death experience.” It can occur when doctors bring a person back to " +
                "life after the heart flatlines and breathing stops — which happens when a person dies for any reason, not just during a heart attack." +
                "Millions of people have reported near-death experiences since cardiopulmonary resuscitation, better known as CPR, was invented in 1960, said " +
                "Dr. Sam Parnia, an NYU Langone Health intensive care physician who has researched the phenomena for decades.";
        getCharsCount(text);
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

        charsArray.forEach((k, v) -> System.out.print("| " + k + " - " + v + " |"));
    }
}
