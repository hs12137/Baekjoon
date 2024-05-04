import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q_11723 {

    static List<Integer> list;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        list = new ArrayList<>();
        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++){
            String[] input = br.readLine().split(" ");
            if(input[0].equals("add")) add(Integer.parseInt(input[1]));
            else if (input[0].equals("remove")) remove(Integer.parseInt(input[1]));
            else if (input[0].equals("check")) check(Integer.parseInt(input[1]));
            else if (input[0].equals("toggle")) toggle(Integer.parseInt(input[1]));
            else if (input[0].equals("all")) all();
            else if (input[0].equals("empty")) empty();
        }
        if(sb.length() > 0) System.out.println(sb.substring(1));
    }
    private static void add(int x){
        if (!list.contains(x)) list.add(x);
    }
    private static void remove(int x){
        if (list.contains(x)) list.remove((Integer) x);
    }
    private static void check(int x){
        if (list.contains(x)) sb.append("\n").append(1);
        else sb.append("\n").append(0);
    }
    private static void toggle(int x){
        if (list.contains(x)) list.remove((Integer) x);
        else list.add(x);
    }
    private static void all(){
        for(int i = 1; i <= 20; i++) add(i);
    }
    private static void empty(){
        list.clear();
    }
}
