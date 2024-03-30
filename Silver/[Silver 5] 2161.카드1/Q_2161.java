package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q_2161{

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());

		String answer = cardThrow(N);
		System.out.println(answer);
		
	}
	public static String cardThrow(int n) {
		String result = "";
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= n; i++) {
			queue.add(i);
		}
		result += queue.poll();
		while(!queue.isEmpty()) {
			queue.add(queue.poll());
			if(queue.isEmpty()) break;
			result += " " + queue.poll();
		}
		
		return result;
	}

}