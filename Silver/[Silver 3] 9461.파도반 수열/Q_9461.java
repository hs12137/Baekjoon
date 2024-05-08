import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_9461 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int[] testCase = new int[t];
        int max = 0;
        for (int i = 0; i < t; i++) {
            testCase[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, testCase[i]);
        }
        long[] dp = new long[max + 1];
        for (int i = 1; i <= max; i++) {
            if(i < 4) dp[i] = 1;
            else if(i == 4) dp[i] = 2;
            else dp[i] = dp[i - 1] + dp[i - 5];
        }
        for(int test : testCase) sb.append(dp[test]).append("\n");
        System.out.println(sb);
    }
}