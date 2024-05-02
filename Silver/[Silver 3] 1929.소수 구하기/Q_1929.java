import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_1929 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        System.out.println(solve(m, n));
    }
    private static String solve(int start, int end){
        StringBuilder sb = new StringBuilder();
        if(start == 1) start = 2;
        for(int l = start; l <= end; l++){
            boolean isDecimal = true;
            for(int i = 2; i * i <= l; i++){
                if(l % i == 0) {
                    isDecimal = false;
                    break;
                }
            }
            if(isDecimal) sb.append("\n").append(l);
        }
        return sb.length() > 0 ? sb.substring(1) : "";
    }
}
