import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

public class Q_16928 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> map = new HashMap<>();
        boolean[] visited = new boolean[101];
        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.put(a, b);
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 0));
        int now = 1;
        Node node = null;
        while (now < 100) {
            node = queue.poll();
            now = node.location;
            for (int i = 1; i < 7; i++) {
                if(now + i < 101 && !visited[now + i]) {
                    visited[now + i] = true;
                    if(map.containsKey(now + i)) queue.add(new Node(map.get(now + i), node.time + 1));
                    else queue.add(new Node(now + i, node.time + 1));
                }
            }
        }
        System.out.println(node.time);
    }
    static class Node {
        int location, time;
        Node(int location, int time) {
            this.location = location;
            this.time = time;
        }
    }
}
