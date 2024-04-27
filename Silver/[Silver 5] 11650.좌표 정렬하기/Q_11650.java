package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Q_11650 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		Coordinate[] arr = new Coordinate[n];
		for(int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			arr[i] = new Coordinate(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
		}
		Arrays.sort(arr, new Comparator<Coordinate>() {
			@Override
			public int compare(Coordinate c1, Coordinate c2) {
				if(c1.x == c2.x) return c1.y - c2.y;
				else return c1.x - c2.x;
			}
		});
		for(Coordinate c : arr) {
			sb.append("\n").append(c.x).append(" ").append(c.y);
		}
		System.out.println(sb.substring(1));
	}
}
class Coordinate{
	int x;
	int y;
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
}