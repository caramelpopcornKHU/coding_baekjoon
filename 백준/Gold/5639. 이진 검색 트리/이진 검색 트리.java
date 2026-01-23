
import java.io.*;
import java.util.*;

class Node {
	Node lt;
	Node rt;
	int data;

	Node(int data) {
		this.data = data;
	}

	public void add(int a) {
		if (a > this.data) {
			if (rt == null) {
				rt = new Node(a);
			} else {
				rt.add(a);
			}
		}
		if (a < this.data) {
			if (lt == null) {
				lt = new Node(a);
			} else {
				lt.add(a);
			}
		}
	}

}

public class Main {

	Node root;

	public void DFS(Node n) {
		
		if(n==null) {
			return;
		} else {
			DFS(n.lt);
			DFS(n.rt);
			System.out.println(n.data);
		}
		
	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T.root = new Node(Integer.parseInt(br.readLine()));

		String input = "";

		while ((input = br.readLine()) != null && !input.isEmpty()) {
			int n = Integer.parseInt(input);
			T.root.add(n);
		}

		T.DFS(T.root);

	}
}