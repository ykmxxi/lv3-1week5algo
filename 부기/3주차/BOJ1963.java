import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static boolean[] isPrime = new boolean[10000];
    static boolean[] visit;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        init();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine());

            String a = st.nextToken();
            String b = st.nextToken();

            visit = new boolean[10000];
            int answer = BFS(a, b);
            System.out.println(answer == -1 ? "Impossible" : answer);

        }

    }

    public static int BFS(String start, String target){
        Deque<Node> q = new ArrayDeque<>();

        q.add(new Node(start, 0));
        while(!q.isEmpty()){
            Node now = q.pollFirst();

            if(target.equals(now.x)){
                return now.depth;
            }
            visit[Integer.parseInt(now.x)] = true;

            char[] n = now.x.toCharArray();
            for(int i=0; i<4; i++){

                char before = n[i];
                for(int j= i == 0 ? 1 : 0; j<10; j++){

                    n[i] = (char) (j + '0');
                    String nex = new String(n);
                    int next = Integer.parseInt(nex);
                    if(!visit[next] && !isPrime[next]){
                        q.addLast(new Node(nex, now.depth + 1));
                    }
                }
                n[i] = before;
            }

        }

        return -1;

    }

    public static void init(){
        int max = (int) Math.sqrt(10000);
        for(int i=2; i<max; i++){

            for(int j=2; i * j<10000; j++){
                isPrime[i * j] = true;
            }
        }
    }

    public static class Node{
        String x;
        int depth;

        public Node(String x, int depth){
            this.x = x;
            this.depth = depth;
        }
    }

}
