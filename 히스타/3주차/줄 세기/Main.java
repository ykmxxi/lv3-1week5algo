//  줄 세기

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lineCount = 0;
        while (br.readLine() != null) {
            lineCount++;
        }
        System.out.println(lineCount);
    }
}
