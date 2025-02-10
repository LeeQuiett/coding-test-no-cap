import java.util.*;
import java.io.*;

public class Main {
    
    public static int minSensorRange(int n, int k, int[] sensors) {
        // 센서 위치 정렬
        Arrays.sort(sensors);

        // 인접한 센서 간의 거리 계산
        List<Integer> distances = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            distances.add(sensors[i] - sensors[i - 1]);
        }

        // 거리를 정렬하여 가장 큰 거리부터 처리
        Collections.sort(distances, Collections.reverseOrder());

        // 전체 거리 합 계산
        int result = distances.stream().mapToInt(Integer::intValue).sum();

        // k-1개의 가장 큰 거리를 제외
        for (int i = 0; i < Math.min(k - 1, n - 1); i++) {
            result -= distances.get(i);
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] sensors = Arrays.stream(br.readLine().split(" "))
                              .mapToInt(Integer::parseInt)
                              .toArray();

        System.out.println(minSensorRange(n, k, sensors));
    }
}
