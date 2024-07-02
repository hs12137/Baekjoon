import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_7576 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        boolean[][] box = new boolean[n+2][m+2];
        int tomato = 0;
        Queue<Node> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                int input = Integer.parseInt(st.nextToken());
                if (input == 1) queue.add(new Node(j, i, 0));
                else if (input == 0) {
                    tomato++;
                    box[i][j] = true;
                }
            }
        }
        if (tomato == 0) {
            System.out.println(0);
            return;
        }
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        Node node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = node.x + dx[i], y = node.y + dy[i];
                if (box[y][x]) {
                    tomato--;
                    box[y][x] = false;
                    queue.add(new Node(x, y, node.day+1));
                }
            }
        }
        if (tomato > 0) System.out.println(-1);
        else System.out.println(node.day);
    }
    private static class Node{
        int x, y, day;
        Node(int x, int y, int day){
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
}
