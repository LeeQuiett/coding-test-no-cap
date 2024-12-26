import java.util.Scanner;

public class LegoAssembly {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] sizes = new int[N];

        for (int i = 0; i < N; i++) {
            sizes[i] = scanner.nextInt();
        }

        System.out.println(legoAssemblyTime(N, sizes));
    }

    public static int legoAssemblyTime(int n, int[] sizes) {
        int totalTime = 0;
        boolean swapped;

        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (sizes[i] > sizes[i + 1]) { // 레고 크기 비교
                    totalTime += Math.abs(sizes[i] - sizes[i + 1]); // 교환 시간 계산

                    // 레고 크기 교환
                    int temp = sizes[i];
                    sizes[i] = sizes[i + 1];
                    sizes[i + 1] = temp;

                    swapped = true;
                }
            }
            n--; // 정렬 범위 줄이기
        } while (swapped);

        return totalTime;
    }
}
