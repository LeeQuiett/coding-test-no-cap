import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 동전 종류 개수
        int k = Integer.parseInt(st.nextToken()); // 목표 금액

        int[] coins = new int[n]; // 동전 종류 저장 배열
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[k + 1]; // dp[i] : i원을 만드는 경우의 수
        dp[0] = 1; // 0원을 만드는 방법 1개 (아무 동전도 사용하지 않는 경우)

        // 동전 하나씩 사용하면서 dp 업데이트
        for (int coin : coins) {
            for (int j = coin; j <= k; j++) {
                dp[j] += dp[j - coin]; // 현재 동전 사용했을 때 경우의 수 추가
            }
        }

        System.out.println(dp[k]); // k원을 만드는 방법의 개수 출력
    }
}
