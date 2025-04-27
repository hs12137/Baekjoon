import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q_15654 {

    static int n, m, before;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        before = 0;
        sb = new StringBuilder();

        solve(0 ,"");
        System.out.println(sb);
    }
    private static void solve(int index, String seq) {
        if (index == m) {
            sb.append(seq).append('\n');
            return;
        }
        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                if (i > 0 && arr[i] == arr[i-1]) continue;
                visited[i] = true;
                solve(index + 1, seq + arr[i] + " ");
                visited[i] = false;
            }
        }
    }
}
