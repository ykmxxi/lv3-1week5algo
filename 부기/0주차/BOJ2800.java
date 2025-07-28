import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/2800
class Main {
    // ((2))와 같은 경우를 걸러내기 위해 중복 정답 제거
    static Set<String> answer = new HashSet<>();
    static StringBuilder sb;
    static char[] values;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        values = br.readLine().toCharArray();

        Deque<Integer> q = new ArrayDeque<>();
        List<Node> nodes = new ArrayList<>();
        for(int i=0; i<values.length; i++){
            char now = values[i];

            if(now == '('){
                q.addLast(i);
            }
            else if(now == ')'){
                int x = q.pollLast();
                nodes.add(new Node(x, i));
            }
        }

        dfs(nodes, new boolean[nodes.size()], 0);
        List<String> ab = new ArrayList<>(answer);
        Collections.sort(ab);
        sb = new StringBuilder();
        for(String a : ab){
            sb.append(a).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(List<Node> nodes, boolean[] visit, int now){
        for(int i=now; i<nodes.size(); i++){
            if(!visit[i]){
                visit[i] = true;
                sb = new StringBuilder();

                for(int j=0; j<values.length; j++){
                    boolean flag = false;

                    for(int k=0; k<visit.length; k++){
                        if(visit[k] && (nodes.get(k).x == j || nodes.get(k).y == j)){
                            flag = true;
                            break;
                        }
                    }
                    if(!flag){
                        sb.append(values[j]);
                    }
                }
                answer.add(sb.toString());
                dfs(nodes, visit, i);
                visit[i] = false;
            }
        }
    }

    public static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

}
