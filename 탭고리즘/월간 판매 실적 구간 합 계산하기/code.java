import java.util.Scanner;

public class SalesPrefixSum {

    // 누적합을 계산하는 메서드
    public static int[] calculatePrefixSums(int[] sales) {
        // 누적합을 저장할 배열을 0으로 초기화
        int[] prefixSums = new int[sales.length + 1];
        
        // 판매 데이터 배열을 기반으로 누적합 계산
        for (int i = 1; i <= sales.length; i++) {
            prefixSums[i] = prefixSums[i - 1] + sales[i - 1];
        }
        
        return prefixSums;
    }

    // 구간 합을 계산하는 메서드
    public static int querySum(int[] prefixSums, int l, int r) {
        // 구간 [l, r]의 합을 계산
        return prefixSums[r] - prefixSums[l - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 판매 데이터 개수 입력
        int n = sc.nextInt();
        int[] sales = new int[n];
        
        // 판매 데이터 입력
        for (int i = 0; i < n; i++) {
            sales[i] = sc.nextInt();
        }

        // 누적합 배열 계산
        int[] prefixSums = calculatePrefixSums(sales);

        // 쿼리 개수 입력
        int Q = sc.nextInt();
        
        // 쿼리 처리
        for (int i = 0; i < Q; i++) {
            int L = sc.nextInt();
            int R = sc.nextInt();
            
            // 구간 합 출력
            System.out.println(querySum(prefixSums, L, R));
        }

        sc.close();
    }
}
