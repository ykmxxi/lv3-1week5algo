package BOJ;

import java.io.*;
import java.util.*;

public class BOJ6603 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while (!(line = br.readLine()).equals("0")) {
            StringTokenizer st = new StringTokenizer(line);
            int k = Integer.parseInt(st.nextToken());
            int[] arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            List<Integer> path = new ArrayList<>();
            List<List<Integer>> result = new ArrayList<>();
            combine(arr, 6, 0, path, result);

            for (List<Integer> integers : result) {
                for (Integer integer : integers) {
                    System.out.print(integer + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void combine(int[] arr, int r, int start, List<Integer> path, List<List<Integer>> result) {
        if (path.size() == r) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < arr.length; i++) {
            path.add(arr[i]);
            combine(arr, r, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }
}
