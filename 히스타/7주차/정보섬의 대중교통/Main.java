//  정보섬의 대중교통

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int subwayWalkingTime = sc.nextInt();
        int busWaitingTime = sc.nextInt();
        int subwayWaitingTime = sc.nextInt();

        if (subwayWalkingTime > subwayWaitingTime) {
            // 막차를 잡는것은 불가능하므로 무조건 버스
            System.out.println("Bus");
            return;
        }

        if (subwayWaitingTime == busWaitingTime) {
            System.out.println("Anything");
            return;
        }

        if (subwayWaitingTime > busWaitingTime) {
            System.out.println("Bus");
            return;
        }

        System.out.println("Subway");
    }
}
