import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

public class Q_1389 {

    private static Map<Integer, List<Integer>> map;
    private static boolean[] visited;
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int maxVal = Integer.MAX_VALUE;
        int answer = 0;
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            List<Integer> list1 = map.getOrDefault(a, new ArrayList<>());
            List<Integer> list2 = map.getOrDefault(b, new ArrayList<>());
            list1.add(b);
            list2.add(a);
            map.put(a, list1);
            map.put(b, list2);
        }
        for(int i = 1; i <= n; i++) {
            int search = search(i);
            if(maxVal > search) {
                answer = i;
                maxVal = search;
            }
        }
        System.out.println(answer);
    }
    private static int search(int start) {
        Queue<Node> queue = new LinkedList<>();
        int total = 0;
        visited = new boolean[n + 1];
        visited[start] = true;
        queue.add(new Node(start, 0));
        while(!queue.isEmpty()){
            Node node = queue.poll();
            total += node.depth;
            for(int index: map.get(node.value)) {
                if (!visited[index]) {
                    visited[index] = true;
                    queue.add(new Node(index, node.depth + 1));
                }
            }
        }
        return total;
    }
    private static class Node{
        int value;
        int depth;
        Node(int value, int depth) {
            this.value = value;
            this.depth = depth;
        }
    }
}
