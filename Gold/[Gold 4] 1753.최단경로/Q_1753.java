import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q_1753 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[v+1];

        for(int i = 1; i < v+1; i++) graph[i] = new ArrayList<>();
        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[from].add(new Edge(to, weight));
        }
        int[] dist = new int[v+1];
        Arrays.fill(dist, 1000000000);
        dist[start] = 0;
        boolean[] visited = new boolean[v+1];

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

        while(!pq.isEmpty()) {
            Edge nowEdge = pq.poll();
            if(visited[nowEdge.to]) continue;
            visited[nowEdge.to] = true;

            for(Edge edge : graph[nowEdge.to]) {
                if(visited[edge.to]) continue;
                if(dist[edge.to] > dist[nowEdge.to] + edge.weight) {
                    dist[edge.to] = dist[nowEdge.to] + edge.weight;
                    pq.add(new Edge(edge.to, dist[edge.to]));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= v; i++) {
            if(dist[i] != 1000000000) sb.append(dist[i]).append("\n");
            else sb.append("INF\n");
        }
        System.out.println(sb);
    }
    private static class Edge implements Comparable<Edge> {
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }
}
