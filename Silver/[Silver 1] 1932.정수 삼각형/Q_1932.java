import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_1932 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[3];
        arr[1] = Integer.parseInt(br.readLine());
        int[] tmp;
        for (int i = 2; i <= n; i++) {
            tmp = new int[i + 2];
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                int number = Integer.parseInt(st.nextToken());
                tmp[j] = Math.max(arr[j - 1] + number, arr[j] + number);
            }
            arr = tmp;
        }
        int max = 0;
        for (int num : arr) {
            max = Math.max(max, num);
        }
        System.out.println(max);
    }
}
