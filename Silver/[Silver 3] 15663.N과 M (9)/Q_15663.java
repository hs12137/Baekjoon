import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q_15663 {

    static int n, m, before;
    static int[] arr;
    static StringBuilder sb;
    static Stack<Node> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int before = 0;

        for(int i = n-1; i >= 0; i--) {
            if (i > 0 && arr[i] == arr[i-1]) continue;
            boolean[] visited = new boolean[n];
            visited[i] = true;
            stack.add(new Node(1, arr[i] + " ", visited));
        }
        while(!stack.isEmpty()) {
            Node node = stack.pop();

            if (node.index == m) {
                sb.append(node.seq).append('\n');
                continue;
            }

            for (int i = n-1; i >= 0; i--) {
                if(!node.visited[i]) {
                    if (arr[i] == before) continue;
                    before = arr[i];
                    boolean[] visited = node.visited.clone();
                    visited[i] = true;
                    stack.add(new Node(node.index + 1, node.seq + arr[i] + " ", visited));
                }
            }
            before = 0;
        }
        System.out.println(sb);
    }
    private static class Node {
        int index;
        String seq;
        boolean[] visited;

        public Node(int index, String seq, boolean[] visited) {
            this.index = index;
            this.seq = seq;
            this.visited = visited;
        }
    }
}
