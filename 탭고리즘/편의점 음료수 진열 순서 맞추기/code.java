import java.util.*;

public class BeverageOrganizer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] target = new int[N];

        for (int i = 0; i < N; i++) {
            target[i] = scanner.nextInt();
        }

        List<String> result = organizeDrinks(N, target);

        if (result.contains("NO")) {
            System.out.println("NO");
        } else {
            for (String action : result) {
                System.out.println(action);
            }
        }
    }

    public static List<String> organizeDrinks(int n, int[] target) {
        Stack<Integer> stack = new Stack<>();
        List<String> result = new ArrayList<>();
        int current = 1;

        for (int drink : target) {
            while (current <= drink) {
                stack.push(current); // 스택에 음료수를 PUSH
                result.add("PUSH");
                current++;
            }

            if (!stack.isEmpty() && stack.peek() == drink) {
                stack.pop(); // 스택에서 음료수를 POP
                result.add("POP");
            } else {
                return Collections.singletonList("NO");
            }
        }

        return result;
    }
}
