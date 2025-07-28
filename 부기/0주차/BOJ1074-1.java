import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/1074
// 캐시를 통해 depth를 줄임 내가 푼 방식
class Main {
    static int c = 0;
    static int R;
    static int C;
    static Map<Integer, Integer> CACHE = new HashMap<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int n = (int) Math.pow(2, N);

        search(0, 0, n-1, n-1, 0);

    }

    public static int search(int x1, int y1, int x2, int y2, int depth){
        if(!(x1 <= R && R <= x2 && y1 <= C && C <= y2)
                && CACHE.containsKey(depth)){
            c += CACHE.get(depth);
            return CACHE.get(depth);
        }

        if(x2 - x1 == 1 && y2 - y1 == 1){
            int count = 0;
            for(int i=x1; i<=x2; i++){
                for(int j=y1; j<=y2; j++){
                    if(i == R && j == C){
                        System.out.println(c + count);
                        System.exit(0);
                    }
                    count++;
                }
            }
            CACHE.put(depth, count);
            c += count;
            return count;
        }

        int count = 0;
        count += search(x1, y1, (x1 + x2) / 2, (y1 + y2) / 2, depth + 1);
        count += search(x1, (y1 + y2) / 2 + 1, (x1 + x2) / 2, y2 , depth + 1);
        count += search((x1 + x2) / 2 + 1, y1, x2, (y1 + y2) / 2, depth + 1);
        count += search((x1 + x2) / 2 + 1, (y1 + y2) / 2 + 1, x2, y2, depth + 1);
        CACHE.put(depth, count);
        return count;
    }
}
