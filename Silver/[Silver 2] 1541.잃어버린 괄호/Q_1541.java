import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("-");
        int answer = 0;
        for(String s : input[0].split("\\+")){
            answer += Integer.parseInt(s);
        }
        for(int i = 1; i < input.length; i++){
            for(String s : input[i].split("\\+")){
                answer -= Integer.parseInt(s);
            }
        }
        System.out.println(answer);
    }
}