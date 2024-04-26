package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q_11866 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] arr = br.readLine().split(" ");
		int n = Integer.parseInt(arr[0]);
		int k = Integer.parseInt(arr[1]);
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= n; i++) {
			queue.add(i);
		}
		int count = 1;
		while(!queue.isEmpty()) {
			Integer value = queue.poll();
			if(count == k) {
				sb.append(", ").append(value);
				count = 1;
			}else {
				queue.add(value);
				count++;
			}
		}
		System.out.println("<" + sb.substring(2) + ">");
	}
}