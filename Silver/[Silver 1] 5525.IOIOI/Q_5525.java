import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_5525 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        int len = N * 2 + 1;
        int count = 0;
        char now = 'O';
        int answer = 0;
        for(char ch : arr) {
            if(ch != now) {
                now = ch;
                count ++;
                if(count == len) {
                    count -= 2;
                    answer++;
                }
            } else if (ch == 'I') count = 1;
            else if (ch == 'O') count = 0;
        }
        System.out.println(answer);
    }
}
