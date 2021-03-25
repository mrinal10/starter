import java.io.*;
import java.util.*;

class Test354 {
	private static long globalCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int N = Integer.parseInt(br.readLine().trim());
		String[] arr_color = br.readLine().split(" ");
		int[] color = new int[N];
		for (int i_color = 0; i_color < arr_color.length; i_color++) {
			color[i_color] = Integer.parseInt(arr_color[i_color]);
		}
		int[][] edges = new int[N - 1][2];
		for (int i_edges = 0; i_edges < N - 1; i_edges++) {
			String[] arr_edges = br.readLine().split(" ");
			for (int j_edges = 0; j_edges < arr_edges.length; j_edges++) {
				edges[i_edges][j_edges] = Integer.parseInt(arr_edges[j_edges]);
			}
		}

		long out_ = CountPair(N, color, edges);
		System.out.println(out_);

		wr.close();
		br.close();
	}

	static long CountPair(int N, int[] color, int[][] edges) {
		globalCnt = 0;
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < edges.length; i++) {
			int key = edges[i][0];
			int value = edges[i][1];
			List<Integer> li = new ArrayList<Integer>();
			if (map.containsKey(key)) {
				li = map.get(key);
			}
			li.add(value);
			map.put(key, li);
		}
		for (int i = 0; i < N; i++) {
			Set<Integer> visited = new HashSet<Integer>();
			if (color[i] == 0)
				helper(i + 1, i + 1, color, map, visited, 0);
		}
		return globalCnt;
	}

	static void helper(int startPt, int curIndx, int[] color, Map<Integer, 
			List<Integer>> graph, Set<Integer> visited, int whiteCnt) {
		if (visited.contains(curIndx)) {
			return;
		}
		if (startPt != curIndx && color[curIndx - 1] == 0 && whiteCnt >= 1) {
			globalCnt++;
		}
		visited.add(curIndx);
		List<Integer> li = graph.get(curIndx);
		if (li != null) {
			for (Integer i : li) {
				if (color[curIndx - 1] == 1) {
					helper(startPt, i, color, graph, visited, whiteCnt + 1);
				} else {
					helper(startPt, i, color, graph, visited, whiteCnt);
				}
			}
		}
	}
}