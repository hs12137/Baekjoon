package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_1094 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		int answer = 0;
		while(X > 0) {
			answer += X % 2;
			X /= 2;
		}
		System.out.println(answer);
	}
}