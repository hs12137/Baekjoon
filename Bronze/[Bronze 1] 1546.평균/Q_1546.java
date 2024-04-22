package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q_1546 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		int[] scores = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		double answer = 0;
		int max = 0;
		for(int score : scores) {
			answer += score;
			if(max < score) max = score;
		}
		answer = answer / max / m * 100;
		System.out.println(answer);
	}
}