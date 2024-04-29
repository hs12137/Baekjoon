import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q_9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            stack.clear();
            String answer = "YES";
            for(char c : input.toCharArray()) {
                if(c == '(') stack.push(c);
                else{
                    if(stack.isEmpty()){
                        answer = "NO";
                        break;
                    }
                    stack.pop();
                }
            }
            if(!stack.isEmpty()) answer = "NO";
            sb.append("\n").append(answer);
        }
        System.out.println(sb.substring(1));
    }
}
