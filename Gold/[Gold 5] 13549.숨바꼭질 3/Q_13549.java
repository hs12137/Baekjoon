import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Deque;

public class Q_13549 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[100001];
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(n, 0));
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.location == k) {
                System.out.println(node.move);
                break;
            } else if (node.location < k) {
                if (node.location <= 50000 && !visited[node.location*2]) {
                    visited[node.location * 2] = true;
                    queue.addFirst(new Node(node.location * 2, node.move));
                }
                if (node.location > 0 && !visited[node.location-1]) {
                    visited[node.location-1] = true;
                    queue.add(new Node(node.location-1, node.move + 1));
                }
                if (node.location < 100000 && !visited[node.location+1]) {
                    visited[node.location+1] = true;
                    queue.add(new Node(node.location+1, node.move + 1));
                }
            } else {
                if (!visited[node.location-1]) {
                    visited[node.location-1] = true;
                    queue.add(new Node(node.location-1, node.move + 1));
                }
            }
        }
    }
    private static class Node {
        int location;
        int move;
        Node(int location, int move) {
            this.location = location;
            this.move = move;
        }
    }
}
