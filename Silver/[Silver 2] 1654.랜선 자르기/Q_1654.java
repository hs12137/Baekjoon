import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_1654 {

    static int[] sticks;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        sticks = new int[k];
        long min = 1;
        long max = 0;
        for(int i = 0; i < k; i++){
            int stick = Integer.parseInt(br.readLine());
            sticks[i] = stick;
            if(stick > max) max = stick;
        }
        if (search(max) >= n) {
            System.out.println(max);
            return;
        }
        while (min < max - 1) {
            long mid = (min + max) / 2;
            if (search(mid) >= n) {
                min = mid;
            } else {
                max = mid;
            }
        }
        System.out.println(min);
    }
    private static int search(long num){
        int count = 0;
        for(int stick : sticks) count += (int) (stick / num);
        return count;
    }
}