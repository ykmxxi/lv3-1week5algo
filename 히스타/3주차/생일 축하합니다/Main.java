// 생일 축하합니다~

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 이름 입력받기
        List<String> names = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            String nickname = sc.next();
            names.add(nickname);
        }

        /**
         * 인터렉터는 생일인 사람을 생일이 아니라고 1번 거짓말 할 수 있다.
         * 즉, 생일이라고 말한 사람은 무조건 생일이다.
         * 생일임이 확실해졌을 경우 ! 닉네임으로 생일을 축하한다.
         * 만약 모든 닉네임을 순회했는데, 아무도 생일이 아니라면 다시 순회한다.
         * 사람들의 수는 500 이하이기 때문에, 1000 이하의 질문으로 생일자를 얻어낼 수 있다.
         */

        // 질문 이후에는 반드시 개행 후 출력 버퍼 flush
        for (int i = 0; i < names.size(); ++i) {
            // 질문
            System.out.println("? " + names.get(i));
            System.out.flush();
            int answer = sc.nextInt();
            if (answer == 1) {
                System.out.println("! " + names.get(i));
                System.out.flush();
                return;
            }
        }

        // 만약 아직 생일자를 밝히지 못했을 경우
        for (int i = 0; i < names.size(); ++i) {
            // 질문
            System.out.println("? " + names.get(i));
            System.out.flush();
            int answer = sc.nextInt();
            if (answer == 1) {
                System.out.println("! " + names.get(i));
                System.out.flush();
                return;
            }
        }
    }
}
