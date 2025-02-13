import java.util.*;

public class Main {

    static class Node {
        int x, y, wallBroken, dist;

        Node(int x, int y, int wallBroken, int dist) {
            this.x = x;
            this.y = y;
            this.wallBroken = wallBroken;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(n, m, grid));
    }

    public static int bfs(int n, int m, int[][] grid) {
        int[][][] visited = new int[n][m][2]; // 3차원 방문 배열

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 0, 1));
        visited[0][0][0] = 1;

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int x = current.x;
            int y = current.y;
            int wallBroken = current.wallBroken;
            int dist = current.dist;

            // (N, M)에 도달한 경우
            if (x == n - 1 && y == m - 1) {
                return dist;
            }

            for (int[] direction : directions) {
                int nx = x + direction[0];
                int ny = y + direction[1];

                // 유효한 범위인지 확인
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    // 벽이 아니고 방문하지 않은 경우
                    if (grid[nx][ny] == 0 && visited[nx][ny][wallBroken] == 0) {
                        visited[nx][ny][wallBroken] = 1;
                        queue.add(new Node(nx, ny, wallBroken, dist + 1));
                    }
                    // 벽이지만 아직 부술 수 있는 경우
                    else if (grid[nx][ny] == 1 && wallBroken == 0) {
                        visited[nx][ny][1] = 1;
                        queue.add(new Node(nx, ny, 1, dist + 1));
                    }
                }
            }
        }
        return -1; // 목표 지점에 도달할 수 없는 경우
    }
}
