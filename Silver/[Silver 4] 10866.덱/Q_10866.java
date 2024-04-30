import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q_10866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Deque deque = new Deque();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            if ("push_front".equals(input[0])) deque.push_front(Integer.parseInt(input[1]));
            else if ("push_back".equals(input[0])) deque.push_back(Integer.parseInt(input[1]));
            else if ("pop_front".equals(input[0])) sb.append("\n").append(deque.pop_front());
            else if ("pop_back".equals(input[0])) sb.append("\n").append(deque.pop_back());
            else if ("size".equals(input[0])) sb.append("\n").append(deque.size());
            else if ("empty".equals(input[0])) sb.append("\n").append(deque.empty());
            else if ("front".equals(input[0])) sb.append("\n").append(deque.front());
            else if ("back".equals(input[0])) sb.append("\n").append(deque.back());
        }
        if(sb.length() > 0) System.out.println(sb.substring(1));
    }
}
class Deque{
    ArrayList<Integer> list =  new ArrayList<>();
    int size = 0;
    public void push_front(int val){
        list.add(0, val);
        size++;
    }
    public void push_back(int val){
        list.add(size, val);
        size++;
    }
    public int pop_front(){
        if(size == 0) return -1;
        size--;
        return list.remove(0);
    }
    public int pop_back(){
        if(size == 0) return -1;
        size--;
        return list.remove(size);
    }
    public int size(){
        return size;
    }
    public int empty(){
        if(size == 0) return 1;
        return 0;
    }
    public int front(){
        if(size == 0) return -1;
        return list.get(0);
    }
    public int back(){
        if(size == 0) return -1;
        return list.get(size - 1);
    }
}