import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q_1167 {

    static Map<Integer, List<Line>> map;
    static boolean[] visited;
    static int[] max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new HashMap<>();
        int v = Integer.parseInt(br.readLine());
        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            while(true){
                int x = Integer.parseInt(st.nextToken());
                if(x == -1) break;
                int dist = Integer.parseInt(st.nextToken());
                List<Line> lines1 = map.getOrDefault(node, new ArrayList<>());
                List<Line> lines2 = map.getOrDefault(x, new ArrayList<>());
                lines1.add(new Line(x,dist));
                lines2.add(new Line(node,dist));
                map.put(node, lines1);
                map.put(x, lines2);
            }
        }
        dfs(1, v);
        dfs(max[1], v);
        System.out.println(max[0]);
    }
    private static class Line{
        int node;
        int distance;
        private Line(int node, int distance){
            this.node = node;
            this.distance = distance;
        }
    }
    private static void dfs(int start, int size){
        visited = new boolean[size+1];
        visited[start] = true;
        max = new int[2];
        doDfs(start, 0);
    }
    private static void doDfs(int node, int distance){
        for(Line line : map.getOrDefault(node, new ArrayList<>())){
            if(!visited[line.node]) {
                visited[line.node] = true;
                int newDist = distance + line.distance;
                if(newDist  > max[0]){
                    max[0] = newDist;
                    max[1] = line.node;
                }
                doDfs(line.node, newDist);
            }
        }
    }
}
