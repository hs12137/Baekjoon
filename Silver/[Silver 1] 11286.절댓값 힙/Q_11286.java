import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q_11286 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> plusPQ = new PriorityQueue<>();
        PriorityQueue<Integer> minusPQ = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num != 0) {
                if(num < 0) minusPQ.add(num);
                else plusPQ.add(num);
            } else {
                if(plusPQ.isEmpty() && minusPQ.isEmpty()) sb.append(0).append("\n");
                else if(!plusPQ.isEmpty() && minusPQ.isEmpty()) sb.append(plusPQ.poll()).append("\n");
                else if(plusPQ.isEmpty()) sb.append(minusPQ.poll()).append("\n");
                else if(plusPQ.peek()+minusPQ.peek()<0) sb.append(plusPQ.poll()).append("\n");
                else sb.append(minusPQ.poll()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
