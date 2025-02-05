import java.io.*;

public class Main {
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        arr = new char[N][N];

        // 배열을 공백(' ')으로 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = ' ';
            }
        }

        // 재귀 함수 호출
        drawStars(0, 0, N);

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.print(sb);
    }

    static void drawStars(int x, int y, int size) {
        // 기저 조건: size가 1이면 '*' 채우기
        if (size == 1) {
            arr[x][y] = '*';
            return;
        }

        int newSize = size / 3; // 다음 크기의 블록 크기
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) continue; // 중앙 부분은 공백
                drawStars(x + i * newSize, y + j * newSize, newSize);
            }
        }
    }
}
