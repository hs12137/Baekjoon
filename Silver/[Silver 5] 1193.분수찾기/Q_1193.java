package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_1193 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		int sum = 1;
		int i = 1;
		while(X > sum) {
			i++;
			sum = i * (i + 1) / 2;
		}
		String answer;
		if(i % 2 == 0) answer = (X + i - sum) + "/" + (sum - X +1);
		else answer = (sum - X +1) + "/" + (X + i - sum);
		
		System.out.print(answer);
	}
}