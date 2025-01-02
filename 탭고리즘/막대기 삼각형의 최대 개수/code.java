import java.util.*;

public class MaxTriangles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] sticks = new int[N];
        for (int i = 0; i < N; i++) {
            sticks[i] = scanner.nextInt();
        }

        System.out.println(maxTriangles(sticks));
    }

    public static int maxTriangles(int[] sticks) {
        Arrays.sort(sticks); // 막대기의 길이를 오름차순 정렬
        int count = 0;

        // 삼각형을 만들 수 있는 조합 찾기
        for (int i = sticks.length - 1; i >= 2; i--) {
            int c = sticks[i];
            int a = 0, b = i - 1;

            while (a < b) {
                if (sticks[a] + sticks[b] > c) {
                    count += (b - a); // 가능한 조합 추가
                    b--;
                } else {
                    a++;
                }
            }
        }

        return count;
    }
}
