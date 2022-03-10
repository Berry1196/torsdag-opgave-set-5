import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main
{
    static Scanner scan;
    private static String[] text;

    public static void main(String[] args) throws FileNotFoundException
    {
        File file = new File("data.txt");
        scan = new Scanner(file);

        String inputFromFile = "";

        while (scan.hasNextLine())                                // checks if theres more lines in the file
        {
            inputFromFile += scan.nextLine();                     // adds each line to the inputFromFile string.
        }

        text = inputFromFile.split(" ");                    // Creates and array of strings, where each element is a single word from the file.
        //System.out.println(text.length);


        printWordsStartingWith("Ø");

       printWordsOfLength(3);


        //test dine metoder ved at kalde dem her:
        printLongestWord();
        printFirstHalfOfEachWord();
        printMostFrequentLetter();
        printLessFrequentLetter();
    }

    private static void printWordsOfLength(int l)
    {
        boolean wordisvalid = true;

        for (String s : text)
        {
            if (s.length() == l)
            {
                if (s.contains(",") || s.contains("."))
                {
                    wordisvalid = false;
                }

                if (wordisvalid)
                {
                    System.out.println(s);
                }
            }
        }
    }

    private static void printWordsStartingWith(String pattern)
    {
        for (String s : text) // for each word in text
        {
            if (s.startsWith(pattern) || s.startsWith(pattern.toLowerCase()))
            {
                System.out.println(s);
            }
        }
    }

    //skriv dine metoder herunder:
    private static void printLongestWord()
    {
        int maxLength = 0;
        String tempLongestWord = "";
        for (String s : text)
        {
            if (s.length() > maxLength)
            {
                maxLength = s.length();
                tempLongestWord = s;
            }
        }
        System.out.println("Fejl i filen, men det længste 'ord' er: " + tempLongestWord);
    }

    private static void printFirstHalfOfEachWord()
    {
        for (String word : text)
        {
                System.out.println(word.substring(0,word.length() /2));
        }

    }

    private static void printMostFrequentLetter()
    {
        HashMap<Character, Integer> map = new HashMap();

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < text.length; i++) {
            sb.append(text[i]);
        }

        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            Integer val = map.get(c);
            if (val != null) {
                map.put(c, new Integer(val + 1));
            }
            else {
                map.put(c, 1);
            }
        }

        int maxValueInMap = (Collections.max(map.values()));
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {  // Iterate through hashmap
            if (entry.getValue()==maxValueInMap) {
                System.out.println("Least used letter: " + entry.getKey());     // Print the letter with max value
                System.out.println("Number of times read: " + maxValueInMap);     // Print the number with max value
            }
        }

    }

    private static void printLessFrequentLetter()
    {
        HashMap<Character, Integer> map = new HashMap();

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < text.length; i++) {
            sb.append(text[i]);
        }

        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            Integer val = map.get(c);
            if (val != null) {
                map.put(c, new Integer(val + 1));
            }
            else {
                map.put(c, 1);
            }
        }

        int minValueInMap = (Collections.min(map.values()));
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {  // Iterate through hashmap
            if (entry.getValue()==minValueInMap) {
                System.out.println("Least used letter: " + entry.getKey());     // Print the letter with max value
                System.out.println("Number of times read: " + minValueInMap);     // Print the number with max value
            }
        }

    }

}
