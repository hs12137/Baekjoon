import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

public class Q_1260 {

    static Map<Integer, List<Integer>> map = new HashMap<>();
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int[] matrix : arr){
            List<Integer> list1 = map.getOrDefault(matrix[0], new ArrayList<>());
            List<Integer> list2 = map.getOrDefault(matrix[1], new ArrayList<>());
            list1.add(matrix[1]);
            list2.add(matrix[0]);
            map.put(matrix[0], list1);
            map.put(matrix[1], list2);
        }
        for(Integer key : map.keySet()){
            List<Integer> list = map.get(key);
            Collections.sort(list);
            map.put(key, list);
        }
        System.out.println(dfs(n, k));
        System.out.println(bfs(n, k));
    }
    private static String dfs(int num, int start){
        visited = new boolean[num+1];
        sb = new StringBuilder();
        doDfs(start);
        return sb.substring(1);
    }
    private static void doDfs(int node){
        if(visited[node]) return;
        visited[node] = true;
        sb.append(" ").append(node);
        List<Integer> list = map.getOrDefault(node, new ArrayList<>());
        for(Integer i : list){
            if(!visited[i]) doDfs(i);
        }
    }
    private static String bfs(int num, int start){
        visited = new boolean[num+1];
        sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            if(visited[cur]) continue;
            visited[cur] = true;
            sb.append(" ").append(cur);
            List<Integer> list = map.getOrDefault(cur, new ArrayList<>());
            queue.addAll(list);
        }
        return sb.substring(1);
    }
}
