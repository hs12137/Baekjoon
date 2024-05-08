import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q_11724 {

    static Map<Integer, List<Integer>> map;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            List<Integer> list1 = map.getOrDefault(num1, new ArrayList<>());
            List<Integer> list2 = map.getOrDefault(num2, new ArrayList<>());
            list1.add(num2);
            list2.add(num1);
            map.put(num1, list1);
            map.put(num2, list2);
        }
        visited = new boolean[n+1];
        int answer = 0;
        for(int i = 1; i <= n; i++){
            if(!visited[i]) {
                answer++;
                dfs(i);
            }
        }
        System.out.println(answer);
    }
    private static void dfs(int node){
        for(Integer i : map.getOrDefault(node, new ArrayList<>())){
            if(!visited[i]){
                visited[i] = true;
                dfs(i);
            }
        }
    }
}