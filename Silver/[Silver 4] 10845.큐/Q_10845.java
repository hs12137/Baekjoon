import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q_10845 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue queue = new Queue();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            if (input.equals("pop")) sb.append("\n").append(queue.pop());
            else if (input.equals("size")) sb.append("\n").append(queue.size());
            else if (input.equals("empty")) sb.append("\n").append(queue.empty());
            else if (input.equals("front")) sb.append("\n").append(queue.front());
            else if (input.equals("back")) sb.append("\n").append(queue.back());
            else queue.push(Integer.parseInt(input.split(" ")[1]));
        }
        if (sb.length() > 0) System.out.println(sb.substring(1));
    }
}
class Queue{
    ArrayList<Integer> list = new ArrayList<>();
    int size = 0;
    public void push(int value){
        list.add(0, value);
        size++;
    }
    public int pop(){
        if(size == 0) return -1;
        int value = list.remove(size - 1);
        size--;
        return value;
    }
    public int size(){
        return size;
    }
    public int empty(){
        return size == 0 ? 1 : 0;
    }
    public int front(){
        if(size == 0) return -1;
        return list.get(size - 1);
    }
    public int back(){
        if(size == 0) return -1;
        return list.get(0);
    }
}