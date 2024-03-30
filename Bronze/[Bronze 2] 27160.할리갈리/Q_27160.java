package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Q_27160 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String answer = "NO";
		
		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap<>();
		for(int i = 0; i < N; i++) {
			String card = br.readLine();
			String fruit = card.split(" ")[0];
			int count = Integer.parseInt(card.split(" ")[1]);
			
			if(map.containsKey(fruit)) map.put(fruit, map.get(fruit) + count);
			else map.put(fruit, count);
		}
		if(map.values().contains(5)) answer = "YES";
		
		System.out.println(answer);
	}

}
