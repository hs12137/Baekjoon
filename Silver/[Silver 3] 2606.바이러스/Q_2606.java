import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q_2606 {

    static Map<Integer, List<Integer>> map;
    static boolean[] visited;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
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
        dfs(n);
        System.out.println(answer);
    }
    private static  void dfs(int size){
        visited = new boolean[size+1];
        visited[1] = true;
        answer = 0;
        doDfs(1);
    }
    private static void doDfs(int node){
        for(Integer i : map.getOrDefault(node, new ArrayList<>())){
            if(!visited[i]){
                answer++;
                visited[i] = true;
                doDfs(i);
            }
        }
    }
}
