//  브실혜성

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String date = br.readLine().trim();
        long N = Long.parseLong(br.readLine().trim());

        String[] parts = date.split("-");
        long y = Long.parseLong(parts[0]);
        long m = Long.parseLong(parts[1]);
        long d = Long.parseLong(parts[2]);

        long total = y * 360 + (m - 1) * 30 + (d - 1);
        total += N;

        long ny = total / 360;
        long rem = total % 360;
        long nm = rem / 30 + 1;
        long nd = rem % 30 + 1;

        System.out.printf("%04d-%02d-%02d%n", ny, nm, nd);
    }
}
