import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

public class Q_11725 {

    static Map<Integer, List<Integer>> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] pNode = new int[n + 1];
        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            List<Integer> list1 = map.getOrDefault(num1, new ArrayList<>());
            List<Integer> list2 = map.getOrDefault(num2, new ArrayList<>());
            list1.add(num2);
            list2.add(num1);
            map.put(num1, list1);
            map.put(num2, list2);
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        queue.add(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited[node] = true;
            List<Integer> list = map.get(node);
            for(Integer i : list) {
                if (!visited[i]) {
                    pNode[i] = node;
                    queue.add(i);
                }
            }
        }
        for (int i = 2; i <= n; i++) sb.append("\n").append(pNode[i]);
        System.out.println(sb.substring(1));
    }
}
