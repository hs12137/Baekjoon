import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_9019 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            boolean[] visited = new boolean[10001];
            visited[A] = true;
            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(A, ""));
            Node node = null;
            while (!queue.isEmpty()) {
                node = queue.poll();
                if (node.num == B) break;
                int D = (node.num * 2) % 10000;
                int S = (node.num + 9999) % 10000;
                int L = node.num * 10 % 10000 + node.num / 1000;
                int R = node.num / 10 + node.num % 10 * 1000;
                if (!visited[D]) {
                    visited[D] = true;
                    queue.add(new Node(D, node.command + "D"));
                }
                if (!visited[S]) {
                    visited[S] = true;
                    queue.add(new Node(S, node.command + "S"));
                }
                if (!visited[L]) {
                    visited[L] = true;
                    queue.add(new Node(L, node.command + "L"));
                }
                if (!visited[R]) {
                    visited[R] = true;
                    queue.add(new Node(R, node.command + "R"));
                }
            }
            sb.append(node.command).append("\n");
        }
        System.out.println(sb);
    }
    private static class Node{
        int num;
        String command;
        Node(int num, String command){
            this.num = num;
            this.command = command;
        }
    }
}
