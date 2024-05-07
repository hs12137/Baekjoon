import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_31799 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        int count = 0;
        for(char c : br.readLine().toCharArray()) {
            if(c == '+' || c == '-') arr[count - 1] += c;
            else if(c == 'A' || c == 'B' || c == 'C') arr[count++] = String.valueOf(c);
        }
        int[] score = new int[n];
        count = 0;
        for(String s : arr){
            if(s.equals("C-") || s.equals("C") || s.equals("C+")) score[count++] = 1;
            else if(s.equals("B-") || s.equals("B")) score[count++] = 2;
            else if(s.equals("B+") || s.equals("A-")) score[count++] = 3;
            else if(s.equals("A")) score[count++] = 4;
            else if(s.equals("A+")) score[count++] = 5;
        }
        if(score[0] == 1) sb.append("B");
        else if(score[0] == 2) sb.append("D");
        else if(score[0] == 3) sb.append("P");
        else sb.append("E");
        for(int i = 1; i < n; i++){
            if(score[i] == 1) sb.append("B");
            else if (score[i] == 2) {
                if(score[i] > score[i-1]) sb.append("D");
                else sb.append("B");
            }
            else if (score[i] == 3) {
                if(score[i] > score[i-1]) sb.append("P");
                else sb.append("D");
            }
            else if (score[i] == 4) {
                if(score[i] > score[i-1]) sb.append("E");
                else sb.append("P");
            }
            else sb.append("E");
        }
        System.out.println(sb.toString());
    }
}