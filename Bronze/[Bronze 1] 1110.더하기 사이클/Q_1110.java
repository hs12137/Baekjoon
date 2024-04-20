package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_1110 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		int newN = n;
		do{
			newN = ((newN % 10) * 10) + (((newN / 10) + (newN % 10)) % 10);
			answer++;
		}while(n != newN);
		System.out.println(answer);
	}
}