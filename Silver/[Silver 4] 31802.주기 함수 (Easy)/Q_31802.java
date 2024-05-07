import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_31802 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        long cycle = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            cycle += num;
        }
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int start = a < 0 ? a % n + n : a % n;
        int diffCycle = (b - a) / n;
        int diffNum = (b - a) % n;
        long answer = cycle * diffCycle;
        for(int i = 0; i < diffNum; i++){
            if(start == n) start = 0;
            answer += arr[start++];
        }
        System.out.println(answer);
    }
}