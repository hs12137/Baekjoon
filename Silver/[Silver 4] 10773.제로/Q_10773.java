import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q_10773 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0) stack.pop();
            else stack.push(num);
        }
        while(!stack.isEmpty()){
            answer += stack.pop();
        }
        System.out.println(answer);
    }
}