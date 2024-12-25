import java.util.*;

public class BeverageDelivery {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] target = new int[N];

        for (int i = 0; i < N; i++) {
            target[i] = scanner.nextInt();
        }

        List<String> result = processBeverages(N, target);

        if (result.contains("NO")) {
            System.out.println("NO");
        } else {
            for (String action : result) {
                System.out.println(action);
            }
        }
    }

    public static List<String> processBeverages(int n, int[] target) {
        Queue<Integer> queue = new LinkedList<>();
        List<String> result = new ArrayList<>();
        int current = 1;

        for (int drink : target) {
            while (current <= drink) {
                queue.add(current); // 목표 음료수를 큐에 넣기
                result.add("ENQUEUE");
                current++;
            }

            if (!queue.isEmpty() && queue.peek() == drink) {
                queue.poll(); // 큐에서 음료수를 꺼냄
                result.add("DEQUEUE");
            } else {
                return Collections.singletonList("NO");
            }
        }

        return result;
    }
}
