package inProgress.lesson8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String[] line = {"abcabctext", "dcabtext"};
        String text = "      The psychedelic lysergic  acid diethylamide (LSD) has experienced a revival in research, including clinical trials that evaluate " +
                "LSD-assisted psychotherapy.   012345678910   LSD induces perceptual alterations and influences emotion processing in ways that may support psychotherapy. " +
                "         Here, we investigated the effects of LSD on emotional     empathy and mediating role of the serotonin 5-hydroxytryptamine-2A (5-HT2A) receptor " +
                "by administering 25, 50, 100, and 200 µg LSD alone and 200 µg LSD combined with pretreatment with the 5-HT2A receptor antagonist ketanserin (40 mg) " +
                "using a placebo-controlled, double-blind, random-order, crossover design in 16 healthy subjects. 123456789         ";

        //task #1
        for (String currentText: line) {
            currentText = currentText.startsWith("abc") ? currentText.replaceFirst("abc", "www") : currentText.concat("zzz");
            System.out.println("Replaced string: " + currentText);
        }

        //task #2
        text = text.replaceAll("^\\s+ | \\s+$", "").replaceAll("\\s+", " ");
        System.out.println("\nString in normalized form: \n" + text + "\n");

        //task #3.1
        Pattern findNumbers = Pattern.compile("\\d+");
        Matcher cutNumber = findNumbers.matcher(text);
        String numberWithMaxNumberOfDigits = "";

        while (cutNumber.find()) {
            if (text.substring(cutNumber.start(), cutNumber.end()).length() > numberWithMaxNumberOfDigits.length()) {
                numberWithMaxNumberOfDigits = text.substring(cutNumber.start(), cutNumber.end());
            }
        }
        System.out.println("The longest number: " + numberWithMaxNumberOfDigits + "\n");

        //task #3.2
        Pattern findWords = Pattern.compile("[µa-zA-Z]+|(\\d-)?[a-zA-Z]+-?(\\d[a-zA-Z]+)?");
        Matcher cutWord = findWords.matcher(text);

        String theLongestWord = text.split("\\s")[0];
        String theShortestWord = theLongestWord;
        int positionOfFirstLongestWord = 0;
        int positionOfLastShortestWord = 0;

        while (cutWord.find()) {
            if (text.substring(cutWord.start(), cutWord.end()).length() > theLongestWord.length()) {
                theLongestWord = text.substring(cutWord.start(), cutWord.end());
                positionOfFirstLongestWord = cutWord.start();
            }
            if (text.substring(cutWord.start(), cutWord.end()).length() <= theShortestWord.length()) {
                theShortestWord = text.substring(cutWord.start(), cutWord.end());
                positionOfLastShortestWord = cutWord.start();
            }
        }

        if (positionOfFirstLongestWord < positionOfLastShortestWord) {
            positionOfLastShortestWord = positionOfLastShortestWord + theShortestWord.length() - theLongestWord.length();
        }

        System.out.println("First the longest word: " + theLongestWord + ", replacement position: " + positionOfFirstLongestWord);
        System.out.println("Second the shortest word: " + theShortestWord + ", replacement position: " + positionOfLastShortestWord);

        StringBuilder changeWords = new StringBuilder(text);
        changeWords.replace(positionOfFirstLongestWord, positionOfFirstLongestWord + theLongestWord.length(), theShortestWord);
        changeWords.delete(positionOfLastShortestWord, positionOfLastShortestWord + theShortestWord.length()).insert(positionOfLastShortestWord, theLongestWord);
        text = String.valueOf(changeWords);

        System.out.println(text + "\n");

        //task #3.3
        Pattern findPunctuationMarks = Pattern.compile("\\p{P}");
        Matcher punctuationMarks = findPunctuationMarks.matcher(text);
        int numberOfPunctuationMarks = 0;

        while (punctuationMarks.find()) {
            numberOfPunctuationMarks++;
        }

        System.out.println("Number of punctuation marks: " + numberOfPunctuationMarks + "\n");

        //task #4
        String[] emails = {"my_email@gmail.com", "myemail-@gmail.com", "a.petrov@gmail.com.au", "coder4575@yandex.ru", "myemail@gmail.com", " myemail@gmail.com",
                "my email@gmail.com", "elena.Turova@patio-minsk.by", "elena.Turova@patio-minsk", "123", "aaffe", "testmail@mail.de.рф"};

        for (String email : emails) {
            if (checkEmail(email)) {
                System.out.println(email + " is correct");
            } else {
                System.out.println(email + " is incorrect");
            }
        }
        System.out.println();

        //task #5
        String[] ipAddresses = {"127.0.0.1", "255.255.255.253", "100.99.44.2", "100.99.44", "123", "abc", "100,99,44,2", "100 99 44 2", "256.255.255.253", "-252.255.255.253"};

        for (String ipAddress : ipAddresses) {
            if (checkIPAddress(ipAddress)) {
                System.out.println(ipAddress + " is correct");
            } else {
                System.out.println(ipAddress + " is incorrect. You must enter four groups of numbers in the format 0.0.0.0. " +
                        "The size of each group cannot be less than 0 and greater than 255!");
            }
        }

    }

    public static boolean checkEmail(String email) {
        Pattern patternEmail = Pattern.compile("^[a-zA-Z0-9]+[_\\-.]?[a-zA-Z0-9]+@[a-zA-Z0-9]+[_\\-.]?[a-zA-Z0-9]+\\.[a-zа-я]{2,6}");
        Matcher matcherEmail = patternEmail.matcher(email);

        return matcherEmail.matches();
    }

    public static boolean checkIPAddress(String ipAddress) {
        String[] groups = ipAddress.split("\\.");
        boolean checkGroupSize = true;
        for (String currentGroup : groups) {
            try {
                if (Integer.parseInt(currentGroup) < 0 || Integer.parseInt(currentGroup) > 255) {
                    checkGroupSize = false;
                    break;
                }
            } catch (NumberFormatException numberFormatException) {
                checkGroupSize = false;
            }
        }
        if (checkGroupSize) {
            Pattern patternIPAddress = Pattern.compile("^(\\d{1,3}\\.){3}\\d{1,3}");
            Matcher matcherIPAddress = patternIPAddress.matcher(ipAddress);

            return matcherIPAddress.matches();
        } else {
            return false;
        }
    }
}
