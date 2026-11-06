public class Assignment01Q05 {
    // Add a value and return the next free queue position.
    private static int enqueue(int[] queue, int tail, int value) {
        queue[tail] = value;
        return tail + 1;
    }

    // Read the value at the front of the queue.
    private static int dequeue(int[] queue, int head) {
        return queue[head];
    }

    // The queue is empty when there are no unread values.
    private static boolean isEmpty(int head, int tail) {
        return head == tail;
    }

    public static int findShortestPath(int[][] m, int i, int j) {
        // A node's distance to itself is zero.
        if (i == j) {
            return 0;
        }

        // BFS queue, visited flags, and distances from the start node.
        int[] queue = new int[m.length];
        boolean[] visited = new boolean[m.length];
        int[] dist = new int[m.length];

        int head = 0;
        int tail = 0;
        

        // Start the search from node i.
        visited[i] = true;
        dist[i] = 0;
        tail = enqueue(queue, tail, i);

        // Visit nodes in order of increasing distance.
        while (!isEmpty(head, tail)) {
            int curr = dequeue(queue, head);
            head++;
            
            // Find unvisited neighbors and record their distances.
            for (int neighbor = 0; neighbor < m.length; neighbor++) {
                if (m[curr][neighbor] == 1 && !visited[neighbor]) {
                    visited[neighbor] = true;
                    dist[neighbor] = dist[curr] + 1;

                    if (neighbor == j) {
                        return dist[neighbor];
                    }

                    tail = enqueue(queue, tail, neighbor);

                }
            }
        }
        
        // No path connects the start and destination.
        return -1;

        


        
    }

    public static void main(String[] args) {
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 0, 1)); // -1
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 1, 1)); // 0
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,0}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}}, 0, 2)); // 2
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,1}, {0,0,0,1}, {0,0,0,0}, {0,0,1,0}}, 0, 2)); // 2
    }
}