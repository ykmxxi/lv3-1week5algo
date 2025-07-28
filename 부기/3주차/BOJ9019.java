import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/9019
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for(int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Num start = new Num(
                    N / 1000,
                    (N % 1000) / 100,
                    (N % 100) / 10,
                    N % 10,
                    ""
            );

            System.out.println(bfs(start, M));
        }

    }

    public static String bfs(Num start, int target){
        Deque<Num> q = new ArrayDeque<>();
        boolean[] visit = new boolean[10000];

        q.add(start);
        visit[start.val()] = true;
        while (!q.isEmpty()) {
            Num now = q.pollFirst();

            if(now.val() == target){
                return now.oper;
            }

            Num d = now.d();
            Num s = now.s();
            Num l = now.l();
            Num r = now.r();
            if(!visit[d.val()]){
                visit[d.val()] = true;
                q.addLast(d);
            }
            if(!visit[s.val()]){
                visit[s.val()] = true;
                q.addLast(s);
            }
            if(!visit[l.val()]){
                visit[l.val()] = true;
                q.addLast(l);
            }
            if(!visit[r.val()]){
                visit[r.val()] = true;
                q.addLast(r);
            }

        }
        return "";

    }

    public static class Num{
        int a;
        int b;
        int c;
        int d;
        String oper;

        public Num(int a, int b, int c, int d, String oper){
            this.a=a;
            this.b=b;
            this.c=c;
            this.d=d;
            this.oper=oper;
        }

        public Num d(){
            int val = (val() * 2) % 10000;
            return num(val, "D");
        }

        public Num s(){
            int val = val() - 1;
            return val == -1 ? num(9999, "S") : num(val, "S");
        }

        public Num l(){
            return new Num(b, c, d, a, this.oper+"L");
        }

        public Num r(){
            return new Num(d, a, b, c, this.oper+"R");
        }

        public int val(){
            return (a * 1000) + (b * 100) + (c * 10) + d;
        }

        private Num num(int val, String oper){
            return new Num(
                    val / 1000,
                    (val % 1000) / 100,
                    (val % 100) / 10,
                    val % 10,
                    this.oper + oper
            );
        }

        private Num num(int a, int b, int c, int d, String oper){
            return new Num(a, b, c, d, this.oper + oper);
        }

    }

}
