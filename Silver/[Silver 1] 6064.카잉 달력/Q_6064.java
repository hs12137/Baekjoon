import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_6064 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken()) % N;
            int max = getLCM(M, N);
            while(x <= max) {
                if(x % N == y) {
                    break;
                }else x += M;
            }
            if(x <= max) System.out.println(x);
            else System.out.println(-1);
        }
    }
    private static int getLCM(int a, int b) {
        int num1 = a;
        int num2 = b;
        int tmp = 1;
        while(tmp != 0) {
            tmp = num1 % num2;
            num1 = num2;
            num2 = tmp;
        }
        return a * b / num1;
    }
}
