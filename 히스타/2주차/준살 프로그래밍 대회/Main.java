//  준살 프로그래밍 대회

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for (int scenario = 1; scenario <= TC; ++scenario) {
            System.out.println("Scenario #" + scenario + ":");
            int wordCount = sc.nextInt();
            List<String> wordList = IntStream.range(0, wordCount)
                    .mapToObj(i -> sc.next())
                    .collect(Collectors.toList());

            int userCount = sc.nextInt();
            while (userCount-- > 0) {
                int passwordCount = sc.nextInt();
                String password = IntStream.range(0, passwordCount)
                        .mapToObj(i -> {
                            int wordIndex = sc.nextInt();
                            return wordList.get(wordIndex);
                        })
                        .collect(Collectors.joining());

                System.out.println(password);
            }
            System.out.println();
        }
    }
}
