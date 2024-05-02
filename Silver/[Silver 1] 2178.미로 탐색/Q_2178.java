import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_2178 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] miro = new boolean[n+2][m+2];
        boolean[][] visited = new boolean[n+1][m+1];
        for(int i = 1; i <= n; i++){
            char[] line = br.readLine().toCharArray();
            for(int j = 1; j <= m; j++){
                miro[i][j] = line[j-1] == '1';
            }
        }
        Queue<Node> queue = new LinkedList<>();
        int answer = -1;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        queue.add(new Node(1, 1, 1));
        visited[1][1] = true;
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if(cur.x == n && cur.y == m){
                answer = cur.count;
                break;
            }
            for(int i = 0; i < 4; i++){
                int x = cur.x + dx[i];
                int y = cur.y + dy[i];
                if(miro[x][y] && !visited[x][y]) {
                    queue.add(new Node(x, y, cur.count + 1));
                    visited[x][y] = true;
                }
            }
        }
        System.out.println(answer);
    }
    private static class Node{
        int x, y, count;
        private Node(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
