
import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
	String vex;
	Long cost;

	Edge(String vex, Long cost) {
		this.vex = vex;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge ob) {
		// cost 오름차순
		return Long.compare(this.cost, ob.cost);
	}

}

public class Main {

	static int N;
	static HashMap<String, Long> dist;
	static HashMap<String, ArrayList<Edge>> graph;

	public void distInit() {
		for (int i = 1; i <= N; i++) {
			String northVertex = "N" + i;
			String southVertex = "S" + i;
			dist.put(northVertex, Long.MAX_VALUE);
			dist.put(southVertex, Long.MAX_VALUE);
		}
	}

	public void printDist(String fromVertex, String toVertex) {
		// dist 초기화
		distInit();
		//
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		dist.put(fromVertex, 0L);
		pQ.offer(new Edge(fromVertex, 0L));

		while (!pQ.isEmpty()) {
			Edge e = pQ.poll();
			String now = e.vex;
			Long nowCost = e.cost;

			if (dist.get(now) < nowCost)
				continue;

			for (Edge nv : graph.get(now)) {
				if (dist.get(nv.vex) > nowCost + nv.cost) {
					dist.put(nv.vex, nowCost + nv.cost);
					pQ.offer(new Edge(nv.vex, nowCost + nv.cost));
				}
			}

		}

		System.out.println(dist.get(toVertex));

	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		dist = new HashMap<String, Long>();
		graph = new HashMap<>();

		// ===========도로 건설 시작 =======================

		// 강변북로 도로 생성
		for (int i = 1; i <= N; i++) {
			String vertex = "N" + i;
			graph.put(vertex, new ArrayList<Edge>());

		}

		// 올림픽대로 도로 생성
		for (int i = 1; i <= N; i++) {
			String vertex = "S" + i;
			graph.put(vertex, new ArrayList<Edge>());
		}

		String[] NS = { "N", "S" };

		for (String ns : NS) {
			// 강변북로, 올림픽대로 간 도로 cost
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < N; i++) {
				String fromVertex = ns + i;
				int rightIndex = i + 1;
				String toVertex = ns + rightIndex;
				Long cost = Long.parseLong(st.nextToken());

				// 도로 edge 가중치 입력
				graph.get(fromVertex).add(new Edge(toVertex, cost));
				graph.get(toVertex).add(new Edge(fromVertex, cost));
			}
		}

		// 나들목 다리 가중치 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			String northVertex = "N" + i;
			String southVertex = "S" + i;
			Long cost = Long.parseLong(st.nextToken());

			graph.get(northVertex).add(new Edge(southVertex, cost));
			graph.get(southVertex).add(new Edge(northVertex, cost));
		}

		// ===========도로 건설 끝 =======================

		// 쿼리의 수
		st = new StringTokenizer(br.readLine());
		int Q = Integer.parseInt(st.nextToken());

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int queryCase = Integer.parseInt(st.nextToken());

			if (queryCase == 1) {
				String fromVertex = st.nextToken();
				String toVertex = st.nextToken();

				T.printDist(fromVertex, toVertex);

			}
			// 강변북로 도로 시간 변경
			else if (queryCase == 2) {
				// 강변북로 도로 번호
				int northRoadIndex = Integer.parseInt(st.nextToken());

				// 강변북로 도로 번호 기준: 왼쪽 vertex
				String northLeftVertex = "N" + northRoadIndex;

				// 강변북로 도로 번호 기준: 오른쪽 vertex
				int rightVertexIndex = northRoadIndex + 1;
				String northRightVertex = "N" + rightVertexIndex;

				Long timeChange = Long.parseLong(st.nextToken());

				// graph에서 roadIndex기준 왼쪽 vertex 연결된 edge들 중에 찾기
				for (Edge e : graph.get(northLeftVertex)) {
					// leftVertex와 이어진 rightVertex를 찾고
					if (e.vex.equals(northRightVertex)) {
						e.cost = timeChange;
					}
				}
				// graph에서 roadIndex기준 오른쪽 vertex 연결된 edge들 중에 찾기
				for (Edge e : graph.get(northRightVertex)) {
					// rightVertex와 이어진 leftVertex를 찾고
					if (e.vex.equals(northLeftVertex)) {
						e.cost = timeChange;
					}
				}

			}
			// 올림픽대로 도로 시간 변경
			else if (queryCase == 3) {

				// 올림픽대로 도로 번호
				int southRoadIndex = Integer.parseInt(st.nextToken());

				// 강변북로 도로 번호 기준: 왼쪽 vertex
				String southLeftVertex = "S" + southRoadIndex;

				// 강변북로 도로 번호 기준: 오른쪽 vertex
				int rightVertexIndex = southRoadIndex + 1;
				String southRightVertex = "S" + rightVertexIndex;

				Long timeChange = Long.parseLong(st.nextToken());

				// graph에서 roadIndex기준 왼쪽 vertex 연결된 edge들 중에 찾기
				for (Edge e : graph.get(southLeftVertex)) {
					// leftVertex와 이어진 rightVertex를 찾고
					if (e.vex.equals(southRightVertex)) {
						e.cost = timeChange;
					}
				}
				// graph에서 roadIndex기준 오른쪽 vertex 연결된 edge들 중에 찾기
				for (Edge e : graph.get(southRightVertex)) {
					// rightVertex와 이어진 leftVertex를 찾고
					if (e.vex.equals(southLeftVertex)) {
						e.cost = timeChange;
					}
				}

			}
			// 다리 시간 변경
			else if (queryCase == 4) {
				// 다리 번호
				int bridgeIndex = Integer.parseInt(st.nextToken());
				String northVertex = "N" + bridgeIndex;
				String southVertex = "S" + bridgeIndex;

				Long timeChange = Long.parseLong(st.nextToken());

				// graph에서 북쪽 Vertex 찾고
				for (Edge e : graph.get(northVertex)) {
					// 이어진 southVertex 찾아서 다리 소요시간 변경
					if (e.vex.equals(southVertex)) {
						e.cost = timeChange;
					}
				}

				// graph에서 남쪽 Vertex 찾고
				for (Edge e : graph.get(southVertex)) {
					// 이어진 northVertex 찾아서 다리 소요시간 변경
					if (e.vex.equals(northVertex)) {
						e.cost = timeChange;
					}
				}

			}

		}

	}
}
