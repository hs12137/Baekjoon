package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_2231 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		for(int i = n - 54; i < n; i++) {
			int decom = decom(i);
			if(decom == n) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);
	}
	public static int decom(int num) {
		int decom = num;
		while(num > 0) {
			decom += num % 10;
			num = num / 10;
		}
		return decom;
	}
}