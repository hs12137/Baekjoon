package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Q_2605 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		String picks = reader.readLine();
		solution(N, picks);
	}
	public static void solution(int N, String picks) {
		LinkedList<Integer> line = new LinkedList<>();
		String[] pickArr = picks.split(" ");
		int len = pickArr.length;
		for(int i = 0; i < len; i++) {
			int move = Integer.parseInt(pickArr[i]);
			line.add(i-move, i+1);
		}
		System.out.print(line.pop());
		for(int i = 0; i < len-1; i++) {
			System.out.print(" "+line.pop());
		}
	}
}