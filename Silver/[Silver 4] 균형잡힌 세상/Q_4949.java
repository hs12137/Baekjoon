import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q_4949 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while(true){
            String input = br.readLine();
            if(input.equals(".")) break;
            String answer = "yes";
            stack.clear();
            for(char c : input.toCharArray()){
                if(c == '(' || c == '[') stack.push(c);
                else if(c == ')'){
                    if(stack.isEmpty() || stack.pop() != '(') {
                        answer = "no";
                        break;
                    }
                }else if(c == ']'){
                    if(stack.isEmpty() || stack.pop() != '[') {
                        answer = "no";
                        break;
                    }
                }
            }
            if(!stack.isEmpty()) answer = "no";
            sb.append("\n").append(answer);
        }
        System.out.print(sb.substring(1));
    }
}