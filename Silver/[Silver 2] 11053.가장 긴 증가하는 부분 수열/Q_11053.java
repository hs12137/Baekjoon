import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_11053 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] max = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        max[0] = 1;
        int answer = 1;
        for (int i = 1; i < n; i++) {
            int maxNum = 1;
            for(int j = i-1; j >= 0; j--) {
                if(arr[j] < arr[i]) maxNum = Math.max(maxNum, max[j] + 1);
            }
            max[i] = maxNum;
            answer = Math.max(answer, maxNum);
        }
        System.out.println(answer);
    }
}