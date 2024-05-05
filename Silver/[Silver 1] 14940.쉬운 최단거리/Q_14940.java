import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_14940 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n+2][m+2];
        boolean[][] visited = new boolean[n+2][m+2];
        Node target = null;
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int l = 1; l <= m; l++){
                int num = Integer.parseInt(st.nextToken());
                if (num == 2) target = new Node(i, l, 0);
                else if (num == 1) arr[i][l] = -1;
            }
        }
        Queue<Node> queue = new LinkedList<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        queue.add(target);
        visited[target.x][target.y] = true;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for(int i = 0; i < 4; i++){
                int x = node.x + dx[i];
                int y = node.y + dy[i];
                int value = node.value + 1;
                if(arr[x][y] == -1 && !visited[x][y]) {
                    queue.add(new Node(x, y, value));
                    visited[x][y] = true;
                    arr[x][y] = value;
                }
            }
        }
        for(int i = 1; i <= n; i++){
            StringBuilder line = new StringBuilder();
            for(int l = 1; l <= m; l++){
                line.append(" ").append(arr[i][l]);
            }
            sb.append("\n").append(line.substring(1));
        }
        System.out.println(sb.substring(1));
    }
    private static class Node{
        int x;
        int y;
        int value;
        private Node(int x, int y, int value){
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
}
