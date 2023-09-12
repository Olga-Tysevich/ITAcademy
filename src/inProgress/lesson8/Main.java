package inProgress.lesson8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String[] arrayOfStrings = {"abcabctext", "dcabtext"};
        String text = "      The psychedelic lysergic  acid diethylamide (LSD) has experienced a revival in research, including clinical trials that evaluate " +
                "LSD-assisted psychotherapy.   012345678910   LSD induces perceptual alterations and influences emotion processing in ways that may support psychotherapy. " +
                "         Here, we investigated the effects of LSD on emotional     empathy and mediating role of the serotonin 5-hydroxytryptamine-2A (5-HT2A) receptor " +
                "by administering 25, 50, 100, and 200 µg LSD alone and 200 µg LSD combined with pretreatment with the 5-HT2A receptor antagonist ketanserin (40 mg) " +
                "using a placebo-controlled, double-blind, random-order, crossover design in 16 healthy subjects. 123456789           ";

        //task #1
        for (String currentString: arrayOfStrings) {
            currentString = currentString.startsWith("abc") ? currentString.replaceFirst("abc", "www") : currentString.concat("zzz");
            System.out.println("Replaced string: " + currentString);
        }

        //task #2
        text = text.replaceAll("^\\s+ | \\s+$", "").replaceAll("\\s{2,}", " ");
        System.out.println("\nString in normalized form: \n" + text + "\n");

        //task #3.1
        Pattern patternNumbers = Pattern.compile("\\d+");
        Matcher matcherNumber = patternNumbers.matcher(text);
        String numberWithMaxNumberOfDigits = "";

        while (matcherNumber.find()) {
            if (text.substring(matcherNumber.start(), matcherNumber.end()).length() > numberWithMaxNumberOfDigits.length()) {
                numberWithMaxNumberOfDigits = text.substring(matcherNumber.start(), matcherNumber.end());
            }
        }

        System.out.println("The longest matcherNumber: " + numberWithMaxNumberOfDigits + "\n");

        //task #3.2
        Pattern patternWords = Pattern.compile("\\w*-?[µa-zA-Z]+-?\\w*");
        Matcher matcherWord = patternWords.matcher(text);

        String longestWord = text.split("\\s")[0];
        String shortestWord = longestWord;
        int positionOfLastShortestWord = 0;

        while (matcherWord.find()) {
            if (text.substring(matcherWord.start(), matcherWord.end()).length() > longestWord.length()) {
                longestWord = text.substring(matcherWord.start(), matcherWord.end());
            }
            if (text.substring(matcherWord.start(), matcherWord.end()).length() <= shortestWord.length()) {
                shortestWord = text.substring(matcherWord.start(), matcherWord.end());
                positionOfLastShortestWord = matcherWord.start();
            }
        }

        if (text.indexOf(longestWord) < positionOfLastShortestWord) {
            positionOfLastShortestWord = positionOfLastShortestWord + shortestWord.length() - longestWord.length();
        }

        System.out.println("First the longest word: " + longestWord + ", replacement position: " + text.indexOf(longestWord));
        System.out.println("Second the shortest word: " + shortestWord + ", replacement position: " + positionOfLastShortestWord);

        StringBuilder swapWords = new StringBuilder(text.replaceFirst(longestWord, shortestWord));
        swapWords.delete(positionOfLastShortestWord, positionOfLastShortestWord + shortestWord.length()).insert(positionOfLastShortestWord, longestWord);
        text = String.valueOf(swapWords);

        System.out.println(text + "\n");

        //task #3.3
        Pattern patternPunctuationMarks = Pattern.compile("\\p{P}");
        Matcher matcherPunctuationMarks = patternPunctuationMarks.matcher(text);
        int numberOfPunctuationMarks = 0;

        while (matcherPunctuationMarks.find()) {
            numberOfPunctuationMarks++;
        }

        System.out.println("Number of punctuation marks: " + numberOfPunctuationMarks + "\n");

        //task #4
        String[] arrayOfEmails = {"my_email@gmail.com", "myemail-_a@gmail.com", "a.petrov@gmail.com.au", "coder4575@yandex.ru", "myemail@gmail.com", " myemail@gmail.com",
                "my email@gmail.com", "elena.turova@patio-minsk.by", "elena.turova@patio-minsk", "123", "aaffe", "stalnoy.igor.a@gmail.com"};

        for (String currentEmail : arrayOfEmails) {
            if (checkEmail(currentEmail)) {
                System.out.println(currentEmail + " is correct");
            } else {
                System.out.println(currentEmail + " is incorrect");
            }
        }

        System.out.println();

        //task #5
        String[] arrayOfIpAddresses = {"127.0.0.1", "255.255.255.253", "100.99.44.2", "100.99.44", "123", "abc", "100,99,44,2", "100 99 44 2", "256.255.255.253",
                "952.255.255.253"};

        for (String currentIpAddress : arrayOfIpAddresses) {
            if (checkIPAddress(currentIpAddress)) {
                System.out.println(currentIpAddress + " is correct");
            } else {
                System.out.println(currentIpAddress + " is incorrect. You must enter four groups of numbers in the format 0.0.0.0. " +
                        "The size of each group cannot be less than 0 and greater than 255!");
            }
        }

    }

    public static boolean checkEmail(String email) {
        //Знаю что в задании про это не сказано, но мне все же кажется что имейлы начинающиеся или заканчивающиеся подчеркиванием, ровно как имейлы вида
        // myem___ail-_a@gmail.com некорректны, поэтому я не использовала \w
        Pattern patternEmail = Pattern.compile("^([a-zA-Z0-9]+[_\\-.]?[a-zA-Z0-9]+)+@([a-zA-Z0-9]+[_\\-.]?[a-zA-Z0-9]+)+\\.[a-z]{2,6}");
        Matcher matcherEmail = patternEmail.matcher(email);

        return matcherEmail.matches();
    }

    public static boolean checkIPAddress(String ipAddress) {
            Pattern patternIPAddress = Pattern.compile("^((\\d{1,2}|[12][0-4]\\d|[12][0-5]{2})\\.){3}(\\d{1,2}|[12][0-4]\\d|[12][0-5]{2})");
            Matcher matcherIPAddress = patternIPAddress.matcher(ipAddress);

            return matcherIPAddress.matches();
    }
}
