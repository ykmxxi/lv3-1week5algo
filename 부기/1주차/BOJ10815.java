import java.util.*;
import java.lang.*;
import java.io.*;


// https://www.acmicpc.net/problem/10815
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            sb.append(binarySearch(list, Integer.parseInt(st.nextToken())) ? 1 : 0).append(" ");
        }

        System.out.println(sb);


    }

    public static boolean binarySearch(List<Integer> list, int target){
        if(target > list.get(list.size()-1)){
            return false;
        }

        int l = 0;
        int h = list.size()-1;

        int mid;

        while(l <= h){
            mid = (l + h) / 2;

            if(target > list.get(mid)){
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }


        return list.get(l) == target;
    }
}
