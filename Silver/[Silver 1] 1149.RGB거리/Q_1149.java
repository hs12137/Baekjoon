import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q_1149 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+1][3];
        for(int i = 1; i <= N; i++) arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i = 1; i <= N; i++) {
            for(int j = 0; j < 3; j++) {
                arr[i][j] += Math.min(arr[i-1][(j+1)%3], arr[i-1][(j+2)%3]);
            }
        }

        System.out.println(Math.min(arr[N][0], Math.min(arr[N][1], arr[N][2])));
    }
}
