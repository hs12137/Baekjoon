import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q_11279 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            int output = 0;
            if(x == 0) {
                if(!priorityQueue.isEmpty()) output = priorityQueue.remove();
                sb.append(output).append("\n");
            }
            else priorityQueue.add(x);
        }
        System.out.println(sb);
    }
}