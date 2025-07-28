import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/12015
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> answer = new ArrayList<>();
        answer.add(list.get(0));
        for(int i=1; i<N; i++){
            if(answer.get(answer.size() - 1) < list.get(i)){
                answer.add(list.get(i));
            } else {
                int idx = binarySearch(answer, list.get(i));
                answer.set(idx + 1,list.get(i));
            }
        }

        System.out.println(answer.size());


    }

    public static int binarySearch(List<Integer> list, int now){
        int l = 0;
        int h = list.size() - 1;

        int mid;
        while (l<=h) {
            mid = (l + h) / 2;

            if(list.get(mid) < now){
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }

        return h;
    }
    // 1 2 3
    // l=1 h=1; l=
}
