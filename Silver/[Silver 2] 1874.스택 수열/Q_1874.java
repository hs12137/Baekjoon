import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q_1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int index = 1;
        for(int i = 1; i <= n; i++){
            int num = Integer.parseInt(br.readLine());

            if(stack.isEmpty()){
                stack.push(index++);
                sb.append("\n+");
            }
            int peek = stack.peek();;
            if(peek == num){
                stack.pop();
                sb.append("\n-");
            } else if (peek < num) {
                while(index <= num){
                    stack.push(index++);
                    sb.append("\n+");
                }
                stack.pop();
                sb.append("\n-");
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb.substring(1));
    }
}