import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_15652 {

    static int n, m;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();

        solve(0, 1 ,"");
        System.out.println(sb);
    }
    private static void solve(int index, int num, String seq) {
        if (index == m) {
            sb.append(seq).append('\n');
            return;
        }
        for (int i = num; i <= n; i++) {
            solve(index + 1, i, seq + i + " ");
        }
    }
}
