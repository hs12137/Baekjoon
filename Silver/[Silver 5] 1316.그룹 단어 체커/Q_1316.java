package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q_1316 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			if(isGroup(str)) answer++;
		}
		System.out.println(answer);
	}
	private static boolean isGroup(String str) {
		char before = 'A';
		List<Character> group = new ArrayList<>();
		for(char c : str.toCharArray()) {
			if(c == before) continue;
			else if(group.contains(c)) return false;
			else group.add(c);
			before = c;
		}
		return true;
	}
}
