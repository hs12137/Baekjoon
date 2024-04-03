package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q_1158 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 1; i <= n; i++) {
			list.add(i);
		}
		int index = -1;
		sb.append("<");
		while(!list.isEmpty()) {
			index += k;
			index %= list.size();
			sb.append(list.remove(index));
			if(list.isEmpty()) sb.append(">");
			else sb.append(", ");
			index--;
		}
		System.out.println(sb.toString());
	}
}