import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q_2164 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        for(int i = 1; i <= n; i++){
            queue.add(i);
        }
        Integer answer = queue.poll();
        while(!queue.isEmpty()){
            queue.add(queue.poll());
            answer = queue.poll();
        }
        System.out.println(answer);
    }
}
