import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_31800 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int max = 0;
        int max2nd = 0;
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num > max){
                max2nd = max;
                max = num;
            }else if(num > max2nd) max2nd = num;
            arr[i] = num;
        }
        br.readLine();
        for(int num : arr){
            if(num < max) sb.append(" ").append(num - max);
            else sb.append(" ").append(num - max2nd);
        }
        System.out.println(sb.substring(1));
    }
}