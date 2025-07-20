//  #include <Google I/O.h>

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; ++tc) {
            sc.nextInt();
            String input = sc.next();
            // 1. 'O' → '0', 'I' → '1'
            String binary = input.replace('O', '0').replace('I', '1');

            // 2. 8자리씩 나누고 → 10진수 변환 → 문자로 변환
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < binary.length(); i += 8) {
                String byteString = binary.substring(i, i + 8);
                int decimal = Integer.parseInt(byteString, 2);
                result.append((char) decimal);
            }

            System.out.printf("Case #%d: %s%n", tc, result);
        }
    }
}
