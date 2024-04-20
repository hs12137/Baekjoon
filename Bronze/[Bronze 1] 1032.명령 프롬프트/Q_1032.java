package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_1032 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[] answer = br.readLine().toCharArray();
		
		for(int i = 1; i < n; i++) {
			char[] newFile = br.readLine().toCharArray();
			for(int l = 0; l < answer.length; l++) {
				if(answer[l] == '?') continue;
				if(answer[l] != newFile[l]) answer[l] = '?';
			}
		}
		System.out.println(String.valueOf(answer));
	}

}
