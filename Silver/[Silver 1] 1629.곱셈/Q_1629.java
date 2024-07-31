import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_1629 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());
        A %= C;

        System.out.println(solve(A, B, C));
    }

    private static long solve(long A, long B, long C) {
        if (B == 1) return A;
        long s = solve(A, B / 2, C);
        if (B % 2 == 0) return (s * s) % C;
        else return (((s * s) % C) * A) % C;
    }
}
