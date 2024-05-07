import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_31807 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        int[] arr = new int[l];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < l; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }
        int len = 0;
        for(int i = l / 2; i > 0; i--){
            boolean bb = true;
            for(int n = 0; n < i; n++){
                if(arr[n] == arr[n + i]) continue;
                bb = false;
                break;
            }
            if(bb){
                len = i;
                break;
            }
        }
        int[] cycleArr = new int[len];
        long cycle = 0;
        for (int i = 0; i < len; i++){
            cycleArr[i] = arr[i];
            cycle += arr[i];
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int start = a < 0 ? a % len + len : a % len;
        int diffCycle = (b - a) / len;
        int diffNum = (b - a) % len;
        long answer = cycle * diffCycle;
        for(int i = 0; i < diffNum; i++){
            if(start == len) start = 0;
            answer += cycleArr[start++];
        }
        System.out.println(answer);
    }
}