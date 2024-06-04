import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_1697 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[100001];
        Queue<Node> queue = new LinkedList<>();
        visited[n] = true;
        queue.add(new Node(n, 0));
        while(true) {
            Node node = queue.poll();
            if(node.value == k) {
                System.out.println(node.depth);
                break;
            } else if (node.value > k) {
                if(!visited[node.value - 1]) {
                    queue.add(new Node(node.value - 1, node.depth + 1));
                    visited[node.value - 1] = true;
                }
            } else {
                if(node.value > 0 && !visited[node.value - 1]) {
                    queue.add(new Node(node.value - 1, node.depth + 1));
                    visited[node.value - 1] = true;
                }
                if(node.value < 100000 && !visited[node.value + 1]) {
                    queue.add(new Node(node.value + 1, node.depth + 1));
                    visited[node.value + 1] = true;
                }
                if(node.value <= 50000 && !visited[node.value * 2]) {
                    queue.add(new Node(node.value * 2, node.depth + 1));
                    visited[node.value * 2] = true;
                }
            }
        }
    }
    static class Node{
        int value;
        int depth;
        Node(int value, int depth){
            this.value = value;
            this.depth = depth;
        }
    }
}
