import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

//
public class BOJ2800 {

    static final int MAXN = 201;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inp = br.readLine();
        char[] A = new char[inp.length()];
        for (int i = 0; i < inp.length(); i++) {
            A[i] = inp.charAt(i);
        }

        int[] numbers = numbering(A);
        int maxNumber = -1;
        for (int i = 0; i < numbers.length; i++) {
            maxNumber = Math.max(maxNumber, numbers[i]);
        }

        ArrayList<String> answers = new ArrayList<>();

        dfs(0, answers, 0, A, numbers, maxNumber);
        Collections.sort(answers);
        answers.remove(inp);
        List<String> uniqueAnswers = answers.stream()
                .distinct()
                .collect(Collectors.toList()); // toList는 Java 16 이상
        for (String answer : uniqueAnswers) {
            System.out.println(answer);
        }
    }

    private static void dfs(int ni, ArrayList<String> answers, int checkBit,
                            final char[] A, final int[] numbers, final int maxNumber) {
        if (ni == maxNumber + 1) {
            String answer = "";
            for (int i = 0; i < A.length; i++) {
                if (A[i] == '(' || A[i] == ')') {
                    if (((checkBit >> numbers[i]) & 1) > 0) {
                        answer += A[i];
                    }
                } else {
                    answer += A[i];
                }
            }
            answers.add(answer);
            return;
        }

        dfs(ni + 1, answers, checkBit, A, numbers, maxNumber);
        dfs(ni + 1, answers, checkBit | (1 << ni), A, numbers, maxNumber);
    }

    private static int[] numbering(char[] A) {
        int[] numbers = new int[A.length];
        Deque<Integer> deq = new ArrayDeque<>();
        int number = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == '(') {
                numbers[i] = number;
                deq.addLast(number);
                number++;
            } else if (A[i] == ')') {
                numbers[i] = deq.pollLast();
            }
        }
        return numbers;
    }
}
