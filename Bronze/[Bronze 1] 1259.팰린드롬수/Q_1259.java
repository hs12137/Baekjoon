package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_1259 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String input = br.readLine();
			if(input.equals("0")) break;
			String[] arr = input.split("");
			boolean result = true;
			for(int i = 0; i < arr.length / 2; i++) {
				if(!arr[i].equals(arr[arr.length - 1 - i])) result = false;
			}
			if(result) System.out.println("yes");
			else System.out.println("no");
		}
	}
}