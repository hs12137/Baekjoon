import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_2748 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long num1 = 1;
        long num2 = 0;
        long temp;
        for(int i = 2; i <= n; i++) {
            temp = num1;
            num1 += num2;
            num2 = temp;
        }
        System.out.println(num1);
    }
}