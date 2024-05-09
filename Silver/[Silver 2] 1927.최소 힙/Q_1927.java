import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Q_1927 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            int x = Integer.parseInt(br.readLine());
            if(x == 0){
                if(priorityQueue.isEmpty()) sb.append(0).append("\n");
                else sb.append(priorityQueue.remove()).append("\n");
            }else priorityQueue.add(x);
        }
        System.out.println(sb);
    }
}