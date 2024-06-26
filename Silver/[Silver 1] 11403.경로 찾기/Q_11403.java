import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

public class Q_11403 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        boolean[][] visited =  new boolean[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    ArrayList<Integer> list = map.getOrDefault(i, new ArrayList<>());
                    list.add(j);
                    map.put(i, list);
                }
            }
        }
        for (int i : map.keySet()) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            while (!queue.isEmpty()) {
                int node = queue.poll();
                for (int j : map.getOrDefault(node, new ArrayList<>())) {
                    if (!visited[i][j]) {
                        visited[i][j] = true;
                        queue.add(j);
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sb.append(visited[i][j] ? '1' : '0').append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
