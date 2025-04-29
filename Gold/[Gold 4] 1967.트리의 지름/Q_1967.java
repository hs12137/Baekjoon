import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q_1967 {

    static Map<Integer, ArrayList<Node>> map;
    static boolean[] visited;
    static int point, maxDistance = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        map = new HashMap<>();

        for(int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            ArrayList<Node> list1 = map.getOrDefault(node1, new ArrayList<>());
            ArrayList<Node> list2 = map.getOrDefault(node2, new ArrayList<>());
            list1.add(new Node(node2, weight));
            list2.add(new Node(node1, weight));

            map.put(node1, list1);
            map.put(node2, list2);
        }
        dfs(1, 0);
        maxDistance = 0;
        visited = new boolean[n+1];
        dfs(point, 0);
        System.out.println(maxDistance);
    }

    private static void dfs(int start, int distance) {
        visited[start] = true;
        if(maxDistance < distance) {
            maxDistance = distance;
            point = start;
        }
        for(Node node : map.getOrDefault(start, new ArrayList<>())) {
            if(!visited[node.num]) {
                dfs(node.num, distance + node.weight);
            }
        }
    }

    private static class Node {
        int num;
        int weight;
        public Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }

}
