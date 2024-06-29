import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Q_5430 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            char[] input = br.readLine().toCharArray();
            int len = Integer.parseInt(br.readLine());
            Deque<Integer> deque = new ArrayDeque<>();
            String s = br.readLine();
            if (len != 0) {
                for (int num: Arrays.stream(s.substring(1, s.length()-1).split(",")).mapToInt(Integer::parseInt).toArray()) {
                    deque.add(num);
                }
            }
            boolean canSolve = true;
            boolean flag = true;
            for(char c : input) {
                if (c == 'R') flag = !flag;
                else if (deque.isEmpty()) {
                    canSolve = false;
                    break;
                } else {
                    len --;
                    if (flag) deque.removeFirst();
                    else deque.removeLast();
                }
            }
            if (canSolve && len > 0) {
                result.append("[");
                if (flag) {
                    while (!deque.isEmpty()) result.append(deque.removeFirst()).append(",");
                } else {
                    while (!deque.isEmpty()) result.append(deque.removeLast()).append(",");
                }
                result.deleteCharAt(result.length()-1).append("]").append("\n");
            } else if (canSolve) result.append("[]\n");
            else result.append("error").append("\n");
        }
        System.out.println(result);
    }
}
