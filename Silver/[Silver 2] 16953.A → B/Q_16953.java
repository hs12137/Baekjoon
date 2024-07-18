import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_16953 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(A, 1));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.value == B) {
                System.out.println(node.count);
                return;
            }
            long val1 = node.value * 2;
            long val2 = node.value * 10 + 1;
            if (val1 <= B) queue.add(new Node(val1, node.count + 1));
            if (val2 <= B) queue.add(new Node(val2, node.count + 1));
        }
        System.out.println(-1);
    }
    private static class Node{
        long value;
        int count;
        Node(long value, int count) {
            this.value = value;
            this.count = count;
        }
    }
}
