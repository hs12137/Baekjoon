import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_2839 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = -1;
        if(n % 5 == 0) answer = n / 5;
        else if((n - 3) % 5 == 0) answer = ((n - 3) / 5) + 1;
        else if(n > 5 && (n - 6) % 5 == 0) answer = ((n - 6) / 5) + 2;
        else if(n > 8 && (n - 9) % 5 == 0) answer = ((n - 9) / 5) + 3;
        else if(n > 11 && (n - 12) % 5 == 0) answer = ((n - 12) / 5) + 4;
        System.out.println(answer);
    }
}