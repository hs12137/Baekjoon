import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_1074 {

    static int index = 0;
    static int r;
    static int c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int len = 1 << N;
        search(0, 0, len);
    }
    private static void search(int startY, int startX, int len){
        if(check(startY, startX, len)) {
            if(len == 2){
                for(int i = 0; i < 2; i++) {
                    for (int l = 0; l < 2; l++) {
                        if(startY+i == r && startX+l == c){
                            System.out.println(index);
                            System.exit(0);
                        }
                        index++;
                    }
                }
            }else {
                len /= 2;
                search(startY, startX, len);
                search(startY, startX + len, len);
                search(startY + len, startX, len);
                search(startY + len, startX + len, len);
            }
        }else {
            index += len * len;
        }
    }
    private static boolean check(int startY, int startX, int len){
        if(r >= startY && r < startY+len && c >= startX && c < startX+len) return true;
        return false;
    }
}