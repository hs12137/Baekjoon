package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_10828 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack stack = new Stack();
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			String[] order = input.split(" ");
			if(order[0].equals("push")) stack.push(Integer.parseInt(order[1]));
			else if(order[0].equals("pop")) System.out.println(stack.pop());
			else if(order[0].equals("size")) System.out.println(stack.size());
			else if(order[0].equals("empty")) System.out.println(stack.empty());
			else if(order[0].equals("top")) System.out.println(stack.top());
		}
		
	}
}
class Stack{
	private Node top;
	private int size = 0;
	
	private class Node{
		int value;
		Node below;
		private Node(int value) {
			this.value = value;
		}
	}
	public void push(int x) {
		if(size == 0) {
			top = new Node(x);
		}else {
			Node node = new Node(x);
			node.below = top;
			top = node;
		}
		size ++;
	}
	public int pop() {
		if(size == 0) return -1;
		int get = top.value;
		top = top.below;
		size --;
		return get;
	}
	public int size() {
		return size;
	}
	public int empty() {
		if(size == 0) return 1;
		else return 0;
	}
	public int top() {
		if(size == 0) return -1;
		else return top.value;
	}
}