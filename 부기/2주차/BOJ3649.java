import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/3649
class BOJ3649 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nano = 10_000_000;

        StringBuilder sb = new StringBuilder();
        while(true){
            String s = br.readLine();
            if(s == null){
                break;
            }
            long size = Long.parseLong(s) * nano;

            int N = Integer.parseInt(br.readLine());

            List<Integer> list = new ArrayList<>();
            for(int i=0; i<N; i++){
                list.add(Integer.parseInt(br.readLine()));
            }
            Collections.sort(list);

            boolean isDanger = true;
            for(int i=0; i<N; i++){
                int idx = binarySearch(list, i, size);
                if(list.get(idx) + list.get(i) == size && idx != i){
                    isDanger = false;
                    sb.append("yes ")
                            .append(list.get(i)).append(" ").append(list.get(idx))
                            .append("\n");
                    break;
                }
            }

            if(isDanger){
                sb.append("danger\n");
            }
        }

        System.out.println(sb);
    }

    public static int binarySearch(List<Integer> list, int i, long size){
        long x = list.get(i);
        int l = i + 1;
        int h = list.size() - 1;

        int mid;
        while(l <= h){
            mid = (l + h) / 2;

            long sum = x + list.get(mid);
            if(sum <= size){
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }

        return h;
    }

    // 1 2 3
    // 정답이 1, 2, 3에 없는 경우 h가 0을 가르키는데 이렇게 하면 같은 블럭 2개를 선택하게 되는 문제가 있음
    // l=1 h=1; l=1 h=0
    // l=1 h=1; l=2 h=1;
    // l=3 h=3; l=3 h=2;
    // l=3 h=3; l=4 h=3;
}
