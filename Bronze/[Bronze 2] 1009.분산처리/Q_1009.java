package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_1009 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String answer = "";

		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			String task = br.readLine();
			int a = Integer.parseInt(task.split(" ")[0]) % 10;
			int b = Integer.parseInt(task.split(" ")[1]);
			int last = 1;
			if(a == 0) last = 10;
			else if(a == 1 || a == 5 || a == 6) last = a;
			else {
				for(int j = 0; j < b; j++) {
					last = last * a % 10;
				}
			}
			answer += "\n" + last;
		}
		answer = answer.substring(1);
		
		System.out.println(answer);
	}

}
